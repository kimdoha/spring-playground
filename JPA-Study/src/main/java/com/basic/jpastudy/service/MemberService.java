package com.basic.jpastudy.service;

import com.basic.jpastudy.entity.Child;
import com.basic.jpastudy.entity.Parent;
import com.basic.jpastudy.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final ParentRepository parentRepository;

  @Transactional
  public String createMember() {

    Child child1 = Child.of("James Son");
    Child child2 = Child.of("James Daughter");

    Parent parent = Parent.of("James");
    parent.addChild(child1);
    parent.addChild(child2);

    parentRepository.save(parent);

    parent.getChildList().remove(0);

    parentRepository.delete(parent);
    return "success";
  }
}
