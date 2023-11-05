package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1,"Understanding Quarkus", "Yigit", 2023, "IT"),
                new Book(2,"Lord of the Rings", "J.R.R. Tolkien", 1954, "High-Fantasy"),
                new Book(3,"Harry Potter", "J. K. Rowling", 1997, "High-Fantasy")
        );
    }

    public int countAllBooks(){
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
