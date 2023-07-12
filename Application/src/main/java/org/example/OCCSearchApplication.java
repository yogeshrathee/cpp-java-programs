package org.example;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OCCSearchApplication extends Application {
    private List<TextField> searchFields;
    private Connection connection;

    private TextField dbNameField;
    private TextField usernameField;
    private PasswordField passwordField;
    private TextField tableNameField;

    private TableView<ResultEntry> resultTable;
    private TableView<TableEntry> tableListTable;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("OCC (Online Compliance Check) System");

        // Create update record button
        Button updateRecordButton = new Button("Update Record");
        updateRecordButton.setOnAction(e -> {
            // Update the selected record in the table
            updateRecord();
        });

        // Create update column name button
        Button updateColumnNameButton = new Button("Update Column Name");
        updateColumnNameButton.setOnAction(e -> {
            // Update the selected column name in the table
            updateColumnName();
        });

        // Create update column value button
        Button updateColumnValueButton = new Button("Update Column Value");
        updateColumnValueButton.setOnAction(e -> {
            // Update the selected column value in the table
            updateColumnValue();
        });

        // Create delete record button
        Button deleteRecordButton = new Button("Delete Record");
        deleteRecordButton.setOnAction(e -> {
            // Delete the selected record from the table
            deleteRecord();
        });

        // Create search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            // Perform search and display response
            performSearch();
        });

        // Create add entry button
        Button addEntryButton = new Button("Add Entry");
        addEntryButton.setOnAction(e -> {
            // Add entry to the table
            addEntryToTable();
        });

        // Create show table button
        Button showTableButton = new Button("Show Tables");
        showTableButton.setOnAction(e -> {
            // Show all tables for the connected database
            showTables();
        });

        // Create show table data button
        Button showTableDataButton = new Button("Show Table Data");
        showTableDataButton.setOnAction(e -> {
            // Show the data inside the selected table
            TableEntry selectedTable = tableListTable.getSelectionModel().getSelectedItem();
            if (selectedTable != null) {
                String tableName = selectedTable.getTableName();
                showTableData(tableName);
            }
        });

        // Create database connection button
        Button connectButton = new Button("Connect");
        connectButton.setOnAction(e -> {
            // Connect to the database
            String dbName = dbNameField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String tableName = tableNameField.getText();
            if (tableName.isEmpty()) {
                showAlert("Table Name Missing", "Please enter a table name.");
                return;
            }
            if (connectToDatabase(dbName, username, password, tableName)) {
                // Enable search, add entry, show table buttons after successful connection
                searchButton.setDisable(false);
                addEntryButton.setDisable(false);
                showTableButton.setDisable(false);
                showTableDataButton.setDisable(false);
            }
        });

        // Create database connection panel
        GridPane dbPanel = new GridPane();
        dbPanel.setHgap(5);
        dbPanel.setVgap(5);
        dbPanel.setAlignment(Pos.TOP_CENTER);

        // Create database input fields
        Label dbNameLabel = new Label("Database Name:");
        dbNameField = new TextField();

        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        Label tableNameLabel = new Label("Table Name:");
        tableNameField = new TextField();

        dbPanel.addRow(0, dbNameLabel, dbNameField);
        dbPanel.addRow(1, usernameLabel, usernameField);
        dbPanel.addRow(2, passwordLabel, passwordField);
        dbPanel.addRow(3, tableNameLabel, tableNameField);
        dbPanel.add(connectButton, 2, 4);

        // Create search field
        Label searchLabel = new Label("Search:");
        TextField searchField = new TextField();
        searchFields = new ArrayList<>();
        searchFields.add(searchField);

        // Add search field to the database connection panel
        dbPanel.addRow(5, searchLabel, searchField);

        // Disable search, add entry, show table, and show table data buttons until connected
        searchButton.setDisable(true);
        addEntryButton.setDisable(true);
        showTableButton.setDisable(false);
        showTableDataButton.setDisable(false);

        // Create result table
        resultTable = new TableView<>();
        TableColumn<ResultEntry, String> columnNameColumn = new TableColumn<>("Column Name");
        columnNameColumn.setCellValueFactory(cellData -> cellData.getValue().columnNameProperty());

        TableColumn<ResultEntry, String> columnValueColumn = new TableColumn<>("Column Value");
        columnValueColumn.setCellValueFactory(cellData -> cellData.getValue().columnValueProperty());

        resultTable.getColumns().addAll(columnNameColumn, columnValueColumn);

        // Create table list table
        tableListTable = new TableView<>();
        TableColumn<TableEntry, String> tableNameColumn = new TableColumn<>("Table Name");
        tableNameColumn.setCellValueFactory(new PropertyValueFactory<>("tableName"));

        tableListTable.getColumns().add(tableNameColumn);

        // Create search table button
        Button searchTableButton = new Button("Search Table");
        searchTableButton.setOnAction(e -> {
            // Perform table search
            String searchTableName = searchField.getText();
            if (!searchTableName.isEmpty()) {
                searchTable(searchTableName);
            } else {
                showAlert("Search Error", "Please enter a table name to search .");
            }
        });

        // Create main pane and add components
        VBox mainPane = new VBox(10);
        mainPane.setPadding(new Insets(10));
        mainPane.setAlignment(Pos.TOP_LEFT);

        mainPane.getChildren().addAll(
                dbPanel, searchButton, addEntryButton, showTableButton,
                tableListTable, showTableDataButton, resultTable,
                updateRecordButton, updateColumnNameButton,
                updateColumnValueButton, deleteRecordButton
        );

        // Create bottom pane for search table button
        HBox bottomPane = new HBox(10);
        bottomPane.setAlignment(Pos.CENTER_RIGHT);
        bottomPane.getChildren().add(searchTableButton);
        mainPane.getChildren().add(bottomPane);

        Scene scene = new Scene(mainPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void performSearch() {
        StringBuilder response = new StringBuilder();

        try {
            // Create the SQL query
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
            String tableName = tableNameField.getText();
            if (tableName.isEmpty()) {
                response.append("No table name specified.\n");
                showAlert("Search Error", "No table name specified.");
                return;
            }

            queryBuilder.append(tableName).append(" WHERE ");
            List<String> searchCriteria = new ArrayList<>();
            List<String> columnNames = getColumnNamesFromDatabase(tableName);

            for (TextField searchField : searchFields) {
                String searchValue = searchField.getText();

                if (!searchValue.isEmpty()) {
                    for (String columnName : columnNames) {
                        searchCriteria.add(columnName + " LIKE ?");
                    }
                }
            }
            if (searchCriteria.isEmpty()) {
                response.append("No search criteria specified.\n");
                showAlert("Search Error", "No search criteria specified.");
                return;
            }

            String query = queryBuilder.append(String.join(" OR ", searchCriteria)).toString();
            PreparedStatement statement = connection.prepareStatement(query);

            // Bind the search criteria parameters
            int parameterIndex = 1;
            for (TextField searchField : searchFields) {
                String searchValue = searchField.getText();
                if (!searchValue.isEmpty()) {
                    for (String columnName : columnNames) {
                        statement.setString(parameterIndex++, "%" + searchValue + "%");
                    }
                }
            }

            // Execute the query and process the result set
            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<ResultEntry> resultList = new ArrayList<>();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    resultList.add(new ResultEntry(columnName, columnValue));
                }
            }

            if (resultList.isEmpty()) {
                response.append("No matching records found.\n");
            } else {
                response.append("Matching records found successfully!\n");
            }

            // Close the statement and result set
            statement.close();
            resultSet.close();

            // Update the result table with the search results
            resultTable.getItems().setAll(resultList);

            // Show table data in a new window
            showSearchResultWindow(resultList);

            showAlert("Search Result", response.toString());
        } catch (SQLException e) {
            response.append("Error occurred during the search: ").append(e.getMessage());
            showAlert("Search Error", "An error occurred during the search: " + e.getMessage());
        }
    }
    private void showSearchResultWindow(List<ResultEntry> searchResults) {
        Stage searchResultStage = new Stage();
        searchResultStage.setTitle("Search Result");

        TableView<ResultEntry> searchResultTableView = new TableView<>();
        TableColumn<ResultEntry, String> columnNameColumn = new TableColumn<>("Column Name");
        columnNameColumn.setCellValueFactory(cellData -> cellData.getValue().columnNameProperty());

        TableColumn<ResultEntry, String> columnValueColumn = new TableColumn<>("Column Value");
        columnValueColumn.setCellValueFactory(cellData -> cellData.getValue().columnValueProperty());

        searchResultTableView.getColumns().addAll(columnNameColumn, columnValueColumn);
        searchResultTableView.getItems().setAll(searchResults);

        VBox searchResultPane = new VBox(10);
        searchResultPane.setPadding(new Insets(10));
        searchResultPane.getChildren().add(searchResultTableView);

        Scene searchResultScene = new Scene(searchResultPane, 400, 300);
        searchResultStage.setScene(searchResultScene);
        searchResultStage.show();
    }


    private void addEntryToTable() {
        String tableName = tableNameField.getText();
        if (tableName.isEmpty()) {
            showAlert("Table Name Missing", "Please enter a table name.");
            return;
        }

        List<String> columnNames = getColumnNamesFromDatabase(tableName);
        Dialog<List<String>> addEntryDialog = new Dialog<>();
        addEntryDialog.setTitle("Add Entry");
        addEntryDialog.setHeaderText("Enter the values for each column:");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        List<TextField> inputFields = new ArrayList<>();

        for (int i = 0; i < columnNames.size(); i++) {
            Label columnLabel = new Label(columnNames.get(i));
            TextField valueField = new TextField();
            grid.addRow(i, columnLabel, valueField);
            inputFields.add(valueField);
        }

        addEntryDialog.getDialogPane().setContent(grid);

        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        addEntryDialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        addEntryDialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                List<String> entryValues = new ArrayList<>();
                for (TextField field : inputFields) {
                    entryValues.add(field.getText());
                }
                return entryValues;
            }
            return null;
        });
        Optional<List<String>> result = addEntryDialog.showAndWait();

        result.ifPresent(entryValues -> {
            if (addEntryToDatabase(tableName, columnNames, entryValues)) {
                showAlert("Entry Added", "New entry added to the table successfully!");
            }
        });
    }

    // ...

    // ...

    private Stage tableListStage;
    private TableView<TableEntry> tableListTableView;

