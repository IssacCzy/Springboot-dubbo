package org.spring.springboot.dubbo;

import java.util.List;

import org.spring.springboot.domain.UserEntity;

public interface UserDubboService {

    public UserEntity findUserByName(String userName);
    
    public int insertUser(UserEntity userEntity);
	
	public int delete(int userId);
	
	public int update(UserEntity userEntity);

	public List<UserEntity> selectUserList();
}
