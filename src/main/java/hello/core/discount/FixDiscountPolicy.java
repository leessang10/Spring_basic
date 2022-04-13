package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

/**
 *  고정 금액 할인 정책
 *
 */
public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountFixAmount = 1000;   // 1000원 개발

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
