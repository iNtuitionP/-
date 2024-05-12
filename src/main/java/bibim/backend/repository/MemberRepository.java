package bibim.backend.repository;

import bibim.backend.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
}
