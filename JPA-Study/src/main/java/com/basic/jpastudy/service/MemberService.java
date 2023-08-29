package com.basic.jpastudy.service;

import com.basic.jpastudy.entity.Member;
import com.basic.jpastudy.entity.Team;
import com.basic.jpastudy.repository.MemberRepository;
import com.basic.jpastudy.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;
  private final TeamRepository teamRepository;

  public String memberJoin() {
    Team team = Team.of("tigers");
    Member member = Member.of("doha", team);

    teamRepository.save(team);
    memberRepository.save(member);

    return "ok";
  }
}
