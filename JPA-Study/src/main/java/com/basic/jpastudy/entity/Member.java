package com.basic.jpastudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team team;

  private ZonedDateTime createdDate;
  private ZonedDateTime lastModifiedDate;

  public static Member of(String name, Team team) {
    return Member.builder()
        .name(name)
        .team(team)
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