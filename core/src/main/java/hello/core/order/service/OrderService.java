package hello.core.order.service;

import hello.core.order.domain.Order;

public interface OrderService {
    /**
     * 주문 생성
     * @return 생성된 주문
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
