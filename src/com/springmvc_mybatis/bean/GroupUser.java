package com.springmvc_mybatis.bean;

import java.io.Serializable;

public class GroupUser implements Serializable{
	private static final long serialVersionUID = 2L;
	public GroupUser(){
		super();
	}
	
	public GroupUser(int groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
	private int groupId;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	private String groupName;
	
	@Override
	public String toString(){
		return "GroupUser [groupId: "+groupId+", groupName: "+groupName+"];";
	}
}
