package refactor.shopproject.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import refactor.shopproject.domain.member.Member;
import refactor.shopproject.domain.member.MemberBasicAddress;
import refactor.shopproject.domain.member.dto.MemberSignUpDto;
import refactor.shopproject.infrastructure.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public Boolean signUp(MemberSignUpDto memberSignUpDto) {
        memberSignUpDto.passwordEqualsCheck();

        String encodePassword = passwordEncoder.encode(memberSignUpDto.getPassword());
        Member member = Member.createMember(memberSignUpDto.getEmail(), encodePassword, memberSignUpDto.getName(),
                new MemberBasicAddress(memberSignUpDto.getCity(), memberSignUpDto.getStreet(),
                        memberSignUpDto.getZipcode()));

        memberRepository.save(member);
        return Boolean.TRUE;
    }
}
