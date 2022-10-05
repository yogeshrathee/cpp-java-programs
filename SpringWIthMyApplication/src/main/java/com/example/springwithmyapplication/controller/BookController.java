package com.example.springwithmyapplication.controller;

import com.example.springwithmyapplication.model.Book;
import com.example.springwithmyapplication.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @PostMapping("/bookSave")
    public String insertBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return "your record is saved successfully !!!";
    }

    @PostMapping("/multiplebookSave")
    public String insertBook(@RequestBody List<Book> book)
    {
        bookRepository.saveAll(book);
        return "your multiple records is saved successfully !!!";
    }
}
