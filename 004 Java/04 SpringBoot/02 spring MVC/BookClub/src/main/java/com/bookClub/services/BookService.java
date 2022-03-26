package com.bookClub.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bookClub.models.Book;
import com.bookClub.models.User;
import com.bookClub.repositories.BookRepository;


@Service
public class BookService {
	
    private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

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
		assert book1!=null;
		book1.setTitle(book.getTitle());
		book1.setAuthor(book.getAuthor());
		book1.setThought(book.getThought());
		return bookRepo.save(book1);
	}
	
	public List<Book> toborrowBooks(Long id){
		Optional <List<Book>> books = bookRepo.findByBorrowId(id);
		if(books.isPresent()) {
    		return books.get();
    	}else {
    		return null;
    	}
		
	}
	public List<Book> borrowBooks(Long id){
		Optional <List<Book>> books=bookRepo.findByBorrowId(id);
		if(books.isPresent()) {
    		return books.get();
    	}else {
    		return null;
    	}
		
	}
	
	public Book borrow(Long id1 , User user) {
		Book book1 = bookRepo.findById(id1).orElse(null);
		assert book1!=null;
		book1.setBorrow(user);

		return bookRepo.save(book1);
	}
	
	public Book returnBook(Long id1 , User user) {
		Book book1 = bookRepo.findById(id1).orElse(null);
		assert book1!=null;
		book1.setBorrow(null);

		return bookRepo.save(book1);
	}
	
	public void delete(Long id) {
        Book deleteBook = bookRepo.findById(id).orElse(null); 
        bookRepo.delete(deleteBook);
      }
}
