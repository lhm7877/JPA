package jpabook.jpashop.domain;

import static javax.persistence.FetchType.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity{

	@Id
	@GeneratedValue
	private Long id;

	private String city;
	private String street;
	private String zipcode;

	private  DeliveryStatus deliveryStatus;

	@OneToOne(mappedBy = "delivery", fetch = LAZY)
	private Order order;
}
