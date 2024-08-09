package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.entities.DepartmentEntity;
import com.netas.coop.FlexibleHours.services.DepartmentService;
import com.netas.coop.FlexibleHours.dtos.DepartmentRequest;
import com.netas.coop.FlexibleHours.dtos.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartments().stream()
                .map(DepartmentResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable long id) {
        return departmentService.getDepartmentById(id)
                .map(department -> ResponseEntity.ok(DepartmentResponse.fromEntity(department)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DepartmentResponse createDepartment(@RequestBody DepartmentRequest request) {
        DepartmentEntity department = new DepartmentEntity();
        department.setName(request.name());
        department.setUnitEntity(request.unitEntity());
        return DepartmentResponse.fromEntity(departmentService.createDepartment(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable long id, @RequestBody DepartmentRequest request) {
        DepartmentEntity department = new DepartmentEntity();
        department.setName(request.name());
        department.setUnitEntity(request.unitEntity());
        return ResponseEntity.ok(DepartmentResponse.fromEntity(departmentService.updateDepartment(id, department)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
