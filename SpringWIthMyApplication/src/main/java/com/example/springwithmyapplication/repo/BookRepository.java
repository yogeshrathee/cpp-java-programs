package com.example.springwithmyapplication.repo;

import com.example.springwithmyapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {


}
