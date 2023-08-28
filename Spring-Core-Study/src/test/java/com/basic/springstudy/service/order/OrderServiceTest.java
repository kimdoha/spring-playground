package com.basic.springstudy.service.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.Order;
import com.basic.springstudy.entity.enums.Grade;
import com.basic.springstudy.repository.MemberRepository;
import com.basic.springstudy.service.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class OrderServiceTest {

  @Autowired
  MemberServiceImpl memberService;
  @Autowired
  OrderServiceImpl orderService;
  @Autowired
  MemberRepository memberRepository;


  @Test
  void createOrder() {
    // given
    Member member = Member.of("doha", Grade.VIP);
    memberService.join(member);

    // when
    Order order = orderService.createOrder(member.getId(), "itemA", 10000);

    // then
    assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}