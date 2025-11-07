package hello.core.discount;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
  RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP 멤버는 10% 할인이 적용되어야 한다.")
  void VIP_할인_테스트() {
    // given
    Member member = new Member(1L, "memberVIP", Grade.VIP);

    // when
    int discount = rateDiscountPolicy.discount(member, 10000);

    // then
    assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("BASIC 멤버는 할인이 적용되지 않아야 한다.")
  void BASIC_할인_테스트() {
    // given
    Member member = new Member(2L, "memberBASIC", Grade.BASIC);

    // when
    int discount = rateDiscountPolicy.discount(member, 10000);

    // then
    assertThat(discount).isEqualTo(0);
  }

}