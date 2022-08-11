package refactor.shopproject.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import refactor.shopproject.application.MemberService;
import refactor.shopproject.common.ApiResult;
import refactor.shopproject.domain.member.dto.MemberSignUpDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public ApiResult<Boolean> signUp(@Valid @RequestBody MemberSignUpDto memberSignUpDto) {
        return new ApiResult<>(memberService.signUp(memberSignUpDto));
    }
}
