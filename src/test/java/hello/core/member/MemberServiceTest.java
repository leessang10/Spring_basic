package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    public void join() throws Exception {
        // given
        Member newMember = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(newMember);
        Member findMember = memberService.findMember(1L);

        // then
        // newMember와 findMember가 같은지 테스트
        Assertions.assertThat(newMember).isEqualTo(findMember);
    }
}