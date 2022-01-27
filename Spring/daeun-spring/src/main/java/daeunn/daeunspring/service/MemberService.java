package daeunn.daeunspring.service;

import daeunn.daeunspring.domain.Member;
import daeunn.daeunspring.repository.MemberRepository;
import daeunn.daeunspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member){
        // 같은이름 중복회원은 안된다
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        // null이 아니고 값이 있으면 동작하는 로직 <-> Optional
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        // Optional member.ifPresent로 깔끔하게 코드 변경
        validateDuplicateMember(member);    // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // extracted method
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
