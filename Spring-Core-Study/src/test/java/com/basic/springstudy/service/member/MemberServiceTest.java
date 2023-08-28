package com.basic.springstudy.service.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.enums.Grade;
import com.basic.springstudy.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {
  @Autowired
  MemberServiceImpl memberService;

  @Autowired
  MemberRepository memberRepository;


  @Test
  void join() {

    // given
    Member member = Member.of("doha", Grade.VIP);

    // when
    Member newMember = memberRepository.save(member);

    // then
    Member findMember = memberService.findMember(newMember.getId());
    assertThat(newMember.getName()).isEqualTo(findMember.getName());
  }
}