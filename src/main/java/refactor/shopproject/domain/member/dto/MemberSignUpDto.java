package refactor.shopproject.domain.member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import refactor.shopproject.common.exception.PasswordNotEqualException;
import refactor.shopproject.domain.member.MemberBasicAddress;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignUpDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String secondInputPassword;

    @Column(nullable = false)
    private String name;

    private String city;

    private String street;

    private String zipcode;

    @Builder
    public MemberSignUpDto(String email, String password, String secondInputPassword, String name, String city, String street, String zipcode) {
        this.email = email;
        this.password = password;
        this.secondInputPassword = secondInputPassword;
        passwordEqualsCheck();
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public void passwordEqualsCheck() {
        if (!password.equals(secondInputPassword)) {
            throw new PasswordNotEqualException();
        }

    }
}
