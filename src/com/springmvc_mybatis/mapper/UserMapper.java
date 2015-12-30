package com.springmvc_mybatis.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.springmvc_mybatis.bean.User;

//userMapper只能传入一个参数,多个的话需要注解
public interface UserMapper {

	//value 必须与Bean 属性一致！
	User login(@Param(value = "name") String name,
			@Param(value = "password") String password);

	Set<User> getAllUsers();
	
	void insertUser(@Param(value = "name")String name, @Param(value = "pwd")String pwd,
			@Param(value = "create_time")java.util.Date create_time,@Param(value="groupId")int groupId);
	
	Set<User> findOne(@Param(value = "name")String name);
	
	void deleteUser(@Param(value = "name")String name);
	
	void updateUser(@Param(value = "name")String name, @Param(value = "pwd")String pwd,
			@Param(value = "create_time")java.util.Date create_time, @Param(value="groupId")int groupId);

}
