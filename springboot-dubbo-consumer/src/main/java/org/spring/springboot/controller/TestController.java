package org.spring.springboot.controller;

import org.spring.springboot.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private CityDubboConsumerService cityDubboConsumerService;

	@RequestMapping("/hello")
	public String sayHello() {
		cityDubboConsumerService.printCity();
		return "success";
	}

}
