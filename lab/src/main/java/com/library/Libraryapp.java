package com.library;

import com.library.models.Book;
import com.library.repositories.BookRepository;
import com.library.services.BookService;
import com.library.services.LibraryManager;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        LibraryManager libraryManager = LibraryManager.getInstance(bookService);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Показать все книги");
            System.out.println("2. Добавить книгу");
            System.out.println("3. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    libraryManager.displayAllBooks();
                    break;
                case 2:
                    System.out.print("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите год: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(0, title, author, year);
                    bookService.addBook(book);
                    System.out.println("Книга добавлена!");
                    break;
                case 3:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}