package com.fsd.book.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsd.book.models.Book;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book,Integer> {
	
	List<Book> findByTitle(String bookTitle);
	
    @Modifying
    @Transactional
    @Query("delete from Book u where u.title = ?1")
    void deleteBookByTitle(String bookTitle);
    
    List<Book> findByBookId(int bookId);
    
} 
