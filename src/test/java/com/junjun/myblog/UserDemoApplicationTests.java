package com.junjun.myblog;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.junjun.myblog.domain.User;
import com.junjun.myblog.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserDemoApplication.class)
@WebAppConfiguration
public class UserDemoApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void testSelectAll() {
		List<User> users = userService.findAllUser();
		System.out.println(users);

	}

	@Test
	public void testInsert() {
		User user = new User("test", "test", "test");
		userService.addUser(user);
		System.out.println(userService.checkLogin(user));
		userService.deleteUser(user.getId());
	}

}
