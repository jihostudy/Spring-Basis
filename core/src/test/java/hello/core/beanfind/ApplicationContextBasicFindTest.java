package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 타입으로 조회")
  void findBeanByType() {
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanBySpecificType() {
    MemberServiceImpl memberServiceImpl = ac.getBean("memberService", MemberServiceImpl.class);
    assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("없는 빈 이름으로 조회 -> 에러 발생시키기")
  void findBeanThatNotExists() {
    // ac.getBean("doesnotexist", MemberServiceImpl.class);
    assertThrows(NoSuchBeanDefinitionException.class,
            () -> ac.getBean("doesnotexist", MemberServiceImpl.class)
    );
  }
}
