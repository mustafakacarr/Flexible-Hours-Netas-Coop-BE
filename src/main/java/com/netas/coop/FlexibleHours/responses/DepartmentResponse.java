package com.netas.coop.FlexibleHours.responses;

import com.netas.coop.FlexibleHours.entities.DepartmentEntity;

import lombok.Data;

@Data
public class DepartmentResponse {
    private long id;
    private String name;

    public DepartmentResponse(DepartmentEntity departmentEntity) {
        this.id = departmentEntity.getId();
        this.name = departmentEntity.getName();
    }

}
