package com.springmvc_mybatis.controller;

import java.util.Set;

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
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public @ResponseBody Set<User> findUsersByName(@PathVariable String userName){

		Set<User> users = usermapper.findOne("Tom");
		System.out.println(users);
		return users;
	}
	
	@RequestMapping("/vo")
	public @ResponseBody Set<GroupUserVo> getVoById(int groupId){

			Set<GroupUserVo> groupUserVos = groupUserMapper.getVoById(groupId);
			System.out.println(groupUserVos);
		return groupUserVos;
	}
}
