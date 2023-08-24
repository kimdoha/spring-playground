package com.basic.springstudy.service;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
  private final MemberRepository memberRepository;

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId).get();
  }
}
