package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Clients;
import org.tmpk.back2024.entity.Services;

@Repository
public interface ClientsRepo extends JpaRepository<Clients,Long> {
}
