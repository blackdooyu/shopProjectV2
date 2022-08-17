package refactor.shopproject.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import refactor.shopproject.application.MemberService;
import refactor.shopproject.common.ApiResult;
import refactor.shopproject.domain.member.dto.MemberLoginRequest;
import refactor.shopproject.domain.member.dto.MemberSessionValue;
import refactor.shopproject.domain.member.dto.MemberSignUpDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping
    public ResponseEntity<ApiResult> signUp(@Valid @RequestBody MemberSignUpDto memberSignUpDto) {
        ApiResult<Boolean> result = new ApiResult<>(memberService.signUp(memberSignUpDto), HttpStatus.OK.value());
        return ResponseEntity.ok(result);
    }

    //로그인
    @PostMapping("/auth")
    public ResponseEntity<ApiResult> signIn(@Valid @RequestBody MemberLoginRequest memberLoginRequest) {
        ApiResult<MemberSessionValue> result = new ApiResult<>(memberService.signIn(memberLoginRequest), HttpStatus.OK.value());
        return ResponseEntity.ok(result);
    }

}
