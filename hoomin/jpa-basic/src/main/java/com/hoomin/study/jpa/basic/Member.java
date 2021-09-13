package com.hoomin.study.jpa.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
// @Table(name = "다른 이름")
public class Member {

	@Id
	private Long id;

	// @Column(name = "다른 이름")
	private String name;
}
