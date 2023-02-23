package com.gyojincompany.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.home.dao.Mapper;
import com.gyojincompany.home.dto.BoardDto;
import com.gyojincompany.home.dto.MemberDto;

@Controller
public class HomeController {
	
	@Autowired//의존주입(DI)
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String index2() {
		
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
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		int loginCheck = dao.loginCheck(mid, mpw);
		//1이면 아이디와 비밀번호가 모두 일치하는 데이터가 존재->로그인 성공
		model.addAttribute("loginCheck", loginCheck);		
		
		if(loginCheck == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionid", mid);
			session.setAttribute("ValidMem", "yes");
			model.addAttribute("memberid", mid);
		} 
		return "loginOk";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();//로그아웃
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "/memberInfo")
	public String memberInfo(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionid");//현재 로그인한 회원의 아이디
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		MemberDto memberDto = dao.memberInfo(sessionId);
		
		model.addAttribute("memberDto", memberDto);
		
		return "memberInfo";
	}
	
	@RequestMapping(value = "/memberDelete")
	public String memberDelete(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionid");//현재 로그인한 회원의 아이디
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		dao.memberDelete(sessionId);//회원정보삭제->회원탈퇴
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "/writeForm")
	public String writeForm(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionid");//현재 로그인한 회원의 아이디
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
		if(sessionId == null) { //로그인 하지 않은 상태
			model.addAttribute("mid", "GUEST");
			model.addAttribute("mname", "비회원");
		} else { //로그인 한 상태
			MemberDto memberDto = dao.memberInfo(sessionId);//현재 로그인한 회원의 모든정보 가져오기
			model.addAttribute("mid", memberDto.getMid());
			model.addAttribute("mname", memberDto.getMname());
		}
		
		return "writeForm";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionid");//현재 로그인한 회원의 아이디
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
		String btitle = request.getParameter("btitle");//글제목
		String bcontent = request.getParameter("bcontent");//글내용
		String bmid = null;
		String bmname = null;
		
		if(sessionId == null) { //로그인 하지 않은 상태
			bmid = "GUEST";
			bmname = "비회원";
			
		} else { //로그인 한 상태
			MemberDto memberDto = dao.memberInfo(sessionId);//현재 로그인한 회원의 모든정보 가져오기
			bmid = memberDto.getMid();
			bmname = memberDto.getMname();
		}
		
		dao.writeDao(btitle, bcontent, bmid, bmname);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model) {
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
		List<BoardDto> boardDtos = dao.listDao();//모든 글 목록 가져오기
		
		model.addAttribute("boardDtos", boardDtos);
		
		return "list";
	}
	
	@RequestMapping(value = "/contentView")
	public String content_view(HttpServletRequest request, Model model) {
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
		String bid = request.getParameter("bid");//사용자가 클릭한 게시글의 번호
		
		model.addAttribute("boardDto", dao.contentViewDao(bid));//해당 클릭한 번호의 글 반환
		
		return "content_view";
	}
	
	@RequestMapping(value = "/modify")
	public String modify_view(HttpServletRequest request, Model model) {
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
		String bid = request.getParameter("bid");//사용자가 클릭한 게시글의 번호
		System.out.println(request.getParameter("bmname"));
		
		model.addAttribute("boardDto", dao.contentViewDao(bid));//해당 클릭한 번호의 글 반환
		
		return "modify_view";
	}
	
	@RequestMapping(value = "/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
		String bid = request.getParameter("bid");//사용자가 클릭한 게시글의 번호
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		dao.modifyDao(bid, btitle, bcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		Mapper dao = sqlSession.getMapper(Mapper.class);
		
		String bid = request.getParameter("bid");//사용자가 삭제하려는 게시글의 번호
				
		dao.deleteDao(bid);
		
		return "redirect:list";
	}
}
