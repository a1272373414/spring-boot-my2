package com.tangj.springboot.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	User findByUserNameLike(String userName);

	User findByUserNameOrEmail(String userName, String email);

	Page<User> findByUserName(String userName, Pageable pageable);

	List<User> findByUserName(String userName, Sort sort);

}