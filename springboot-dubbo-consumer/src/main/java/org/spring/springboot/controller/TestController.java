package org.spring.springboot.controller;

import org.spring.springboot.domain.UserEntity;
import org.spring.springboot.dubbo.UserDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private UserDubboConsumerService userDubboConsumerService;

	@RequestMapping("/select")
	public String getRemoteUserInfo() {
		String userName = "admin";
		UserEntity userEntity = userDubboConsumerService.selectByUserName(userName);
		return userEntity.toString();
	}

	@RequestMapping("/insert")
	public int insert() {
		return userDubboConsumerService.insertUser(new UserEntity("Issac", "Issac"));
	}

	@RequestMapping("/del")
	public int del() {
		int id = 1;
		return userDubboConsumerService.delete(id);
	}

	@RequestMapping("/update")
	public int update() {
		return userDubboConsumerService.update(new UserEntity(2, "Issac", "Issac"));
	}
}
