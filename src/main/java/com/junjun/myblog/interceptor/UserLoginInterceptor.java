package com.junjun.myblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.junjun.myblog.domain.User;

public class UserLoginInterceptor implements HandlerInterceptor {

	/**
	 * 用来存储不拦截的路径
	 */
	private static final String[] IGNORE_URI = {"/nothing"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("开始preHandle,判断请求是否需要拦截");
		boolean flag = false;
		String servletPath = request.getServletPath();
		System.out.println("请求路径是: "+servletPath);
		// 检测是否为需要拦截的请求
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				System.out.println("该请求不需要拦截");
				flag = true;
			}

		}
		// 需要拦截处理的请求
		if (!flag) {
			// 获取存储在session域的用户
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				System.out.println("拦截请求:用户未登录，禁止直接访问，返回登录页面");
				request.setAttribute("message", "请先登录");
				// 服务器内部转发，可以带回request
				request.getRequestDispatcher("/login").forward(request, response);
			}

			else {
				System.out.println("拦截请求:用户已经登录，可以成功浏览网页");
				flag = true;
			}

		}
		
		return flag;


	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("拦截请求之后");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("控制器处理完成之后");

	}

}
