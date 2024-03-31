package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.Correction;
import org.tmpk.back2024.entity.Roles;

import java.util.List;


@Repository
public interface CorrectionRepo extends JpaRepository<Correction,Long> {
    @Query(value = "SELECT * FROM correction WHERE clientid = ?1", nativeQuery = true)
    List<Correction> findAllByClientId(Long clientId);
}
