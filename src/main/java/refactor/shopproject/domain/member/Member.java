package refactor.shopproject.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import refactor.shopproject.domain.BaseTime;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTime implements Persistable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private MemberGrade memberGrade;

    private MemberBasicAddress basicAddress;

    // 멤버 생성 편의 메서드
    public static Member createMember(String email, String password, String name, MemberBasicAddress basicAddress) {
        Member member = new Member();
        member.email = email;
        member.password = password;
        member.name = name;
        member.basicAddress = basicAddress;
        member.memberGrade = MemberGrade.BASIC;
        return member;
    }


    @Override
    public String getId() {
        return null;
    }

    // 새로 추가하는 데이터인지에 대해서 확인 ( merge 방지 )
    @Override
    public boolean isNew() {
        if (this.getCreateDate() == null) {
            return true;
        }
        return false;
    }
}
