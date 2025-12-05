package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.order.domain.Order;
import hello.core.order.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }


  @Test
  @DisplayName("주문 생성 테스트")
  void createOrderTest() {
    // given
    long memberId = 1L;
    String memberName = "memberA";

    String orderItemName = "itemA";
    int orderItemPrice = 10000;


    // when
    Member member = new Member(memberId, memberName, Grade.VIP);
    memberService.join(member); // 멤버를 저장소에 저장
    Order order = orderService.createOrder(memberId, orderItemName, orderItemPrice); // 주문 생성

    // then
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
