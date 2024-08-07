package com.netas.coop.FlexibleHours.repositories;

import com.netas.coop.FlexibleHours.entities.OffDayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffDayRepository extends JpaRepository<OffDayEntity, Long>{
}
