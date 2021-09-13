package com.hoomin.study.jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hoomin");
		final EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
	}
}
