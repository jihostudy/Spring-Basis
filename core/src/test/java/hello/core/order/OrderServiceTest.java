package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.domain.Order;
import hello.core.order.service.OrderService;
import hello.core.order.service.OrderServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();


    @Test
    @DisplayName("주문 생성 테스트")
    void createOrderTest(){
        // given
        long memberId = 1L;
        String memberName = "memberA";

        String orderItemName = "itemA";
        int orderItemPrice = 10000;


        // when
        Member member = new Member(memberId,memberName, Grade.VIP);
        memberService.join(member); // 멤버를 저장소에 저장
        Order order = orderService.createOrder(memberId,orderItemName,orderItemPrice); // 주문 생성

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
