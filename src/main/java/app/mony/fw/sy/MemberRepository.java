package app.mony.fw.sy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByUserIdAndPassword(String userId, String password);
    List<Member> findAll();

    Object save(Member member);
}
