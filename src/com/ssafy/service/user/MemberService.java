package com.ssafy.service.user;

import com.ssafy.dto.user.MemberDto;

public interface MemberService {

	void registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	void modifyMember(MemberDto memberDto);

	void deleteMember(String userId);

}
