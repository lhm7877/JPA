package jpabook.jpashop;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Book;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {

			// 단방향 매핑만으로 설계, 개발 모두 가능하다!
			// 자주 사용되는 역방향 연관관계라면 양방향 매핑까지 고려하자 !
			// 양방향 매핑을 했다면 코드 스타일은 자유롭게 해도 무방하나, 한 곳에서 연관관계를 책임지자!
			// 만약, 두 곳에서 연관관계를 처리한다면 복잡도가 올라가고 실수할 확률이 매우 큼.

			// 방법 1
			// Order order = new Order();
			// order.addOrderItem(new OrderItem());

			// 방법 2
			// Order order = new Order();
			// em.persist(order);
			// OrderItem orderItem = new OrderItem();
			// orderItem.setOrder(order);
			// em.persist(orderItem);


			Book book = new Book();
			book.setName("JPA");
			book.setAuthor("김성인");

			em.persist(book);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
