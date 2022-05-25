package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
// 실무에서는 가급적 entity에 @Setter 사용x
public class Member {
    @Id @GeneratedValue
    // GeneratedValue <-> pk값을 jpa가 알아서 넣어줌
    private Long id;
    private String username;

    // jpa <-> 아무데나 호출되지 않게 하기위해 protected 기본생성자 필요
    // Entity는 기본생성자가 있어야함, protected까지 열어놓아야함 <-> proxy기술 사용
    protected Member(){
    }

    public Member(String username){
        this.username = username;
    }
}


