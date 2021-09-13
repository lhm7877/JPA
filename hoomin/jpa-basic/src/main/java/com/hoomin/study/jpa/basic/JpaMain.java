package com.hoomin.study.jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		// 어플리케이션 로딩 시점에 하나만 만들어야 한다
		// DB 커넥션 얻어서 쿼리를 날리고 종료되는 단위마다 만들어야 한다.
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hoomin");
		final EntityManager em = emf.createEntityManager();

		final EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member = new Member();
			member.setId(1L);
			member.setName("HelloA");

			em.persist(member);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			// entity manager가 내부적으로 db 커넥션을 물고 동작하기 때문에 꼭 닫아줘야 한다.
			em.close();
		}

		em.close();
		emf.close();
	}
}
