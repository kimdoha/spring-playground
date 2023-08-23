//package com.basic.jpastudy;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class JpaMainApplication {
//
//  public static void main(String[] args) {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("study");
//    EntityManager em = emf.createEntityManager();
//    EntityTransaction tx = em.getTransaction();
//    tx.begin();
//
//    try {
//      // create new member
//      Member newMember = new Member();
//      em.persist(newMember);
//
//      // readMember
//      Member findMember = em.find(Member.class, 1L);
//      log.info("findMember = " + findMember.getId());
//
//      // update Member
//
//      // delete Member
//
//
//      /*
//       * read all members by JPQL
//       * SQL은 DB 테이블을 대상으로 쿼리를 작성하지만
//       * JPQL은 객체를 대상으로 검색하는 객체 지향 쿼리이다.
//       */
//
//
//      tx.commit();
//    } catch (Exception e) {
//      tx.rollback();
//    } finally {
//      em.close();
//    }
//
//    emf.close();
//  }
//}
