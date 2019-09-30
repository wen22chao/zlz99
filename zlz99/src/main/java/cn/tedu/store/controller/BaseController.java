package cn.tedu.store.controller;

import cn.tedu.store.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public abstract class BaseController {
	@Autowired
	private IIndexService indexService;
	
	public Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	public Integer getUidFromToken(String token) {
		return indexService.getUidFromToken(token);
	}
}
