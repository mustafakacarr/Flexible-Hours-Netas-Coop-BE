package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.UnitEntity;
import com.netas.coop.FlexibleHours.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public List<UnitEntity> getAllUnits() {
        return unitRepository.findAll();
    }

    public Optional<UnitEntity> getUnitById(long id) {
        return unitRepository.findById(id);
    }

    public UnitEntity createUnit(UnitEntity unit) {
        return unitRepository.save(unit);
    }

    public UnitEntity updateUnit(long id, UnitEntity unitDetails) {
        UnitEntity unit = unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
        unit.setName(unitDetails.getName());
        return unitRepository.save(unit);
    }

    public void deleteUnit(long id) {
        unitRepository.deleteById(id);
    }
}
