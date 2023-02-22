package com.gyojincompany.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.home.dao.Mapper;

@Controller
public class HomeController {
	
	@Autowired//의존주입(DI)
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		dao.joinDao(mid, mpw, mname, memail);
		model.addAttribute("mname", mname);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}

}
