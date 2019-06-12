package org.spring.springboot.dubbo.impl;

import java.util.List;

import org.spring.springboot.domain.UserEntity;
import org.spring.springboot.dubbo.UserDubboService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
@Component
public class UserDubboServiceImpl implements UserDubboService {

	@Autowired
	private UserService userService;

	@Override
	public UserEntity findUserByName(String userName) {
		return userService.selectByUserName(userName);
	}

	@Override
	public int insertUser(UserEntity userEntity) {
		return userService.insertUser(userEntity);
	}

	@Override
	public int delete(int userId) {
		return userService.delete(userId);
	}

	@Override
	public int update(UserEntity userEntity) {
		return userService.update(userEntity);
	}

	@Override
	public List<UserEntity> selectUserList() {
		return userService.selectUserList();
	}
}
