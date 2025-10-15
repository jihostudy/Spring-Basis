package hello.core;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.domain.Order;
import hello.core.order.service.OrderService;
import hello.core.order.service.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        String memberName = "memberA";
        Member member = new Member(memberId, memberName, Grade.VIP);

        String orderItemName = "itemA";
        Order order = orderService.createOrder(memberId, orderItemName,10000);

        System.out.println("order: " + order);
    }
}
