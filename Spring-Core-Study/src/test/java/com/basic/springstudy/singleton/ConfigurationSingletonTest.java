package com.basic.springstudy.singleton;

import com.basic.springstudy.AppConfig;
import com.basic.springstudy.repository.MemberRepository;
import com.basic.springstudy.repository.MemoryMemberRepository;
import com.basic.springstudy.service.member.MemberServiceImpl;
import com.basic.springstudy.service.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
  @Test
  void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

    //모두 같은 인스턴스를 참고하고 있다.
    Assertions.assertEquals(memberService.getMemberRepository(), memberRepository);

  }

  @Test
  void configurationDeep() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    // AppConfig도 스프링 빈으로 등록된다.
    AppConfig bean = ac.getBean(AppConfig.class);

    System.out.println("bean = " + bean.getClass());
  }
}
