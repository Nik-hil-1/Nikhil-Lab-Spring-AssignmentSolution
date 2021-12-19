package com.greatlearning.CollegeFest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.CollegeFest.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
