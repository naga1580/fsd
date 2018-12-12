package com.fsd.book.bo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fsd.book.models.Book;
import com.fsd.book.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookBoImplTest {
	
	
	@Mock
	BookRepository bookDao;
	
	@InjectMocks
	BookBoImpl bookBoImpl;
	
	@Test
	public void saveBookTest() {
		Book bookInput = new Book();
		bookInput.setBookId(new Random().nextInt());
		bookInput.setTitle("Test Programming");
		bookInput.setPrice(1000);
		bookInput.setVolume(2);
		bookInput.setSubjectId(234);
		bookInput.setPublishDate(randomDateGenerator());
		bookBoImpl.save(bookInput);
		verify(bookDao, times(1)).save(bookInput);
	}
	
	@Test
	public void bookSearchTest() {
		List<Book> bookList = new ArrayList<Book>();
		Book bookInput = new Book(new Random().nextInt(),"Test Programming-1",1000.00,2,randomDateGenerator(),234);
		Book bookInput1 = new Book(new Random().nextInt(),"Test Programming-2",1001.00,3,randomDateGenerator(),235);
		Book bookInput2 = new Book(new Random().nextInt(),"Test Programming-3",1002.00,4,randomDateGenerator(),236);
		bookList.add(bookInput);
		/*bookList.add(bookInput1);
		bookList.add(bookInput2);*/
		when(bookDao.findByTitle("Test Programming-1")).thenReturn(bookList);
		List<Book> bookListRes = bookBoImpl.bookSearch("Test Programming-1");
		assertEquals(1, bookListRes.size());
	}
	
	
	@Test
	public void bookDelete(){
		List<Book> bookList = new ArrayList<Book>();
		Book bookInput = new Book(new Random().nextInt(),"Test Programming-1",1000.00,2,randomDateGenerator(),234);
		bookList.add(bookInput);
		when(bookDao.findByTitle("Test Programming-1")).thenReturn(bookList);
		List<Book> bookListRes = bookBoImpl.bookSearch("Test Programming-1");
		bookBoImpl.delete("Test Programming-1");
		verify(bookDao, times(1)).deleteBookByTitle("Test Programming-1");
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
