package edu.kcg.futurelab.sample.springboot.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.kcg.futurelab.sample.springboot.service.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);

	List<User> findAllByDisplayNameContains(String keyword);
}
