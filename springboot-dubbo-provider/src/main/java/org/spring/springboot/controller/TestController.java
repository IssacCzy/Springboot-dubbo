package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.MoneyEntity;
import org.spring.springboot.domain.UserEntity;
import org.spring.springboot.service.MoneyService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;


@RestController
public class TestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MoneyService moneyService;
	
	@Autowired
	private UserService userService;


	@RequestMapping("/a")
	//@GlobalTransactional(name = "springboot-dubbo-provider")
	public String update() {
		
		moneyService.update(new MoneyEntity(1, 2222));
		userService.update(new UserEntity(3,"ttt","ttt"));
		moneyService.update(new MoneyEntity(1, 44444));
		
		return "Success";
	}
}
