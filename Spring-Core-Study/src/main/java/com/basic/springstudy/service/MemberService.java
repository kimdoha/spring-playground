package com.basic.springstudy.service;

import com.basic.springstudy.entity.Member;

public interface MemberService {
  void join(Member member);
  Member findMember(Long memberId);
}
