package com.springmvc_mybatis.mapper;

import java.util.Set;

import com.springmvc_mybatis.bean.GroupUser;
import com.springmvc_mybatis.bean.GroupUserVo;




public interface GroupUserMapper {
	
	Set<GroupUser> findAllGroupUser();
	
	void insertGroupUser(GroupUser groupUser);
	
	GroupUser getGroupUserById(int groupId);
	
	Set<GroupUserVo> getVoById(int groupId);
}
