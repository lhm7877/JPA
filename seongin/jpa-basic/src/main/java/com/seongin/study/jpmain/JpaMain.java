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

			/************************ JPA를 이용한 데이터 조작 *************************/
			/* 저장 */
			// Member member = new Member();
			// member.setId(2L);
			// member.setName("HelloB");
			// em.persist(member);

			/* 조회 */
			//Member findMember = em.find(Member.class, 1L);

			/* 삭제 */
			//em.remove(findMember);

			/* 수정 */
			//findMember.setName("HelloJPA");
			/************************ JPA를 이용한 데이터 조작 *************************/




			/************************ JPQL을 이용한 인스턴스 쿼리 *************************/
			/* JPQL */
			// List<Member> resultList = em.createQuery("select m from Member as m", Member.class).getResultList();
			//
			// for(Member member: resultList) {
			// 	System.out.println("findMember.id = " + member.getId());
			// 	System.out.println("member.name = " + member.getName());
			// }
			/************************ JPQL을 이용한 인스턴스 쿼리 *************************/




			/************************ 영속성 컨텍스트 *************************/
			// /* 비영속 */
			// Member member = new Member();
			// member.setId(100L);
			// member.setName("ByeJPA");
			//
			// /* 영속 */
			// System.out.println("=== BEFORE ===");
			// em.persist(member);
			//
			// /* 준영속 */
			// em.detach(member);
			//
			// /* 삭제 */
			// em.remove(member);
			// System.out.println("=== AFTER ===");
			//
			// /* 만약, findMember가 (영속 상태에) 존재한다면 1차 캐시에서 값을 가져옴.*/
			// Member findMember = em.find(Member.class, 100L);
			// System.out.println("findMember.id = " + findMember.getId());
			// System.out.println("findMember.id = " + findMember.getName());
			/************************ 영속성 컨텍스트 *************************/



			/************************ 쓰기 지연 *************************/
			// Member member1 = new Member(150L, "A");
			// Member member2 = new Member(160L, "B");
			//
			// /* 쓰기 지연 SQL 저장소에 쿼리를 쌓음. */
			// em.persist(member1);
			// /* 쓰기 지연 SQL 저장소에 쿼리를 쌓음. */
			// em.persist(member2);

			/************************ 쓰기 지연 *************************/



			/************************ 변경 감지 *************************/
			// Member member = em.find(Member.class, 150L);
			//
			// /* 영속성 컨텍스트에서 엔티티 스냅샷(최초 1차 캐싱 시점)과 현재의 값을 비교함. */
		    // /* 값이 다를 경우 Update SQL문을 만들어 데이터베이스 서버에 보냄. */
			// member.setName("ZZZZ");

			/************************ 변경 감지 *************************/




			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
