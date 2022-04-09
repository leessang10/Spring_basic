package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 멤버는 10% 할인이 적용된다.")
    public void vip_o() throws Exception {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        // 할인 금액이 1000원인지 판별
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("BASIC 멤버는 0% 할인이 적용된다.")
    public void basic_o() throws Exception {
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        // 할인 금액이 1000원인지 판별
        Assertions.assertThat(discount).isEqualTo(0);
    }
}