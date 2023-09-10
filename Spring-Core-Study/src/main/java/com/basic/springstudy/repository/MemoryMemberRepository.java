package com.basic.springstudy.repository;

import com.basic.springstudy.entity.Member;

public interface MemoryMemberRepository {
  void save(Member member);
  Member findById(Long memberId);
}
