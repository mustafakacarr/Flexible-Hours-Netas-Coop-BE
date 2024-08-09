package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.DepartmentEntity;
import com.netas.coop.FlexibleHours.entities.UnitEntity;
import com.netas.coop.FlexibleHours.repositories.DepartmentRepository;
import com.netas.coop.FlexibleHours.repositories.UnitRepository;
import com.netas.coop.FlexibleHours.requests.DepartmentRequest;
import com.netas.coop.FlexibleHours.responses.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {


    private DepartmentRepository departmentRepository;

    private UnitRepository unitRepository;

    public DepartmentService(DepartmentRepository departmentRepository, UnitRepository unitRepository) {
        this.departmentRepository = departmentRepository;
        this.unitRepository = unitRepository;
    }

    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map((departmentEntity) -> new DepartmentResponse(departmentEntity))
                .collect(Collectors.toList());
    }

    public DepartmentResponse getDepartmentById(long id) {
        DepartmentEntity department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return new DepartmentResponse(department);
    }

    public DepartmentResponse createDepartment(DepartmentRequest request) {
        DepartmentEntity department = new DepartmentEntity();
        UnitEntity unit = unitRepository.findById(request.unitId()).orElseThrow(() -> new RuntimeException("Unit not found"));
        department.setName(request.name());
        department.setUnitEntity(unit);
        return new DepartmentResponse(department);
    }

    public DepartmentResponse updateDepartment(long id, DepartmentRequest departmentRequest) {
        DepartmentEntity department = new DepartmentEntity();
        UnitEntity unit=unitRepository.findById(departmentRequest.unitId()).orElseThrow(()->new RuntimeException("Unit not found"));
        department.setName(departmentRequest.name());
        department.setUnitEntity(unit);
        return new DepartmentResponse(departmentRepository.save(department));

    }

    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }
}
