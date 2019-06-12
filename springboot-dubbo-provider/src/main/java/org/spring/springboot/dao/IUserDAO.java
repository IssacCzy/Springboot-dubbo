package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.UserEntity;

public interface IUserDAO {
	public UserEntity selectByUserName(@Param("username") String userName);

	public int insertUser(UserEntity userEntity);
	
	public int delete(@Param("id") int userId);
	
	public int update(UserEntity userEntity);

	public List<UserEntity> selectUserList();
}
