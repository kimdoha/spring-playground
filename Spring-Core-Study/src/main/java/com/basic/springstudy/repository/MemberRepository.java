package com.basic.springstudy.repository;

import com.basic.springstudy.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository
    extends JpaRepository<Member, Long> {

}
