package com.basic.jpastudy.entity;

import com.basic.jpastudy.entity.embedded.Address;
import com.basic.jpastudy.entity.embedded.Period;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  @Column(name = "MEMBER_ID")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Embedded
  private Period workPeriod;

  @Embedded
  private Address homeAddress;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "city", column = @Column(name = "work_city")),
      @AttributeOverride(name = "street", column = @Column(name = "work_street")),
      @AttributeOverride(name = "zipCode", column = @Column(name = "work_zip_code"))
  })
  private Address companyAddress;


  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "FAVORITE_FOOD", joinColumns = {
      @JoinColumn(name = "MEMBER_ID")
  })
  @Column(name = "FOOD_NAME")
  private Set<String> favoriteFoods = new HashSet<>();

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "ADDRESS", joinColumns = {
      @JoinColumn(name = "MEMBER_ID")
  })
  private List<Address> addressHistory = new ArrayList<>();
}