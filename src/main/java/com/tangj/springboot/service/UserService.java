package com.tangj.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tangj.springboot.domain.User;

public interface UserService {
	User findByUserName(String userName);

	User findByUserNameLike(String userName);

	User findByUserNameOrEmail(String userName, String email);

	Page<User> findByUserName(String userName, Pageable pageable);

	List<User> findByUserName(String userName, Sort sort);
}
