package com.rishav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishav.dto.MemberDto;
import com.rishav.resource.ResponseStructure;
import com.rishav.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
	public final MemberService memberService;
	public MemberController(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<MemberDto>> register(@RequestBody MemberDto dto) {
		return memberService.registerMember(dto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<MemberDto>> update(@RequestBody MemberDto dto) {
		return memberService.updateMember(dto);
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<ResponseStructure<String>> changeStatus(@PathVariable Integer id, @RequestParam boolean active) {
		return memberService.changeMemberStatus(id, active);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<MemberDto>> getDetails(@PathVariable Integer id) {
		return memberService.getMemberDetails(id);
	}
}
