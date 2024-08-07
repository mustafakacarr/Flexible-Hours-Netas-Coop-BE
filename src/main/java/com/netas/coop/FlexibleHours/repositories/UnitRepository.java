package com.netas.coop.FlexibleHours.repositories;

import com.netas.coop.FlexibleHours.entities.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity, Long> {
}
