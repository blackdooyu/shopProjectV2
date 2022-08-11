package refactor.shopproject.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import refactor.shopproject.infrastructure.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Boolean signUp() {

        return Boolean.TRUE;
    }
}
