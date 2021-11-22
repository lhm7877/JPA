package com.hoomin.study.jpa.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
// @Table(name = "다른 이름")
public class Member {

	@Id
	@GeneratedValue
	private Long id;

	// @Column(name = "다른 이름")
	private String name;
}
