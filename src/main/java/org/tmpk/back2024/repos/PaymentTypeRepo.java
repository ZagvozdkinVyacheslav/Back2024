package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.PaymentType;
import org.tmpk.back2024.entity.Payments;

import java.util.List;

@Repository
public interface PaymentTypeRepo extends JpaRepository<PaymentType,Long> {
    @Query(value = "SELECT * FROM paymenttype WHERE name = ?1", nativeQuery = true)
    PaymentType findByName(String name);
}
