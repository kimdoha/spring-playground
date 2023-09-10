package com.basic.springstudy.service.order.policy;

import com.basic.springstudy.entity.Member;

public interface DiscountPolicy {
  /**
   * @return 할인 금액
   */
  int discount(Member member);

  int discount(Member member, int price);
}
