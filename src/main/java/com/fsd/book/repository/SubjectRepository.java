package com.fsd.book.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsd.book.models.Subject;

@Repository
@Transactional
public interface SubjectRepository extends CrudRepository<Subject,Integer> { 
    
	List<Subject> findBySubjectTitle(String subjectTitle);
	
    @Modifying
    @Transactional
    @Query("delete from Subject u where u.subjectTitle = ?1")
    void deleteSubjectBySubjectTitle(String subjectTitle);
    
    List<Subject> findByDurationInHours(Integer durationInHours);
    
    List<Subject> findBySubjectId(Integer subjectId);
} 
