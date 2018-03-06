package com.tangj.springboot.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangj.springboot.domain.User;
import com.tangj.springboot.domain.UserRepository;

@RestController
public class UserController {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(UserController.class);// 日志

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/getUser")
	@Cacheable(value = "user-key") // 自动根据方法生成缓存
	public User getUser() {
		User user = userRepository.findByUserName("aa");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}

	@RequestMapping("/getUserSession")
	String getUserSession(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}

}
