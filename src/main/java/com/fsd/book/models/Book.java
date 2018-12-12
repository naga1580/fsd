package com.fsd.book.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    private Integer bookId;
    private String title;
    private double price;
    private Integer volume;
    @Column(name="publishDate")
    private Date publishDate;
    @Column(name="subjectId")
	private Integer subjectId;
 


	public Book() {

    }
	
	public Book(Integer bookId, String title, double price, Integer volume, Date publishDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.volume = volume;
        this.publishDate = publishDate;
    }

    public Book(Integer bookId, String title, double price, Integer volume, Date publishDate,Integer subjectId) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.volume = volume;
        this.publishDate = publishDate;
        this.subjectId = subjectId;
    }

    // private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", publishDate=" + publishDate +
                '}';
    }




    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }



    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Integer getVolume() {
        return volume;
    }

    public Date getPublishDate() {
        return publishDate;
    }
    

 	
    public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	@Id
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookid) {
		this.bookId = bookid;
	}
 	


}
