package com.greatlearning.CollegeFest.services;

import java.util.List;

import com.greatlearning.CollegeFest.entities.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public void save(Student student);
	
	public Student findById(long id);
	
	public void deleteById(long id);
}
