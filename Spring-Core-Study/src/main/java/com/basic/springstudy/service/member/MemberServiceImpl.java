package com.basic.springstudy.service.member;

import com.basic.springstudy.entity.Member;
import com.basic.springstudy.repository.MemberRepository;
import com.basic.springstudy.repository.MemoryMemberRepository;
import com.basic.springstudy.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
  private final MemoryMemberRepository memberRepository;

  //테스트 용도
  public MemoryMemberRepository getMemberRepository() {
    return memberRepository;
  }

  @Override
  @Transactional
  public Long join(Member member) {
    memberRepository.save(member);
    return member.getId();
  }

  @Override
  @Transactional(readOnly = true)
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
