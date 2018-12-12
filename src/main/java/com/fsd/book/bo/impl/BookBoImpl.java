package com.fsd.book.bo.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.book.models.Book;
import com.fsd.book.repository.BookRepository;

@Service("bookBo")
public class BookBoImpl {

	@Autowired
	BookRepository bookDao;

	@Transactional
	public void save(Book book) {
		bookDao.save(book);

	}

	public void delete(String bookTitle) {
		bookDao.deleteBookByTitle(bookTitle);

	}


	public List<Book> bookSearch(String bookTitle) {
		List<Book> bookList = bookDao.findByTitle(bookTitle);
		return bookList;
	}


	public List<Book> bookSearchBySubject(int subjectId) {
		return null;
	}


	public List<Book> sortBookByTitle() {
		return null;
	}


	public List<Book> sortBookByPublishDate() {
		return null;
	}

}
