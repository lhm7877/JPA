package com.seongin.study.jpmain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");


		// 쓰레드 공유 X
		// 로직 처리 후 버려져야 함.
		EntityManager em = emf.createEntityManager();

		// JPA의 모든 데이터 변경은 트랜잭션 안에서 실행되어야 함.
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			/* 저장 */
			// Member member = new Member();
			// member.setId(2L);
			// member.setName("HelloB");
			// em.persist(member);

			/* 조회 */
			Member findMember = em.find(Member.class, 1L);

			/* 삭제 */
			//em.remove(findMember);

			/* 수정 */
			//findMember.setName("HelloJPA");

			/* JPQL */
			List<Member> resultList = em.createQuery("select m from Member as m", Member.class).getResultList();

			for(Member member: resultList) {
				System.out.println("findMember.id = " + member.getId());
				System.out.println("member.name = " + member.getName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
