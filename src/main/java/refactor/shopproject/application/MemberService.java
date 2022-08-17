package refactor.shopproject.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import refactor.shopproject.common.AuthUtil;
import refactor.shopproject.common.SessionKey;
import refactor.shopproject.common.exception.MemberNotFoundException;
import refactor.shopproject.common.exception.PasswordNotEqualException;
import refactor.shopproject.domain.member.Member;
import refactor.shopproject.domain.member.MemberBasicAddress;
import refactor.shopproject.domain.member.dto.MemberLoginRequest;
import refactor.shopproject.domain.member.dto.MemberSessionValue;
import refactor.shopproject.domain.member.dto.MemberSignUpDto;
import refactor.shopproject.infrastructure.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;


    public Boolean signUp(MemberSignUpDto memberSignUpDto) {
        memberSignUpDto.passwordEqualsCheck();

        String encodePassword = passwordEncoder.encode(memberSignUpDto.getPassword());
        Member member = Member.createMember(memberSignUpDto.getEmail(), encodePassword, memberSignUpDto.getName(),
                new MemberBasicAddress(memberSignUpDto.getCity(), memberSignUpDto.getStreet(),
                        memberSignUpDto.getZipcode()));

        memberRepository.save(member);
        return Boolean.TRUE;
    }

    public MemberSessionValue signIn(MemberLoginRequest memberLoginRequest) {

        Member findMember = memberRepository.findById(memberLoginRequest.getEmail())
                .orElseThrow(() -> new MemberNotFoundException());

        passwordCheck(findMember, memberLoginRequest);

        authUtil.createSession().setAttribute(SessionKey.MEMBER.getValue(),
                new MemberSessionValue(findMember));

        return (MemberSessionValue) authUtil.createSession().getAttribute(SessionKey.MEMBER.getValue());
    }

    private void passwordCheck(Member member, MemberLoginRequest memberLoginRequest) {
        if (!passwordEncoder.matches(memberLoginRequest.getPassword(), member.getPassword())) {
            throw new PasswordNotEqualException();
        }
    }

}
