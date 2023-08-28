//package com.basic.springstudy.service.order;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.basic.springstudy.entity.Member;
//import com.basic.springstudy.entity.Order;
//import com.basic.springstudy.entity.enums.Grade;
//import com.basic.springstudy.repository.MemberRepository;
//import com.basic.springstudy.repository.OrderRepository;
//import com.basic.springstudy.service.member.MemberServiceImpl;
//import com.basic.springstudy.service.order.policy.FixDiscountPolicy;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class OrderServiceTest {
//
//  @InjectMocks
//  MemberServiceImpl memberService;
//  @InjectMocks
//  OrderServiceImpl orderService;
//  @Mock
//  MemberRepository memberRepository;
//  @Mock
//  OrderRepository orderRepository;
//
//  @Mock
//  FixDiscountPolicy discountPolicy;
//
//
//  @BeforeEach
//  void beforeEach() {
//    memberService = new MemberServiceImpl(memberRepository);
//    orderService = new OrderServiceImpl(
//        memberRepository,
//        orderRepository,
//        discountPolicy
//    );
//  }
//
//  @Test
//  void createOrder() {
//    Member member = Member.of("doha", Grade.VIP);
//    memberService.join(member);
//
//    Order order = orderService.createOrder( member.getId(), "itemA", 10000);
//    assertThat(order.getDiscountPrice()).isEqualTo(1000);
//  }
//}