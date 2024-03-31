package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Logger;

@Repository
public interface LoggerRepo extends JpaRepository<Logger,Long> {
}
