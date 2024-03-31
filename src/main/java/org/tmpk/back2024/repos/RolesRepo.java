package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Roles;
import org.tmpk.back2024.entity.ServiceTariff;

import java.util.List;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {
    @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
    Roles findByName(String name);
}
