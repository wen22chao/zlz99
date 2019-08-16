package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tedu.store.entity.Members;
import cn.tedu.store.service.IIndexService;

public abstract class BaseController {
	@Autowired
	private IIndexService indexService;
	
	public Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	public List<Members> getUidFromToken(String token) {
		return indexService.getUidFromToken(token);
	}
}
