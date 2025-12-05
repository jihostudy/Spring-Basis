package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.service.OrderService;
import hello.core.order.service.OrderServiceImpl;

public class AppConfig {

  // AppConfig에서 구현체를 생성하여 제공, 각 서비스는 인터페이스에만 의존하고 구현체에는 의존하지 않음
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }
}
