package hello.core.discount;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int DISCOUNT_FIX_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return DISCOUNT_FIX_AMOUNT;
        }
        else {
            return 0;
        }
    }
}
