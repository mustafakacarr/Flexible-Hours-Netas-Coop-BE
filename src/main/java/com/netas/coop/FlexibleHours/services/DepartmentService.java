package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.DepartmentEntity;
import com.netas.coop.FlexibleHours.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentEntity> getDepartmentById(long id) {
        return departmentRepository.findById(id);
    }

    public DepartmentEntity createDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public DepartmentEntity updateDepartment(long id, DepartmentEntity departmentDetails) {
        DepartmentEntity department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(departmentDetails.getName());
        department.setUnitEntity(departmentDetails.getUnitEntity());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }
}
