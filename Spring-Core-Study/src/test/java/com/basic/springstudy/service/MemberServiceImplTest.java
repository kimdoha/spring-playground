package com.basic.springstudy.service;

import static org.assertj.core.api.Assertions.*;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.enums.Grade;
import com.basic.springstudy.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
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

  @BeforeEach
  void beforeEach(){
    memberService = new MemberServiceImpl(memberRepository);
  }

  @Test
  void 회원가입() {

    // given
    Member member = Member.of("doha", Grade.VIP);

    // when
    Long joinMemberId = memberService.join(member);

    // then
    Member findMember = memberService.findMember(joinMemberId);
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }
}