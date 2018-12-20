package com.accp.service;

import java.util.List;

import com.accp.pojo.User;
import com.accp.util.Pageing;
import com.github.pagehelper.PageInfo;

public interface UserService {
	public List<User> showUserAll(); 
	
	public PageInfo<User> page(int currentPage);
}
