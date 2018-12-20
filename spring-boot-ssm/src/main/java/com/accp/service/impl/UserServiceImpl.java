package com.accp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.mapper.UserMapper;
import com.accp.pojo.User;
import com.accp.service.UserService;
import com.accp.util.Pageing;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public List<User> showUserAll() {
		return mapper.selectUserAll();
	}

	@Override
	public PageInfo<User> page(int currentPage) {
		PageHelper.startPage(currentPage, 2);
		List<User> list = mapper.selectUserAll();
		PageInfo<User> pageinfo = new PageInfo<>(list);
		return pageinfo;
		/*Pageing<User> pageUser = new Pageing<>();
		pageUser.setCountTwig(mapper.selectCountTwig());
		if (currentPage > pageUser.getCountPage()) {
			currentPage = pageUser.getCountPage();
		}
		if (currentPage < 1) {
			currentPage = 1;
		}
		pageUser.setCurrentPage(currentPage);
		currentPage = (currentPage - 1) * pageUser.getShowTwig();
		pageUser.setList(mapper.selectUserPage(currentPage, pageUser.getShowTwig()));
		return pageUser;*/
	}

}
