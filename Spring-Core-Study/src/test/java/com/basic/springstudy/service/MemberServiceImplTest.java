package com.basic.springstudy.service;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.enums.Grade;
import com.basic.springstudy.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

  @InjectMocks
  MemberServiceImpl memberService;

  @Mock
  MemberRepository memberRepository;

  @Test
  void memberJoin() {

    Member member = memberService.memberJoin(Member.of("doha", Grade.VIP));
    Member findMember = memberService.findMember(member.getId());

    Assertions.assertThat(member).isEqualTo(findMember);
  }
}