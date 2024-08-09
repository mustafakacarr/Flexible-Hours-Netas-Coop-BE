package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.UnitEntity;
import com.netas.coop.FlexibleHours.repositories.UnitRepository;
import com.netas.coop.FlexibleHours.requests.CreateUnitRequest;
import com.netas.coop.FlexibleHours.requests.UpdateUnitRequest;
import com.netas.coop.FlexibleHours.responses.UnitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitService {


    private UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<UnitResponse> getAllUnits() {
        return unitRepository.findAll().stream()
                .map((unitEntity) -> new UnitResponse(unitEntity))
                .collect(Collectors.toList());
    }

    public UnitResponse getUnitById(long id) {
        UnitEntity unit = unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
        return new UnitResponse(unit);
    }

    public UnitResponse createUnit(CreateUnitRequest request) {
        UnitEntity unit = new UnitEntity();
        unit.setName(request.name());
        return new UnitResponse(unitRepository.save(unit));
    }

    public UnitResponse updateUnit(long id, UpdateUnitRequest updateRequest){
        UnitEntity existUnit = unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
        existUnit.setName(updateRequest.name());
        return new UnitResponse(unitRepository.save(existUnit));
    }

    public void deleteUnit(long id) {
        unitRepository.deleteById(id);
    }
}
