package hello.core.member.service;

import hello.core.member.domain.Member;
import hello.core.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  // 생성자 주입 방식을 통해, MemberRepository 구현체를 외부에서 주입받음 / 인터페이스에만 의존
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }


  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
