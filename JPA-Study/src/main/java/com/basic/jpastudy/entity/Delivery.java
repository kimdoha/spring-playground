package com.basic.jpastudy.entity;

import com.basic.jpastudy.entity.embedded.Address;
import com.basic.jpastudy.entity.enums.DeliveryStatus;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliveries")
@Entity
public class Delivery extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private Address deiveryAddress;

  @Enumerated(value = EnumType.STRING)
  private DeliveryStatus deliveryStatus;

}
