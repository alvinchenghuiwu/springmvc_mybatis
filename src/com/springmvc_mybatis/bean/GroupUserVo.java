package com.springmvc_mybatis.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GroupUserVo {
	public GroupUserVo(int groupId, String groupName, int id, String name, String pwd, Date create_time) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.create_time = create_time;
	}

	private int groupId;
	private String groupName;
	private int id;
	private String name;
	private String pwd;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_time;
	

	
	public GroupUserVo(){
		super();
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpwd() {
		return pwd;
	}

	public void setpwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getcreate_time() {
		return create_time;
	}

	public void setcreate_time(Date create_time) {
		this.create_time = create_time;
	}	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", create_time=" + create_time + ", groupId="+ groupId + ", groupName=" + groupName +"];";
	}
}
