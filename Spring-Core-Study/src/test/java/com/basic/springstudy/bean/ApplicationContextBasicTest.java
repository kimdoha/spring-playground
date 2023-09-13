package com.basic.springstudy.bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.basic.springstudy.config.AppConfig;
import com.basic.springstudy.service.member.MemberService;
import com.basic.springstudy.service.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("이름 없이 타입으로만 조회")
  void findBeanByType() {
    MemberService memberService = ac.getBean(MemberService.class);

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름으로 조회 시 오류 발생")
  void findByInvalidName() {
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () -> ac.getBean("xxx", MemberService.class)
    );
  }
}