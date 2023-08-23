package com.basic.springstudy.service;

import com.basic.springstudy.entity.Member;

public interface MemberService {
  Member memberJoin(Member member);

  Member findMember(Long memberId);
}
