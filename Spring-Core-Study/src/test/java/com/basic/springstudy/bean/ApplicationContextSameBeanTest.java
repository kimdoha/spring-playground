package com.basic.springstudy.bean;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.basic.springstudy.AppConfig;
import com.basic.springstudy.repository.MemberRepository;
import com.basic.springstudy.repository.MemoryMemberRepository;
import com.basic.springstudy.repository.MemoryMemberRepositoryImpl;
import com.basic.springstudy.service.order.policy.DiscountPolicy;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

  @Test
  @DisplayName("타입으로 조회 시 같은 타입이 둘 이상이면, 중복 오류가 발생한")
  void findByTypeDuplicate() {
    assertThrows(
        NoUniqueBeanDefinitionException.class,
        () -> ac.getBean(MemoryMemberRepository.class)
    );
  }

  @Test
  @DisplayName("타입으로 조회 시 같은 타입이 둘 이상이면, 빈 이름을 지정하면 된다.")
  void findBeanByName() {
    MemoryMemberRepository memoryMemberRepository = ac.getBean("memberRepository1", MemoryMemberRepository.class);
    Assertions.assertInstanceOf(MemoryMemberRepository.class, memoryMemberRepository);
  }

  @Test
  @DisplayName("특정 타입을 모두 조회하기")
  void findAllBeanByType() {
    Map<String, MemoryMemberRepository> beansOfType = ac.getBeansOfType(MemoryMemberRepository.class);
    for(String key : beansOfType.keySet()) {
      System.out.println("key = " + key + " value = " + beansOfType.get(key));
    }

    Assertions.assertEquals(beansOfType.size(), 2);
  }

  @Configuration
  static class SameBeanConfig {

    @Bean
    public MemoryMemberRepository memberRepository1() {
      return new MemoryMemberRepositoryImpl();
    }

    @Bean
    public MemoryMemberRepository memberRepository2() {
      return new MemoryMemberRepositoryImpl();
    }
  }


}