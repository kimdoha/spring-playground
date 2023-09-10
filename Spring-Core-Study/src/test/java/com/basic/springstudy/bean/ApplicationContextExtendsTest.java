package com.basic.springstudy.bean;

import com.basic.springstudy.service.order.policy.RateDiscountPolicy;
import com.basic.springstudy.service.order.policy.DiscountPolicy;
import com.basic.springstudy.service.order.policy.FixDiscountPolicy;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextExtendsTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

  @Test
  @DisplayName("부모 타입으로 조회 시 자식이 두 개 이상이면 중복 오류가 발생한다")
  void findDuplicateBeanByParentType() {
    Assertions.assertThrows(
        NoUniqueBeanDefinitionException.class,
        () -> ac.getBean(DiscountPolicy.class)
    );
  }

  @Test
  @DisplayName("부모 타입으로 조회 시 자식이 두 개 이상이면 빈 이름을 지정한다")
  void findBeanByBeanNameAndParentType() {
    DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);

    Assertions.assertInstanceOf(RateDiscountPolicy.class, rateDiscountPolicy);
  }

  @Test
  @DisplayName("부모 타입으로 모든 빈 조회하기")
  void findAllBeanByParentType() {
    Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
    for(String key : beansOfType.keySet()) {
      System.out.println("key = " + key + " value = " + beansOfType.get(key));
    }

    Assertions.assertEquals(beansOfType.size(), 2);
  }

  @Configuration
  static class TestConfig {
    @Bean
    public DiscountPolicy fixDiscountPolicy() {
      return new FixDiscountPolicy();
    }

    @Bean
    public DiscountPolicy rateDiscountPolicy() {
      return new RateDiscountPolicy();
    }
  }
}
