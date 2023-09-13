//package com.basic.springstudy.config;
//
//import com.basic.springstudy.repository.MemoryMemberRepository;
//import com.basic.springstudy.repository.MemoryMemberRepositoryImpl;
//import com.basic.springstudy.service.member.MemberService;
//import com.basic.springstudy.service.member.MemberServiceImpl;
//import com.basic.springstudy.service.order.policy.DiscountPolicy;
//import com.basic.springstudy.service.order.policy.FixDiscountPolicy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
//  @Bean
//  public MemberService memberService() {
//    return new MemberServiceImpl(memoryMemberRepository());
//  }
//
//  @Bean
//  public MemoryMemberRepository memoryMemberRepository() {
//    return new MemoryMemberRepositoryImpl();
//  }
//
//  @Bean
//  public DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
//  }
//}