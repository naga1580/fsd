package com.fsd.book.bo.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.book.models.Subject;
import com.fsd.book.repository.SubjectRepository;

@Service("subjectBo")
public class SubjectBoImpl {

	@Autowired
	SubjectRepository subjectDao;
	
	@Transactional
	public void save(Subject subj) {
		subjectDao.save(subj);

	}


	public void delete(String subjectTitle) {
		subjectDao.deleteSubjectBySubjectTitle(subjectTitle);

	}


	public List<Subject> subjectSearch(String subjectTitle) {
		List<Subject> subjectList = subjectDao.findBySubjectTitle(subjectTitle);
		return subjectList;
	}
	
	public List<Subject> subjectSearchByDurationInHours(Integer durationInHours) {
		List<Subject> subjectList = subjectDao.findByDurationInHours(durationInHours);
		return subjectList;
	}

}
