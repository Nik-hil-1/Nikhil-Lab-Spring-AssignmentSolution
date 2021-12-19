package com.greatlearning.CollegeFest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.CollegeFest.entities.Student;
import com.greatlearning.CollegeFest.repo.StudentRepository;
import com.greatlearning.CollegeFest.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return studentRepository.getById(id);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}
