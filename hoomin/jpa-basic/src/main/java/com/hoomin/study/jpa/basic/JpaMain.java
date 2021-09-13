package com.hoomin.study.jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		// 어플리케이션 로딩 시점에 하나만 만들어야 한다 (web 서버가 올라갈때 하나만 생성)
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hoomin");
		// DB 커넥션 얻어서 쿼리를 날리고 종료되는 단위마다 만들어야 한다. (API 마다, 쓰레드간 공유 X)
		final EntityManager em = emf.createEntityManager();

		// 모든 데이터 변경은 트랜잭션 안에서 실행
		final EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			// persistMember(em);
			// findMember(em);
			// updateMember(em);

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

	/**
	 * persist가 필요 없다.
	 */
	private static void updateMember(EntityManager em) {
		final Member member = em.find(Member.class, 1L);
		member.setName("helloJPA");
	}

	private static void findMember(EntityManager em) {
		final Member member = em.find(Member.class, 1L);
		System.out.println(member.getName());
	}

	private static void persistMember(EntityManager em) {
		Member member = new Member();
		member.setId(1L);
		member.setName("HelloA");

		em.persist(member);
	}
}
