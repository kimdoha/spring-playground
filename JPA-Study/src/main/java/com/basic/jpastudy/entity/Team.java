package com.basic.jpastudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
@Entity
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  private ZonedDateTime createdDate;
  private ZonedDateTime lastModifiedDate;

  @OneToMany(mappedBy = "team")
  private List<Member> members;

  public static Team of(String name) {
    return Team.builder()
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
