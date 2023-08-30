package com.basic.jpastudy.entity;

import com.basic.jpastudy.entity.enums.DeliveryStatus;
import jakarta.persistence.Column;
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
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String city;

  private String street;

  @Column(name = "zip_code")
  private String zipCode;

  @Enumerated(value = EnumType.STRING)
  private DeliveryStatus deliveryStatus;

}
