package com.library.services;

public class LibraryManager {
    private static LibraryManager instance;
    private final BookService bookService;

    private LibraryManager(BookService bookService) {
        this.bookService = bookService;
    }

    public static LibraryManager getInstance(BookService bookService) {
        if (instance == null) {
            instance = new LibraryManager(bookService);
        }
        return instance;
    }

    public void displayAllBooks() {
        bookService.getAllBooks().forEach(System.out::println);
    }
}