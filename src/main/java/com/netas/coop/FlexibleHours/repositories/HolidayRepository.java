package com.netas.coop.FlexibleHours.repositories;

import com.netas.coop.FlexibleHours.entities.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
}
