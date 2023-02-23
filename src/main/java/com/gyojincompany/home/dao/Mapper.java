package com.gyojincompany.home.dao;

import java.util.List;

import com.gyojincompany.home.dto.BoardDto;
import com.gyojincompany.home.dto.MemberDto;

public interface Mapper {
	
	//회원관리용
	public void joinDao(String mid, String mpw, String mname, String memail);//회원 가입 메서드
	public int loginCheck(String mid, String mpw);//로그인 체크 메서드
	public MemberDto memberInfo(String mid);//특정 아이디 회원정보 가져오기 메서드 
	public void memberDelete(String mid);//회원 탈퇴 메서드
	
	//게시판용
	public void writeDao(String btitle, String bcontent, String bmid, String bmname);//게시판 글쓰기
	public List<BoardDto> listDao();//게시판 모든 글목록 가져오기
	public BoardDto contentViewDao(String bid);//리스트에서 사용자가 클릭한 글의 내용 가져오기
	
}
