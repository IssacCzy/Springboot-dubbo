package org.spring.springboot.dubbo;

import java.util.List;

import org.spring.springboot.domain.UserEntity;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component
public class UserDubboConsumerService {

	@Reference(version = "1.0.0")
	UserDubboService userDubboService;

	public UserEntity selectByUserName(String userName) {
		return userDubboService.findUserByName(userName);
	}

	public int insertUser(UserEntity userEntity) {
		return userDubboService.insertUser(userEntity);
	}

	public int delete(int userId) {
		return userDubboService.delete(userId);
	}

	public int update(UserEntity userEntity) {
		return userDubboService.update(userEntity);
	}

	public List<UserEntity> selectUserList() {
		return userDubboService.selectUserList();
	}
}
