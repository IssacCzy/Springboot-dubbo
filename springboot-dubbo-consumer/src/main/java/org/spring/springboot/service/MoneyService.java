package org.spring.springboot.service;

import org.spring.springboot.domain.MoneyEntity;
import org.spring.springboot.mapper.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyService implements MoneyMapper{
	@Autowired
	private MoneyMapper moneyMapper;

	@Override
	public int update(MoneyEntity money) {
		return moneyMapper.update(money);
	}
	
}
