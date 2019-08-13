package cn.tedu.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor 
	implements HandlerInterceptor {

	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		// 判断登录判断，如果没有登录，则跳转到登录页
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		return true;
		/*if (session.getAttribute("uid") == null) {
			// session中没有uid
			//表示没有登录
			// 则应该重定向到登录页
			response.sendRedirect("../user/login.do");
			// 返回：拦截，不继续向后分发到控制器
			return false;
		} else {
			// 已经登录，直接放行
			return true;
		}*/
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
