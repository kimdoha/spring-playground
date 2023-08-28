package com.basic.springstudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String itemName;
  private Integer itemPrice;
  private Integer discountPrice;

  public static Order of(
      String itemName,
      Integer itemPrice,
      Integer discountPrice) {
    return Order.builder()
        .itemName(itemName)
        .itemPrice(itemPrice)
        .discountPrice(discountPrice)
        .build();
  }

  public int calculatePrice() {
    return itemPrice - discountPrice;
  }
}
