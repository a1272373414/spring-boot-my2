package com.tangj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangj.springboot.domain.UserRepository;
import com.tangj.springboot.property.NeoProperties;

@RestController
public class HelloWorldController {

	@Autowired
	private NeoProperties neoProperties;// 使用自定义配置的属性

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/hello")
	public String index() {
		System.out.println("--------------" + neoProperties.getTitle());
		String nickName = userRepository.findByUserNameLike("%bb2%").getNickName();
		System.out.println(nickName);
		return "Hello World";
	}
}
