package com.basic.springstudy.scan;

import com.basic.springstudy.service.member.MemberService;
import config.AutoAppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    ApplicationContext ac  = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberService memberService = ac.getBean(MemberService.class);
    Assertions.assertInstanceOf(MemberService.class, memberService);
  }
}
