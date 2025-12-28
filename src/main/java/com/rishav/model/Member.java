package com.rishav.model;

import com.rishav.enums.MembershipType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="members")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private Long phone;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "membership_type", nullable = false)
	private MembershipType type;
	
	@Column(nullable = false)
	private Boolean active;
	
	public Member() {}

	public Member(Integer id, String name, String email, Long phone, MembershipType type, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public MembershipType getType() {
		return type;
	}

	public void setType(MembershipType type) {
		this.type = type;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
