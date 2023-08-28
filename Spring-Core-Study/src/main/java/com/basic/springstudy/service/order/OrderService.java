package com.basic.springstudy.service.order;

import com.basic.springstudy.entity.Order;

public interface OrderService {
  Order createOrder(Long memberId, String itemName, Integer itemPrice);
}
