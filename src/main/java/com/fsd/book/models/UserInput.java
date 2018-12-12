package com.fsd.book.models;

import java.util.List;

public class UserInput {
	
	private String title;
    private double price;
    private Integer volume;
    private String subjectTitle;
    private Integer subjectId;
    private List<Subject> subjectList;

    private Integer durationInHours;
    
        
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public Integer getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(Integer durationInHours) {
		this.durationInHours = durationInHours;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

}
