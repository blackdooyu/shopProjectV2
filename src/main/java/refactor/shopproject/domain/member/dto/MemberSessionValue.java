package refactor.shopproject.domain.member.dto;

import lombok.Getter;
import refactor.shopproject.domain.member.Member;
import refactor.shopproject.domain.member.MemberGrade;

@Getter
public class MemberSessionValue {

    private String email;

    private String name;

    private MemberGrade memberGrade;

    public MemberSessionValue(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.memberGrade = member.getMemberGrade();
    }
}
