package com.basic.springstudy.singleton;

import com.basic.springstudy.AppConfig;
import com.basic.springstudy.service.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTonTest {

  @Test
  @DisplayName("스프링 없는 순수한 DI 컨테이너")
  void pureContainer() {
    AppConfig appConfig = new AppConfig();

    // 1. 조회 : 호출할 때 마다 객체를 생성
    MemberService memberService1 = appConfig.memberService();

    // 2. 조회 : 호출할 때 마다 객체를 생성
    MemberService memberService2 = appConfig.memberService();

    // 참조 값이 다른 것을 확인
    Assertions.assertFalse(memberService1 == memberService2);
  }
}