package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.Payments;
import org.tmpk.back2024.entity.Roles;

import java.util.List;

@Repository
public interface PaymentsRepo extends JpaRepository<Payments,Long> {
    @Query(value = "SELECT * FROM payments WHERE clientid = ?1", nativeQuery = true)
    List<Payments> findAllByClientId(Long id);
}
