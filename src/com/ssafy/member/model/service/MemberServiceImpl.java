package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService = new MemberServiceImpl();
	
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
		return memberService;
	}
	
	@Override
	public void registerMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberdao().registerMember(memberDto);
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		// TODO Auto-generated method stub
		return MemberDaoImpl.getMemberdao().login(userId, userPass);
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberdao().modifyMember(memberDto);

	}

	@Override
	public void deleteMember(String userId) {
		MemberDaoImpl.getMemberdao().deleteMember(userId);
	}

}
