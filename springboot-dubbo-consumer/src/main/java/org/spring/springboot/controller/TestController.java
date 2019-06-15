package org.spring.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.MoneyEntity;
import org.spring.springboot.domain.UserEntity;
import org.spring.springboot.dubbo.MoneyDubboConsumerService;
import org.spring.springboot.dubbo.UserDubboConsumerService;
import org.spring.springboot.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;

@RestController
public class TestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDubboConsumerService userDubboConsumerService;

	@Autowired
	private MoneyDubboConsumerService moneyDubboConsumerService;

	@Autowired
	private MoneyService moneyService;

	@RequestMapping("/select")
	public String getRemoteUserInfo() {
		String userName = "admin";
		UserEntity userEntity = userDubboConsumerService.selectByUserName(userName);
		return userEntity.toString();
	}

	@RequestMapping("/insert")
	public int insert() {
		return userDubboConsumerService.insertUser(new UserEntity("cccc", "cccc"));
	}

	@RequestMapping("/del")
	public int del() {
		int id = 5;
		return userDubboConsumerService.delete(id);
	}

	@RequestMapping("/update")
	public int update() {
		return userDubboConsumerService.update(new UserEntity(3, "666", "6666"));
	}

	@RequestMapping("/a")
	@GlobalTransactional(name = "demo",timeoutMills=300*1000)
	public String transfer() {
		
		logger.info("-----------全局事务开始：{}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
		
		//logger.info("-----------全局事务标识： {}",RootContext.getXID());

		int result = moneyService.update(new MoneyEntity(1, 99999));
		
		logger.info("-----------本地事务完成，同时开始远程事务：{}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
		
		
		int remoteResult = moneyDubboConsumerService.update(new MoneyEntity(1, 88888));
		System.out.println(result + "][" + remoteResult);
		return "Success";
	}
}
