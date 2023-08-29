package com.basic.jpastudy.repository;

import com.basic.jpastudy.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
