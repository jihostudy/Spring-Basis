package hello.core.service;

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
        long memberId = 1L;
        String memberName = "memberA";
        Member member = new Member(memberId,memberName, Grade.VIP);
        
        // 멤버를 저장소에 저장
        memberService.join(member);

        String orderItemName = "itemA";
        int orderItemPrice = 10000;
        Order order = orderService.createOrder(memberId,orderItemName,orderItemPrice);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