// ...

    private void showTables() {
        String dbName = dbNameField.getText();
        if (dbName.isEmpty()) {
            showAlert("Database Name Missing", "Please enter a database name.");
            return;
        }

        try {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet resultSet = metaData.getTables(dbName, null, null, null); // Filter tables by database name
                List<TableEntry> tableList = new ArrayList<>();
                while (resultSet.next()) {
                    String tableName = resultSet.getString("TABLE_NAME");
                    tableList.add(new TableEntry(tableName));
                }

                resultSet.close();

                if (tableList.isEmpty()) {
                    showAlert("Search Result", "No tables found in the database.");
                } else {
                    // Update the table list table with the table names
                    tableListTable.getItems().setAll(tableList);
                    // Show the table names in a separate window
                    showTableListWindow(tableList);
                }
            }
        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while retrieving table names: " + e.getMessage());
        }
    }

    private void showTableListWindow(List<TableEntry> tableList) {
        tableListStage = new Stage();
        tableListStage.setTitle("Table List");

        tableListTableView = new TableView<>();
        TableColumn<TableEntry, String> tableNameColumn = new TableColumn<>("Table Name");
        tableNameColumn.setCellValueFactory(new PropertyValueFactory<>("tableName"));

        tableListTableView.getColumns().add(tableNameColumn);
        tableListTableView.getItems().setAll(tableList);

        VBox tableListPane = new VBox(10);
        tableListPane.setPadding(new Insets(10));
        tableListPane.getChildren().add(tableListTableView);

        Scene tableListScene = new Scene(tableListPane, 300, 400);
        tableListStage.setScene(tableListScene);
        tableListStage.show();
    }

