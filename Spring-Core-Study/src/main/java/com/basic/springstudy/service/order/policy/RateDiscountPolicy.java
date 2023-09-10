package com.basic.springstudy.service.order.policy;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.enums.Grade;

public class RateDiscountPolicy implements DiscountPolicy {

  private int discountPercent = 10; // 10% 할인

  @Override
  public int discount(Member member) {
    return 0;
  }

  @Override
  public int discount(Member member, int price) {
    if(member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    } else {
      return 0;
    }
  }
}
