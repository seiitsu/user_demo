package com.junjun.myblog.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junjun.myblog.domain.User;
import com.junjun.myblog.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 显示所有用户 分页插件使用
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/user/showAllUser")
	public ModelAndView showAllUser(
			@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = "5") Integer pageSize, 
			ModelAndView mv) {
		PageHelper.startPage(pageNum, pageSize);// 默认从第一页开始，每页五条
		List<User> users = userService.findAllUser();// 第一条执行的SQL语句会被分页，实际上输出users是page对象
		PageInfo<User> pageUser = new PageInfo<User>(users);// 将users对象绑定到pageInfo
		mv.addObject("users", users);// 设置到属性
		mv.addObject("pageUser", pageUser);// 设置pageUser属性
		mv.setViewName("user/showAllUser");// 返回视图
		return mv;
	}

	/**
	 * 检查登录
	 * 
	 * @param user
	 * @param model
	 * @param session存储登录用户
	 * @return
	 */
	@RequestMapping(value = "/checkLogin")
	@ResponseBody
	public boolean loginUser(@RequestBody User user, Model model, HttpSession session) {
		boolean result = false;
		if (userService.checkLogin(user) != null) {
			session.setAttribute("user", user);// 将用户信息存入session中
			model.addAttribute("user", user);
			System.out.println("登录成功测试: " + user);
			result = true;
		}

		return result;
	}

	/**
	 * 检查注册
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/checkRegist", "/checkAddUser" })
	@ResponseBody
	public boolean registUser(@RequestBody User user, Model model) {
		boolean result = false;
		if (userService.findUserByUsername(user.getUsername()) == null) {
			userService.addUser(user);
			model.addAttribute("user", user);
			System.out.println("注册成功: " + user);
			result = true;
		}

		return result;
	}

	/**
	 * 选中需要修改的用户信息带入到修改页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/toUpdateUserForm/{id}")
	public String toUpdateUserForm(@PathVariable("id") int id, Model model) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user/updateUserForm";
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/updateUser")
	@ResponseBody
	public boolean updateUser(@RequestBody User user) {
		System.out.println(user);
		userService.updateUser(user);
		return true;
	}

	/**
	 * 删除一条用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/deleteUser/{id}")
	@ResponseBody
	public boolean deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return true;
	}

	/**
	 * 查询用户
	 * 
	 * @param username
	 * @param model
	 * @return 显示查询结果页面
	 */
	@RequestMapping(value = "/user/findUser/{username}")
	public String findUser(@PathVariable String username, Model model) {
		User user = userService.findUserByUsername(username);
		if (user != null) {
			model.addAttribute("users", user);
		} else {
			model.addAttribute("message", "不存在 " + username + " 用户");
		}
		return "user/showFindUser";
	}

	@RequestMapping(value = "/uploadFile")
	public @ResponseBody String uploadFile(MultipartFile file) {// 1

		try {
			// 上传到当前项目下的某个文件夹
			FileUtils.writeByteArrayToFile(new File("uploadFile/" + file.getOriginalFilename()), file.getBytes());
			return "上传成功";
		} catch (IOException e) {
			e.printStackTrace();
			return "上传失败";
		}

	}

}
