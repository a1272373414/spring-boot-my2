package com.tangj.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tangj.springboot.domain.User;
import com.tangj.springboot.domain.UserRepository;
import com.tangj.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User findByUserNameLike(String userName) {
		return userRepository.findByUserNameLike(userName);
	}

	@Override
	public User findByUserNameOrEmail(String userName, String email) {
		return userRepository.findByUserNameOrEmail(userName, email);
	}

	@Override
	public Page<User> findByUserName(String userName, Pageable pageable) {
		return userRepository.findByUserName(userName, pageable);
	}

	@Override
	public List<User> findByUserName(String userName, Sort sort) {
		return userRepository.findByUserName(userName, sort);
	}

}
