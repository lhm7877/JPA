package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member extends BaseEntity {

	@Id	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;

	@Embedded
	private Address address;
	// 의미가 없다. Order를 찾으려면 Order로 가라!
	//@OneToMany(mappedBy = "member")
	//private List<Order> orderList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
