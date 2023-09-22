package com.ssafy.dao.user;

import com.ssafy.dto.user.MemberDto;

public interface MemberDao {

	void registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	void modifyMember(MemberDto memberDto);

	void deleteMember(String userId);

}
