package daeunn.daeunspring;

import daeunn.daeunspring.repository.MemberRepository;
import daeunn.daeunspring.repository.MemoryMemberRepository;
import daeunn.daeunspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springConfig {
    // 스프링이 Configuration을 읽고 Bean에 등록해줌
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
