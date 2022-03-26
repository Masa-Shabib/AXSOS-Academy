package com.bookClub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bookClub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List <Book> findAll();
	Optional <List<Book>> findByBorrowId(Long id);
}
