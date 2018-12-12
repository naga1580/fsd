package com.fsd.book.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fsd.book.models.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest {
	
	@Mock
	BookRepository bookRepository;
	
	
	@Test
	public void saveBookTest() {
		Book bookInput = new Book();
		bookInput.setBookId(new Random().nextInt());
		bookInput.setTitle("Test Programming");
		bookInput.setPrice(1000);
		bookInput.setVolume(2);
		bookInput.setSubjectId(234);
		bookInput.setPublishDate(randomDateGenerator());
		bookRepository.save(bookInput);
	    assertNotNull(bookInput.getTitle());
	    assertEquals("Test Programming", bookInput.getTitle());
	}

	@Test
	public void bookDeleteByTitleTest(){
		List<Book> bookList = new ArrayList<Book>();
		Book bookInput = new Book(new Random().nextInt(),"Test Programming-1",1000.00,2,randomDateGenerator(),234);
		bookList.add(bookInput);
		bookRepository.deleteBookByTitle("Test Programming-1");
	}
	
	@Test
	public void bookFindByIdTest() {
		List<Book> bookList = new ArrayList<Book>();
		Book bookInput = new Book(123,"Test Programming-1",1000.00,2,randomDateGenerator(),234);
		bookList.add(bookInput);
		when(bookRepository.findByBookId(123)).thenReturn(bookList);
	    List<Book> bookListRes = bookRepository.findByBookId(123);
		assertEquals(1, bookListRes.size());
	}
	
	
	public static java.sql.Date randomDateGenerator(){
		/*		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date dateStr;*/
				GregorianCalendar gc = new GregorianCalendar();
		        int year = randBetween(1900, 2010);
		        gc.set(gc.YEAR, year);
		        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		        gc.set(gc.DAY_OF_YEAR, dayOfYear);
		        java.sql.Date dateDB = new java.sql.Date(gc.getTimeInMillis());
		        return dateDB;
			}
			
		    public static int randBetween(int start, int end) {
		        return start + (int)Math.round(Math.random() * (end - start));
		    }
	
}
