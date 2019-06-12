package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.dao.IUserDAO;
import org.spring.springboot.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserDAO{
	@Autowired
	private IUserDAO userMapper;
	
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
