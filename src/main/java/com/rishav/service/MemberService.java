package com.rishav.service;

import org.springframework.http.ResponseEntity;

import com.rishav.dto.MemberDto;
import com.rishav.resource.ResponseStructure;

public interface MemberService {
	public ResponseEntity<ResponseStructure<MemberDto>> registerMember(MemberDto dto);
	public ResponseEntity<ResponseStructure<MemberDto>> updateMember(MemberDto dto);
	public ResponseEntity<ResponseStructure<String>> changeMemberStatus(Integer id, boolean active);
	public ResponseEntity<ResponseStructure<MemberDto>> getMemberDetails(Integer id);
}
