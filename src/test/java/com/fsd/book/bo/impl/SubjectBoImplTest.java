package com.fsd.book.bo.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fsd.book.models.Subject;
import com.fsd.book.repository.SubjectRepository;

@RunWith(MockitoJUnitRunner.class)
public class SubjectBoImplTest {
	
	@Mock
	SubjectRepository subjectDao;
	
	@InjectMocks
	SubjectBoImpl subjectBoImpl;
	
	
	@Test
	public void saveSubjectTest() {
		Subject subjectInput = new Subject();
		subjectInput.setSubjectId(new Random().nextInt());
		subjectInput.setSubjectTitle("Angular Testing");
		subjectInput.setDurationInHours(45);
		subjectBoImpl.save(subjectInput);
		verify(subjectDao, times(1)).save(subjectInput);
	}
	

	@Test
	public void subjectSearchTest() {
		List<Subject> subjectList = new ArrayList<Subject>();
		Subject subjectInput = new Subject();
		subjectInput.setSubjectId(new Random().nextInt());
		subjectInput.setSubjectTitle("Angular Testing");
		subjectInput.setDurationInHours(45);
		subjectList.add(subjectInput);
		when(subjectDao.findBySubjectTitle("Angular Testing")).thenReturn(subjectList);
		List<Subject> subListRes = subjectBoImpl.subjectSearch("Angular Testing");
		assertEquals(1, subListRes.size());
	}
	
	
	@Test
	public void subjectDelete(){
		List<Subject> subjectList = new ArrayList<Subject>();
		Subject subjectInput = new Subject();
		subjectInput.setSubjectId(new Random().nextInt());
		subjectInput.setSubjectTitle("Angular Testing");
		subjectInput.setDurationInHours(45);
		subjectList.add(subjectInput);
		when(subjectDao.findBySubjectTitle("Angular Testing")).thenReturn(subjectList);
		List<Subject> subListRes = subjectBoImpl.subjectSearch("Angular Testing");
		subjectBoImpl.delete("Angular Testing");
		verify(subjectDao, times(1)).deleteSubjectBySubjectTitle("Angular Testing");
		assertEquals(1, subListRes.size());
	}
	

}
