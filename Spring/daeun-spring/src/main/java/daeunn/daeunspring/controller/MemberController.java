package daeunn.daeunspring.controller;

import daeunn.daeunspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // 다음과같이 memberService를 생성하면 memberController 말고 다른 controller에서도
    // memberService를 가져다 쓸 수 있는 상황이라 문제가 됨
    // private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    // Autowired -> 스프링 컨테이너에서 memberService를 가져온다
    @Autowired
    // memberService 빨간줄 -> @Service
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}






















