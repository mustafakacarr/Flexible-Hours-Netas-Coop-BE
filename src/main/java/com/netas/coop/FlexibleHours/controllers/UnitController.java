package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.requests.CreateUnitRequest;
import com.netas.coop.FlexibleHours.requests.UpdateUnitRequest;
import com.netas.coop.FlexibleHours.responses.UnitResponse;
import com.netas.coop.FlexibleHours.services.UnitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/units")
public class UnitController {
    private UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public List<UnitResponse> getAllUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/{id}")
    public UnitResponse getUnitById(@PathVariable long id) {
        return unitService.getUnitById(id);

    }

    @PostMapping
    public UnitResponse createUnit(@RequestBody CreateUnitRequest request) {
        return unitService.createUnit(request);
    }

    @PutMapping("/{id}")
    public UnitResponse updateUnit(@PathVariable long id, @RequestBody UpdateUnitRequest request) {
        return unitService.updateUnit(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUnit(@PathVariable long id) {
        unitService.deleteUnit(id);

    }
}
