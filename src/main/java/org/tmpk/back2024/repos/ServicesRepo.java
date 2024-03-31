package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Services;
import org.tmpk.back2024.entity.Tariffs;

@Repository
public interface ServicesRepo extends JpaRepository<Services,Long> {
}
