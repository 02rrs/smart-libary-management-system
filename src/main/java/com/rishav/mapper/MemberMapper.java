package com.rishav.mapper;

import com.rishav.dto.MemberDto;
import com.rishav.model.Member;

public class MemberMapper {
	
	//Entity -> DTO
	public static MemberDto toDto(Member member) {
        if (member == null) return null;

        MemberDto dto = new MemberDto();
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setType(member.getType());
        dto.setActive(member.getActive());

        return dto;
    }
	
	//DTO -> Entity
	public static Member toEntity(MemberDto dto) {
        if (dto == null) return null;

        Member member = new Member();
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setType(dto.getType());
        member.setActive(dto.getActive());

        return member;
    }
}
