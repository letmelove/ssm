package com.accp.mapper;

import java.util.List;

import com.accp.pojo.User;

public interface UserMapper {
	List<User> selectUserAll();
	
	/**
	 *   查询一共有多少条数据
	 * @return
	 */
	Integer selectCountTwig();
	/**
	 * 分页查询
	 * @param currentPage 页数
	 * @param aNumberOf 条数
	 * @return
	 */
	List<User> selectUserPage(int currentPage,int aNumberOf);
}
