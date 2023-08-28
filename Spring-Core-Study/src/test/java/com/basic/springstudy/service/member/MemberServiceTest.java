package com.basic.springstudy.service.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.enums.Grade;
import com.basic.springstudy.repository.MemberRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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