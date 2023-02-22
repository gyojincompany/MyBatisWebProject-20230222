package com.gyojincompany.home.dao;

import com.gyojincompany.home.dto.MemberDto;

public interface Mapper {
	
	public void joinDao(String mid, String mpw, String mname, String memail);//회원 가입 메서드
	public int loginCheck(String mid, String mpw);//로그인 체크 메서드
	public MemberDto memberInfo(String mid);//특정 아이디 회원정보 가져오기 메서드 
	public void memberDelete(String mid);//회원 탈퇴 메서드
}
