package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.entities.UnitEntity;
import com.netas.coop.FlexibleHours.services.UnitService;
import com.netas.coop.FlexibleHours.dtos.UnitRequest;
import com.netas.coop.FlexibleHours.dtos.UnitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping
    public List<UnitResponse> getAllUnits() {
        return unitService.getAllUnits().stream()
                .map(UnitResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitResponse> getUnitById(@PathVariable long id) {
        return unitService.getUnitById(id)
                .map(unit -> ResponseEntity.ok(UnitResponse.fromEntity(unit)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UnitResponse createUnit(@RequestBody UnitRequest request) {
        UnitEntity unit = new UnitEntity();
        unit.setName(request.name());
        return UnitResponse.fromEntity(unitService.createUnit(unit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitResponse> updateUnit(@PathVariable long id, @RequestBody UnitRequest request) {
        UnitEntity unit = new UnitEntity();
        unit.setName(request.name());
        return ResponseEntity.ok(UnitResponse.fromEntity(unitService.updateUnit(id, unit)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable long id) {
        unitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }
}
