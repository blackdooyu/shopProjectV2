package refactor.shopproject.domain.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import refactor.shopproject.common.exception.PasswordNotEqualException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignUpDto {

    @Email
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String secondInputPassword;

    @NotNull(message = "이름은 필수입니다.")
    private String name;

    private String city;

    private String street;

    private String zipcode;


    public void passwordEqualsCheck() {
        if (!password.equals(secondInputPassword)) {
            throw new PasswordNotEqualException();
        }

    }
}
