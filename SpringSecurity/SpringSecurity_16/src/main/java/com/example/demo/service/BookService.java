package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
@Service
public class BookService {
    @Autowired
    private BookRepository repo;
    public Book addBook(Book book) {
        return repo.save(book);
    }
    public List<Book> getAllBooks() {
        return repo.findAll();
    }
    public Book getBookById(Long id) {
        return repo.findById(id).orElse(null);
    }
    public Book updateBook(Long id, Book book) {
        Book existing = repo.findById(id).orElse(null);
        if(existing != null) {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setPrice(book.getPrice());
            existing.setCategory(book.getCategory());

            return repo.save(existing);
        }

        return null;
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}