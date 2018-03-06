package com.tangj.springboot.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangj.springboot.domain.User;
import com.tangj.springboot.mapper.UserRepository;

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

	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("/getUserList")
	public List<User> getUserList() {
		int page = 1, size = 10;
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		Page<User> userPage = userRepository.findByUserName("testName", pageable);
		return userPage.getContent();
	}

}
