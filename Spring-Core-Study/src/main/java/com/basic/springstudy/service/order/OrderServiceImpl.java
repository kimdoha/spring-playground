package com.basic.springstudy.service.order;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.entity.Order;
import com.basic.springstudy.repository.MemberRepository;
import com.basic.springstudy.repository.MemoryMemberRepository;
import com.basic.springstudy.repository.OrderRepository;
import com.basic.springstudy.service.order.policy.DiscountPolicy;
import com.basic.springstudy.service.order.policy.FixDiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final MemoryMemberRepository memberRepository;
  private final OrderRepository orderRepository;
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  //테스트 용도
  public MemoryMemberRepository getMemberRepository() {
    return memberRepository;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, Integer itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member);

    Order order = Order.of(itemName, itemPrice, discountPrice);
    return orderRepository.save(order);
  }
}
