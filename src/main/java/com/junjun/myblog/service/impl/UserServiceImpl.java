package com.junjun.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.junjun.myblog.dao.UserDao;
import com.junjun.myblog.domain.User;
import com.junjun.myblog.service.UserService;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Transactional(readOnly = true)
	@Override
	public List<User> findAllUser() {
		return userDao.selectAll();
	}
	
/*	@Override
	public PageInfo<User> findByPage(Integer pageNo, Integer pageSize) {
		pageNo = pageNo==null?1:pageNo;//默认为从第一行开始
		pageSize = pageSize ==null?5:pageSize;//默认五条一页
		PageHelper.startPage(pageNo,pageSize);//开启分页
		List<User> users = userDao.selectAll();
		//用PageInfo对结果包装
		PageInfo<User> page = new PageInfo<User>(users);
		//测试PageInfo全部属性
		System.out.println("当前页号: "+page.getPageNum());//获取页的数量
		System.out.println("每页大小: "+page.getPageSize());//获取每页大小
		System.out.println("当前页起始行: "+page.getStartRow());//获取起始行
		System.out.println("当前页结束行: "+page.getEndRow());//获取结束行
		System.out.println("总的数据行: "+page.getTotal());//获取总的查询到的数据行数
		System.out.println("页总数: "+page.getPages());//获取总页数
		System.out.println("第一页: "+page.getFirstPage());//首页
		System.out.println("最后一页: "+page.getLastPage());//最后一页
		System.out.println("是否有前一页: "+page.isHasPreviousPage());//是否有前一页
		System.out.println("是否有后一页: "+page.isHasNextPage());
		
		return page;
	}*/
		

	@Transactional(readOnly = true)
	@Override
	public User findUserById(Integer id) {
		return userDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public User findUserByUsername(String username) {
		return userDao.selectByUsername(username);
	}

	@Override
	public void addUser(User user) {
		userDao.insert(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public User checkLogin(User user) {
		return userDao.selectByUsernameAndPassword(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

}
