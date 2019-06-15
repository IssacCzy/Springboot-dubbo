package org.spring.springboot.dubbo;

import org.spring.springboot.domain.MoneyEntity;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component
public class MoneyDubboConsumerService {

	@Reference(version = "1.0.0")
	MoneyDubboService moneyDubboService;

	public int update(MoneyEntity moneyEntity) {
		return moneyDubboService.update(moneyEntity);
	}
}
