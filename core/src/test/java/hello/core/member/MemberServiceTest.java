package hello.core.member;

import hello.core.AppConfig;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

  MemberService memberService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
  }

  @Test
  @DisplayName("회원가입 테스트")
  void join() {
    // given
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);

    // when
    memberService.join(member);
    Member findMember = memberService.findMember(memberId);

    // then
    Assertions.assertThat(member).isEqualTo(findMember);
  }
}
