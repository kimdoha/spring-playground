package com.basic.jpastudy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parents")
@Entity
public class Parent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private List<Child> childList;

  public static Parent of(String name) {
    return Parent.builder()
        .name(name)
        .childList(new ArrayList<>())
        .build();
  }

  public void addChild(Child child) {
    childList.add(child);
    child.updateParent(this);
  }
}
