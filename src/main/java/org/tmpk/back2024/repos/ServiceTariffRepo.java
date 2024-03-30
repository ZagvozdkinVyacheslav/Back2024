package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.entity.Services;

import java.util.List;

@Repository
public interface ServiceTariffRepo extends JpaRepository<ServiceTariff,Long> {
    @Query(value = "SELECT * FROM servicetariff WHERE clientid = ?1", nativeQuery = true)
    List<ServiceTariff> findAllByClientId(Long id);
}
