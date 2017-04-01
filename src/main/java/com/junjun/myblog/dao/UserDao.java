package com.junjun.myblog.dao;

import java.util.List;

import com.junjun.myblog.domain.User;

public interface UserDao {
	
	/**
	 * 查询所有
	 * @return 用户列表
	 */
	List<User> selectAll();
		
	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	User selectById(Integer id);
	
	
	/**
	 * 根据用户名查询，用作检查注册
	 * @param user
	 * @return
	 */
	User selectByUsername(String username);
	
	/**
	 * 根据用户名和密码查询用户,用作检查登录
	 * @return user
	 */
	User selectByUsernameAndPassword(User user);
		
	/**
	 * 插入一个用户
	 * @param user
	 */
	void insert(User user);
	
	/**
	 * 根据删除用户
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void update(User user);
	
}












