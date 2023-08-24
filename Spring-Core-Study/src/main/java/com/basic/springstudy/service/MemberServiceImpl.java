package com.basic.springstudy.service;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
  private final MemberRepository memberRepository;

  @Override
  @Transactional
  public Long join(Member member) {
    Member newMember = memberRepository.save(member);
    return newMember.getId();
  }

  @Override
  @Transactional(readOnly = true)
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId).get();
  }
}
