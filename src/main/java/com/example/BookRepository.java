package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "book.genre", defaultValue = "IT")
    String genre;

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1,"Understanding Quarkus", "Yigit", 2023, genre),
                new Book(2,"Lord of the Rings", "J.R.R. Tolkien", 1954, genre),
                new Book(3,"Harry Potter", "J. K. Rowling", 1997, genre)
        );
    }

    public int countAllBooks(){
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
