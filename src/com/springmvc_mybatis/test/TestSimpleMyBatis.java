package com.springmvc_mybatis.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.springmvc_mybatis.bean.*;
import com.springmvc_mybatis.mapper.GroupUserMapper;
import com.springmvc_mybatis.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans_wolf.xml")
public class TestSimpleMyBatis {

	@Autowired 
	private GroupUserMapper groupUserMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll() {
		Set<User> users = userMapper.getAllUsers();
		System.out.println(users);
	}
	
	@Test 
	public void insert() throws ParseException{
		System.out.println(userMapper.insertUser("SAA","2344",new Date(),2));
	}
	
	@Test
	public void update() throws ParseException{
		final Date d=new SimpleDateFormat("yyyy-MM-dd").parse("2015-12-26");
		userMapper.updateUser("Tom","1233",d,3);
	}
	
	@Test
	public void findOne(){
		System.out.println(userMapper.findOne("Bob"));
	}

	@Test
	public void delete(){
		userMapper.deleteUser("Tom");
	}

	
	@Test
	public void login() {
		// User user = new User(null, "wx", "123456", new Date());
		// User user = new User(null, "wangxin", "123456", new Date());
		// User loginExit = userMapper.login(user);
		// User loginExit = userMapper.login("wx", "123456");
		User loginExit = userMapper.login("wangxin", "123456");
		if (loginExit == null) {
			System.out.println("用户不存在");
		} else {
			System.out.println(loginExit);
			System.out.println("登录成功！");
		}
	}
	
	@Test
	public void findAllGroupUser(){
		System.out.println(groupUserMapper.findAllGroupUser());
	}
	/*
	@Test
	public void insertGroupUser(){
		GroupUser groupUser = new GroupUser(5,"EEE");
		groupUserMapper.insertGroupUser(groupUser);
	}*/
	
	@Test
	public void getGroupUserById(){
		System.out.println(groupUserMapper.getGroupUserById(1));
	}
	
	@Test
	public void getVoById(){
		System.out.println(groupUserMapper.getVoById(1));
	}
	
	@Test
	public void findUserByFirstLetter(){
		//char c = 'c';
		System.out.println(userMapper.findUserByFirstLetter('c'));
	}
	
}