package com.springmvc_mybatis.controller;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc_mybatis.bean.User;
import com.springmvc_mybatis.mapper.GroupUserMapper;
import com.springmvc_mybatis.mapper.UserMapper;
import com.springmvc_mybatis.bean.*;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private GroupUserMapper groupUserMapper;
	
	@Autowired
	private UserMapper usermapper;

	@RequestMapping("/login")
	public String login(String username,String password,Model model){//HttpServletRequest request, Model model) {
//		String name = request.getParameter("username");
//		String password = request.getParameter("password");
		System.out.println("login");
		User user_login = usermapper.login(username, password);
		System.out.println(user_login);
		if (user_login == null) {
			System.out.println("Error login!");
			return "fail";
		} else {
			model.addAttribute("user", user_login);
			return "success";
		}
	}
	

	@RequestMapping("/list")
	public String getAllUsers(Model model) {
		Set<User> users = usermapper.getAllUsers();
		model.addAttribute("users", users);
		System.out.println(users);
		return "list";

	}
	
	@RequestMapping("/getAll")
	public @ResponseBody Set<User> getAllUsers() {
		System.out.println("getAll Success");
		Set<User> users = usermapper.getAllUsers();
		return users;

	}
	/*
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public @ResponseBody Set<User> findUsersByName(@PathVariable String userName){

		Set<User> users = usermapper.findOne("Tom");
		System.out.println(users);
		return users;
	}*/
	
	@RequestMapping("/vo")
	public @ResponseBody String getVoById(int groupId){
		System.out.println("getVoById sucess");
		if(groupId<1 || groupId >4) return "FAILUER";

			Set<GroupUserVo> groupUserVos = groupUserMapper.getVoById(groupId);
			System.out.println(groupUserVos);
		return groupUserVos.toString();
	}
	
	@RequestMapping("/selectByName")
	public @ResponseBody String selectByName(String name){
		System.out.println("selectByName success!");
		//System.out.println("###################");
		Set<User> users = usermapper.findOne(name);
		//System.out.println(users);
		return users.toString();
	}
	
	@RequestMapping("/insert")
	public @ResponseBody String insert(String name, String pwd, int groupId){
		System.out.println("insert success!");
		if(name == "" || pwd == "")
			return "FAILUER,name or passworld can't not be null!";
			
		if(groupId<1 || groupId>4)
			return "FAILUER,Group Id should be 1 or 2 or 3 or 4";
		
		int result = usermapper.insertUser(name,pwd,new Date(),groupId);
		//System.out.println(users);
		return result==1?"SUCCESS":"FAILUER";
	}
	
	@RequestMapping("/test")
	public String test(){
		System.out.println("****&&&^^^^^^");

		return "test";
	}
			
	@RequestMapping("/letter")
	public @ResponseBody String findUserByFirstLetter(char letter){
		return usermapper.findUserByFirstLetter(letter).toString();
	}
}
