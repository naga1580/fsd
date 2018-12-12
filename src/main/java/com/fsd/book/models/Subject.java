package com.fsd.book.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer subjectId;
    private String subjectTitle;
    private Integer durationInHours;

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subtitle='" + subjectTitle + '\'' +
                ", durationInHours=" + durationInHours +
                '}';
    }

	public String getSubjectTitle() {
		return subjectTitle;
	}


	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
    

    @Id
    @Column(name = "subjectId", unique = true, nullable = false)
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(Integer durationInHours) {
        this.durationInHours = durationInHours;
    }


}
