package com.basic.jpastudy.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class BaseEntity {
  private ZonedDateTime createdDate;
  private ZonedDateTime lastModifiedDate;

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
