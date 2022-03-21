package com.bookClub.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookClub.models.Book;
import com.bookClub.repositories.BookRepository;


@Service
public class BookService {
	@Autowired
    private BookRepository bookRepo;
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public Book updateBook(Book book) {
		Book book1 = bookRepo.findById(book.getId()).orElse(null);
		assert book!=null;
		book1.setTitle(book.getTitle());
		book1.setAuthor(book.getAuthor());
		book1.setThought(book.getThought());
		return bookRepo.save(book1);
	}
}
