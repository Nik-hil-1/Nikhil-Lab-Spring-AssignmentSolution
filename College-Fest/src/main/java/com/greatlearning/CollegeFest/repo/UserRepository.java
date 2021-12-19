package com.greatlearning.CollegeFest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.CollegeFest.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User getByUsername(String password);
}
