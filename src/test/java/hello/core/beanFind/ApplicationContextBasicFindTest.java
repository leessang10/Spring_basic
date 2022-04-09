package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Bean 이름으로 조회")
    public void findBeanByName() throws Exception {
        // given
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("인터페이스 타입으로 조회")
    public void findBeanByInterfaceType() throws Exception {
        // given
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구현체 타입으로 조회")
    public void findBeanByImplType() throws Exception {
        // given
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    public void findBeanByNameX() throws Exception {
        // given
        assertThrows(NoSuchBeanDefinitionException.class
                , () -> ac.getBean("xxx", MemberServiceImpl.class));
    }
}
