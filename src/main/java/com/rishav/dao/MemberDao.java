package com.rishav.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rishav.exception.MemberIdNotFoundException;
import com.rishav.model.Member;
import com.rishav.repository.MemberRepository;

@Repository
public class MemberDao {
	public final MemberRepository memberRepository;
	
	public MemberDao(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	
	public Member save(Member member) {
		return memberRepository.save(member);
	}
	
	public boolean existsByEmail(String email) {
		return memberRepository.existsByEmail(email);
	}
	
	public Member findById(Integer id) {
		Optional<Member> opt=memberRepository.findById(id);
		if(opt.isEmpty())
			throw new MemberIdNotFoundException("No member Found!!!");
		else
			return opt.get();
	}
}