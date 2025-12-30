package com.rishav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishav.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	public boolean existsByEmail(String email);
}
