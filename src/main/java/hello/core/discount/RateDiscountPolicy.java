package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 금액 비율 할인 정책
 */
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; // 할인율: 10%

    @Override
    public int discount(Member member, int price) {
        // 멤버 등급에 따라 할인 금액을 반환한다.
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }

    }
}
