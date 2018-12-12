package com.fsd.book;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.book.bo.impl.BookBoImpl;
import com.fsd.book.bo.impl.SubjectBoImpl;
import com.fsd.book.models.Book;
import com.fsd.book.models.Subject;
import com.fsd.book.models.UserInput;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	BookBoImpl bookBo;
	
	@Autowired
	SubjectBoImpl subjectBo;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ResponseEntity<?> addBook(@RequestBody UserInput userInput) {
		Book bookInput = new Book();
		bookInput.setBookId(new Random().nextInt());
		bookInput.setTitle(userInput.getTitle());
		bookInput.setPrice(userInput.getPrice());
		bookInput.setVolume(userInput.getVolume());
		bookInput.setSubjectId(userInput.getSubjectId());
		bookInput.setPublishDate(randomDateGenerator());
		bookBo.save(bookInput);
		return new ResponseEntity<>(bookInput, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.POST)
	public ResponseEntity<?> addSubject(@RequestBody UserInput userInput) {
		Subject subjectInput = new Subject();
		subjectInput.setSubjectId(new Random().nextInt());
		subjectInput.setSubjectTitle(userInput.getSubjectTitle());
		subjectInput.setDurationInHours(userInput.getDurationInHours());
		subjectBo.save(subjectInput);
		return new ResponseEntity<>(subjectInput, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getbook", method = RequestMethod.POST)
	  public ResponseEntity<?> getBook(@RequestBody UserInput userInput) {
		List<Book> book = new ArrayList<Book>();
		if(!userInput.getTitle().isEmpty()){
			book = bookBo.bookSearch(userInput.getTitle());
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getsubject", method = RequestMethod.POST)
	  public ResponseEntity<?> getSubject(@RequestBody UserInput userInput) {
		List<Subject> subject = new ArrayList<Subject>();
		if(!userInput.getSubjectTitle().isEmpty()){
			subject = subjectBo.subjectSearch(userInput.getSubjectTitle());
		}
		return new ResponseEntity<>(subject, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/deletebook", method = RequestMethod.POST)
	  public ResponseEntity<?> deleteBook(@RequestBody UserInput userInput) {
		if(!userInput.getTitle().isEmpty()){
			bookBo.delete(userInput.getTitle());
		}
		return new ResponseEntity<>("success", HttpStatus.NO_CONTENT);
	  }
	
	@RequestMapping(value = "/deletesubject", method = RequestMethod.POST)
	  public ResponseEntity<?> deleteSubject(@RequestBody UserInput userInput) {
		if(!userInput.getSubjectTitle().isEmpty()){
			subjectBo.delete(userInput.getSubjectTitle());
		}
		return new ResponseEntity<>("success", HttpStatus.NO_CONTENT);
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
