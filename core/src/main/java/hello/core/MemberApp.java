package hello.core;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

  public static void main(String[] args) {

//     AppConfig에서 구현체 생성 및 주입
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();

    // 스프링 컨테이너에서 빈(Bean)으로 관리되는 MemberService 가져오기
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(member.getId());
    System.out.println("new member = " + member.getName());
    System.out.println("findMember = " + findMember.getName());
  }
}
