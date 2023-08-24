package com.basic.jpastudy.controller;

import com.basic.jpastudy.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/member")
@RestController
public class MemberController {

  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEntityManagerFactory(EntityManagerFactory emf) {
    this.emf = emf;
  }

  @GetMapping()
  public Member memberCrud() {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member newMember = Member.of("kimdoha");
      em.persist(newMember);

      Member findMember = em.find(Member.class, 1L);

      Member updateMember = em.find(Member.class, 1L);
      updateMember.update("kimdoha2");
      em.persist(updateMember);

      Member deleteMember = em.find(Member.class, 1L);
      em.remove(deleteMember);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
      emf.close();
    }

    return null;
  }
}
