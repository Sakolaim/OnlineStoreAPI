ackage com.library.services;

import com.library.models.Book;
import com.library.repositories.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }
}