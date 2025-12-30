package com.rishav.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rishav.dao.MemberDao;
import com.rishav.dto.MemberDto;
import com.rishav.exception.MemberAlreadyExistsException;
import com.rishav.exception.MemberIdNotFoundException;
import com.rishav.model.Member;
import com.rishav.resource.ResponseStructure;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberDao memberDao;
	public MemberServiceImpl(MemberDao memberdao) {
		this.memberDao=memberdao;
	}
	
	//Register Member
	@Override
	public ResponseEntity<ResponseStructure<MemberDto>> registerMember(MemberDto dto) {
		if(memberDao.existsByEmail(dto.getEmail())) {
			throw new MemberAlreadyExistsException("Memeber already exits with email id "+dto.getEmail());
		}
		
		Member member=new Member();
		member.setName(dto.getName());
		member.setEmail(dto.getEmail());
		member.setPhone(dto.getPhone());
		member.setType(dto.getType());
		member.setActive(true);//default active
		
		Member saved=memberDao.save(member);
		dto.setId(saved.getId());
		dto.setName(saved.getName());
		dto.setActive(saved.getActive());
		
		ResponseStructure<MemberDto> response=new ResponseStructure<MemberDto>();
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("Member registered successfully");
		response.setData(dto);
		
		return new ResponseEntity<ResponseStructure<MemberDto>>(response,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<MemberDto>> updateMember(MemberDto dto) {
		Member member=memberDao.findById(dto.getId());
		if(member==null) {
			throw new MemberIdNotFoundException("No member found with the entered id value "+dto.getId());
		}
		
		member.setName(dto.getName());
		member.setPhone(dto.getPhone());
		member.setType(dto.getType());
		
		memberDao.save(member);
		
		ResponseStructure<MemberDto> response=new ResponseStructure<MemberDto>();
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("Member updated sucessfully");
		response.setData(dto);
		
		return new ResponseEntity<ResponseStructure<MemberDto>>(response, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<ResponseStructure<String>> changeMemberStatus(Integer id, boolean active) {
		Member member=memberDao.findById(id);
		if(member==null) {
			throw new MemberIdNotFoundException("No member found by given id "+id);
		}
		
		member.setActive(active);
		memberDao.save(member);
		
		String status= active ? "activated" : "deactivated";
		
		ResponseStructure<String> response=new ResponseStructure<String>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Member "+status+" sucessfully");
		response.setData("Member status is now "+status);
		
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseStructure<MemberDto>> getMemberDetails(Integer id) {
		Member member=memberDao.findById(id);
		if(member==null) {
			throw new MemberIdNotFoundException("No member found by given id "+id);
		}
		
		MemberDto dto=new MemberDto();
		dto.setId(member.getId());
		dto.setName(member.getName());
		dto.setEmail(member.getEmail());
		dto.setPhone(member.getPhone());
		dto.setType(member.getType());
		dto.setActive(member.getActive());
		
		ResponseStructure<MemberDto> response=new ResponseStructure<MemberDto>();
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Member details retrieved successfully");
		response.setData(dto);
		
		return new ResponseEntity<ResponseStructure<MemberDto>>(response, HttpStatus.OK);
	}
}
