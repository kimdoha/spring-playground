package com.basic.jpastudy.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {
  private String city;

  private String street;

  @Column(name = "zipcode")
  private String zipCode;
}
