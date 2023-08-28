package com.basic.springstudy.service.member;

import com.basic.springstudy.entity.Member;

public interface MemberService {
  Long join(Member member);
  Member findMember(Long memberId);
}
