package com.fsd.book.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fsd.book.models.Subject;

@RunWith(MockitoJUnitRunner.class)
public class SubjectRepositoryTest {

	
	@Mock
	SubjectRepository subjectRepository;
	
	
	@Test
	public void saveSubjectTest() {
		Subject subjectInput = new Subject();
		subjectInput.setSubjectId(new Random().nextInt());
		subjectInput.setSubjectTitle("Angular Testing");
		subjectInput.setDurationInHours(45);
		subjectRepository.save(subjectInput);
	}
	
	@Test
	public void subjectDeleteByTitleTest(){
		Subject subjectInput = new Subject();
		subjectInput.setSubjectId(new Random().nextInt());
		subjectInput.setSubjectTitle("Angular Testing");
		subjectInput.setDurationInHours(45);
		subjectRepository.deleteSubjectBySubjectTitle("Angular Testing");
	}
	
	@Test
	public void bookFindByIdTest() {
		List<Subject> subjectList = new ArrayList<Subject>();
		Subject subjectInput = new Subject();
		subjectInput.setSubjectId(123);
		subjectInput.setSubjectTitle("Angular Testing");
		subjectInput.setDurationInHours(45);
		subjectList.add(subjectInput);
		when(subjectRepository.findBySubjectId(123)).thenReturn(subjectList);
	    List<Subject> subListRes = subjectRepository.findBySubjectId(123);
		assertEquals(1, subListRes.size());
	}
    

	
}
