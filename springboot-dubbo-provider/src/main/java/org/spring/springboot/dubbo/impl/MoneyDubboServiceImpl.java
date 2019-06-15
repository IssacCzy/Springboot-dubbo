package org.spring.springboot.dubbo.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.MoneyEntity;
import org.spring.springboot.dubbo.MoneyDubboService;
import org.spring.springboot.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fescar.core.context.RootContext;

@Service(version = "1.0.0")
@Component
public class MoneyDubboServiceImpl implements MoneyDubboService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MoneyService moneyService;

	@Override
	public int update(MoneyEntity money) {
		
		logger.info("-----------远程被调用：{}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
		
		
//		logger.info("-----------全局事务标识： {}",RootContext.getXID());
		
		//模拟异常
        //Integer.parseInt("2u");

		return moneyService.update(money);
	}
	
}
