package org.spring.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.MoneyEntity;

@Mapper
public interface MoneyMapper {

	public int update(MoneyEntity money);

}
