package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Member;

// Long <-> Member의 pk가 뭘로 매핑되어있는건지
public interface MemberRepository extends JpaRepository<Member, Long> {

}
