package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.UserEntity;
import org.spring.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserService implements UserMapper{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserEntity selectByUserName(String username){
		UserEntity userEntity = userMapper.selectByUserName(username);
		return userEntity;
	}

	@Override
	public int insertUser(UserEntity userEntity) {
		return userMapper.insertUser(userEntity);
	}

	@Override
	public int delete(int userId) {
		return userMapper.delete(userId);
	}

	@Override
	public int update(UserEntity userEntity) {
		return userMapper.update(userEntity);
	}

	@Override
	public List<UserEntity> selectUserList() {
		return userMapper.selectUserList();
	}

}
