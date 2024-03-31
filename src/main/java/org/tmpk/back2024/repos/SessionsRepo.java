package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Sessions;

@Repository
public interface SessionsRepo extends JpaRepository<Sessions,Long> {

    @Query(value = "SELECT * FROM sessions WHERE token = ?1 AND expirytime > NOW()", nativeQuery = true)
    Sessions findNonExpiredSessionByToken(String token);

    @Query(value = "SELECT * FROM sessions WHERE operatorid = ?1 AND expirytime > NOW()", nativeQuery = true)
    Sessions findNonExpiredSessionByOperatorId(Long operatorId);

}
