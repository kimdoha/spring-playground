package com.basic.springstudy.service.order.policy;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.enums.Grade;

public class FixDiscountPolicy implements DiscountPolicy {
  private final int discountFixAmount = 1000;

  @Override
  public int discount(Member member) {
    if(member.getGrade().equals(Grade.VIP)) return discountFixAmount;
    return 0;
  }
}
