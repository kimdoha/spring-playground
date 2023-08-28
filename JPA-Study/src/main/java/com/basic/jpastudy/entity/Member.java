package com.basic.jpastudy.entity;

import com.basic.jpastudy.entity.enums.RoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
@Entity
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String city;
  private String street;
  @Column(name = "zipcode")
  private String zipCode;

  @Enumerated(value = EnumType.STRING)
  private RoleType roleType;

  @OneToMany
  private List<Order> orderList;

  private ZonedDateTime createdDate;
  private ZonedDateTime lastModifiedDate;

  public Member update(
      String name,
      String city,
      String street,
      String zipCode
  ) {
    this.name = name;
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;

    return this;
  }

  public static Member of(String name) {
    return Member.builder()
        .name(name)
        .build();
  }

  @PrePersist
  void onPrePersist() {
    this.createdDate = ZonedDateTime.now();
    this.lastModifiedDate = ZonedDateTime.now();
  }

  @PreUpdate
  void onPreUpdate() {
    this.lastModifiedDate = ZonedDateTime.now();
  }
}