// ...


    private void searchTable(String searchTableName) {
        try {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet resultSet = metaData.getTables(null, null, searchTableName, null);
                List<TableEntry> tableList = new ArrayList<>();
                while (resultSet.next()) {
                    String tableName = resultSet.getString("TABLE_NAME");
                    tableList.add(new TableEntry(tableName));
                }

                resultSet.close();

                if (tableList.isEmpty()) {
                    showAlert("Search Result", "No tables found matching the search criteria.");
                } else {
                    tableListTable.getItems().setAll(tableList);
                }
            }
        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while searching for tables: " + e.getMessage());
        }
    }
    private void showTableData(String tableName) {
        StringBuilder response = new StringBuilder();
        try {
            if (connection != null) {
                String query = "SELECT * FROM " + tableName;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                List<ResultEntry> resultList = new ArrayList<>();

                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        String columnValue = resultSet.getString(i);
                        resultList.add(new ResultEntry(columnName, columnValue));
                    }
                }

                if (resultList.isEmpty()) {
                    response.append("No records found in the table.\n");
                } else {
                    response.append("Records found successfully!\n");
                }

                // Close the statement and result set
                statement.close();
                resultSet.close();

                // Update the result table with the search results
                resultTable.getItems().setAll(resultList);

                // Show table data in a new window
                showTableDataWindow(tableName, resultList);

                showAlert("Table Records", response.toString());
            }
        } catch (SQLException e) {
            response.append("Error occurred while retrieving records: ").append(e.getMessage());
            showAlert("Records Error", "An error occurred while retrieving records: " + e.getMessage());
        }
    }

    private void showTableDataWindow(String tableName, List<ResultEntry> tableData) {
        Stage tableDataStage = new Stage();
        tableDataStage.setTitle("Table Data - " + tableName);

        TableView<ResultEntry> tableDataTableView = new TableView<>();
        TableColumn<ResultEntry, String> columnNameColumn = new TableColumn<>("Column Name");
        columnNameColumn.setCellValueFactory(cellData -> cellData.getValue().columnNameProperty());

        TableColumn<ResultEntry, String> columnValueColumn = new TableColumn<>("Column Value");
        columnValueColumn.setCellValueFactory(cellData -> cellData.getValue().columnValueProperty());

        tableDataTableView.getColumns().addAll(columnNameColumn, columnValueColumn);
        tableDataTableView.getItems().setAll(tableData);

        VBox tableDataPane = new VBox(10);
        tableDataPane.setPadding(new Insets(10));
        tableDataPane.getChildren().add(tableDataTableView);

        Scene tableDataScene = new Scene(tableDataPane, 400, 300);
        tableDataStage.setScene(tableDataScene);
        tableDataStage.show();
    }

    private boolean addEntryToDatabase(String tableName, List<String> columnNames, List<String> entryValues) {
        try {
            if (connection != null) {
// Create SQL statement to insert the entry into the table
                StringBuilder sqlBuilder = new StringBuilder();
                sqlBuilder.append("INSERT INTO ")
                        .append(tableName)
                        .append(" (");
                // Append column names
                for (String columnName : columnNames) {
                    sqlBuilder.append(columnName.trim()).append(", ");
                }

// Remove the trailing comma and space
                sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());

                sqlBuilder.append(") VALUES (");

// Append entry values
                for (String entryValue : entryValues) {
                    sqlBuilder.append("'").append(entryValue.trim()).append("', ");
                }

// Remove the trailing comma and space
                sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());

                sqlBuilder.append(")");

                Statement statement = connection.createStatement();
                statement.executeUpdate(sqlBuilder.toString());
                statement.close();

                return true;
            }
        } catch (SQLException e) {
            showAlert("Add Entry Error", "An error occurred while adding entry to the table: " + e.getMessage());
        }

        return false;
    }

    private boolean connectToDatabase(String dbName, String username, String password, String tableName) {
        try {
// Establish database connection
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            connection = DriverManager.getConnection(url, username, password);

// Check if the table exists in the database
            if (!tableExists(tableName)) {
                showAlert("Table Not Found", "The specified table does not exist in the database.");
                return false;
            }

            showAlert("Database Connection", "Connected to the database successfully!");
            return true;
        } catch (SQLException e) {
            showAlert("Database Connection Failed", "Failed to connect to the database:\n" + e.getMessage());
            return false;
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private List<String> getColumnNamesFromDatabase(String tableName) {
        List<String> columnNames = new ArrayList<>();

        try {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
                while (resultSet.next()) {
                    String columnName = resultSet.getString("COLUMN_NAME");
                    columnNames.add(columnName);
                }

                resultSet.close();
            }
        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while retrieving column names: " + e.getMessage());
        }

        return columnNames;
    }

    private boolean tableExists(String tableName) {
        try {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet resultSet = metaData.getTables(null, null, tableName, null);
                boolean tableExists = resultSet.next();
                resultSet.close();

                return tableExists;
            }
        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while checking table existence: " + e.getMessage());
        }

        return false;
    }
    private void updateRecord() {
        ResultEntry selectedEntry = resultTable.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            Dialog<String> updateRecordDialog = new Dialog<>();
            updateRecordDialog.setTitle("Update Record");
            updateRecordDialog.setHeaderText("Enter the updated value for the selected record:");

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            Label columnNameLabel = new Label("Column Name:");
            Label columnValueLabel = new Label("Column Value:");

            TextField columnNameField = new TextField(selectedEntry.getColumnName());
            TextField columnValueField = new TextField(selectedEntry.getColumnValue());

            grid.addRow(0, columnNameLabel, columnNameField);
            grid.addRow(1, columnValueLabel, columnValueField);

            updateRecordDialog.getDialogPane().setContent(grid);

            ButtonType updateButton = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
            updateRecordDialog.getDialogPane().getButtonTypes().addAll(updateButton, ButtonType.CANCEL);

            updateRecordDialog.setResultConverter(dialogButton -> {
                if (dialogButton == updateButton) {
                    return columnValueField.getText();
                }
                return null;
            });

            Optional<String> result = updateRecordDialog.showAndWait();
            result.ifPresent(updatedValue -> {
                selectedEntry.columnValueProperty().set(updatedValue);
                updateRecordInDatabase(selectedEntry, selectedEntry.getColumnName(), updatedValue);
            });
        } else {
            showAlert("Update Record", "Please select a record to update.");
        }
    }

    private void updateRecordInDatabase(ResultEntry selectedEntry, String columnName, String updatedValue) {
        try {
            if (connection != null) {
                String tableName = tableNameField.getText();
                String query = "UPDATE " + tableName + " SET " + columnName + " = ? WHERE " + columnName + " = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, updatedValue);
                statement.setString(2, selectedEntry.getColumnValue());
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e) {
            showAlert("Update Record Error", "An error occurred while updating the record: " + e.getMessage());
        }
    }

    private void updateColumnName() {
        ResultEntry selectedEntry = resultTable.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            Dialog<String> updateColumnNameDialog = new Dialog<>();
            updateColumnNameDialog.setTitle("Update Column Name");
            updateColumnNameDialog.setHeaderText("Enter the updated column name:");

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            Label columnNameLabel = new Label("Column Name:");
            TextField columnNameField = new TextField(selectedEntry.getColumnName());

            grid.addRow(0, columnNameLabel, columnNameField);

            updateColumnNameDialog.getDialogPane().setContent(grid);

            ButtonType updateButton = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
            updateColumnNameDialog.getDialogPane().getButtonTypes().addAll(updateButton, ButtonType.CANCEL);

            updateColumnNameDialog.setResultConverter(dialogButton -> {
                if (dialogButton == updateButton) {
                    return columnNameField.getText();
                }
                return null;
            });

            Optional<String> result = updateColumnNameDialog.showAndWait();
            result.ifPresent(updatedColumnName -> {
                // Update the selected record with the updated column name
                selectedEntry.columnNameProperty().set(updatedColumnName);
                // Update the corresponding column name in the database
                updateColumnNameInDatabase(selectedEntry.getColumnName(), updatedColumnName);
            });
        } else {
            showAlert("Update Column Name", "Please select a record to update the column name.");
        }
    }

    private void updateColumnNameInDatabase(String columnName, String updatedColumnName) {
        try {
            if (connection != null) {
                String tableName = tableNameField.getText();
                String query = "ALTER TABLE " + tableName + " CHANGE " + columnName + " " + updatedColumnName;
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                statement.close();
            }
        } catch (SQLException e) {
            showAlert("Update Column Name Error", "An error occurred while updating the column name: " + e.getMessage());
        }
    }


    private void updateColumnValue() {
        ResultEntry selectedEntry = resultTable.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            Dialog<String> updateColumnValueDialog = new Dialog<>();
            updateColumnValueDialog.setTitle("Update Column Value");
            updateColumnValueDialog.setHeaderText("Enter the updated column value:");

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            Label columnValueLabel = new Label("Column Value:");
            TextField columnValueField = new TextField(selectedEntry.getColumnValue());

            grid.addRow(0, columnValueLabel, columnValueField);

            updateColumnValueDialog.getDialogPane().setContent(grid);

            ButtonType updateButton = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
            updateColumnValueDialog.getDialogPane().getButtonTypes().addAll(updateButton, ButtonType.CANCEL);

            updateColumnValueDialog.setResultConverter(dialogButton -> {
                if (dialogButton == updateButton) {
                    return columnValueField.getText();
                }
                return null;
            });

            Optional<String> result = updateColumnValueDialog.showAndWait();
            result.ifPresent(updatedColumnValue -> {
                selectedEntry.columnValueProperty().set(updatedColumnValue);
                updateColumnValueInDatabase(selectedEntry, selectedEntry.getColumnName(), updatedColumnValue);
            });
        } else {
            showAlert("Update Column Value", "Please select a record to update the column value.");
        }
    }

    private void updateColumnValueInDatabase(ResultEntry selectedEntry, String columnName, String updatedColumnValue) {
        try {
            if (connection != null) {
                String tableName = tableNameField.getText();
                String query = "UPDATE " + tableName + " SET " + columnName + " = ? WHERE " + columnName + " = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, updatedColumnValue);
                statement.setString(2, selectedEntry.getColumnValue());
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e) {
            showAlert("Update Column Value Error", "An error occurred while updating the column value: " + e.getMessage());
        }
    }


    private void deleteRecord() {
        ResultEntry selectedEntry = resultTable.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            // Delete the selected record from the table view
            resultTable.getItems().remove(selectedEntry);
            // Delete the corresponding record from the database
            deleteRecordFromDatabase(selectedEntry.getColumnName(), selectedEntry.getColumnValue());
            showAlert("Delete Record", "Record deleted successfully!");
        } else {
            showAlert("Delete Record", "Please select a record to delete.");
        }
    }

    private void deleteRecordFromDatabase(String columnName, String columnValue) {
        try {
            if (connection != null) {
                String tableName = tableNameField.getText();
                String query = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, columnValue);
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e) {
            showAlert("Delete Record Error", "An error occurred while deleting the record: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static class ResultEntry {
        private final SimpleStringProperty columnName;
        private final SimpleStringProperty columnValue;

        public ResultEntry(String columnName, String columnValue) {
            this.columnName = new SimpleStringProperty(columnName);
            this.columnValue = new SimpleStringProperty(columnValue);
        }

        public String getColumnName() {
            return columnName.get();
        }

        public SimpleStringProperty columnNameProperty() {
            return columnName;
        }

        public String getColumnValue() {
            return columnValue.get();
        }

        public SimpleStringProperty columnValueProperty() {
            return columnValue;
        }
    }

    public static class TableEntry {
        private final SimpleStringProperty tableName;

        public TableEntry(String tableName) {
            this.tableName = new SimpleStringProperty(tableName);
        }

        public String getTableName() {
            return tableName.get();
        }

        public SimpleStringProperty tableNameProperty() {
            return tableName;
        }
    }
}