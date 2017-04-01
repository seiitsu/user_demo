package com.junjun.myblog.service;

import java.util.List;

import com.junjun.myblog.domain.User;

public interface UserService {

	/**
	 * 查询出所有用户
	 * 
	 * @return 所有用户列表
	 */
	List<User> findAllUser();
	
	/**
	 * 分页查询服务
	 * @param pageNo 页号
	 * @param pageSize 每页多少条数据
	 * @return
	 */
	/*PageInfo<User> findByPage(Integer pageNo,Integer pageSize);*/
	
	/**
	 * 根据id查询用户
	 * @return
	 */
	User findUserById(Integer id);
	
	/**
	 * 根据用户名查询
	 * @param user
	 * @return
	 */
	User findUserByUsername(String username);
	
	/**
	 * 检查登录
	 * 
	 * @param user
	 * @return user
	 */
	User checkLogin(User user);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 */
	void deleteUser(Integer id);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUser(User user);

}
