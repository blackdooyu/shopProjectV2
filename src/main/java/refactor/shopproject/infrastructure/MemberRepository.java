package refactor.shopproject.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import refactor.shopproject.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
