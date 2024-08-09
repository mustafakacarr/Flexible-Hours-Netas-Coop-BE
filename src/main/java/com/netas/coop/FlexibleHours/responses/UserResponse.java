package com.netas.coop.FlexibleHours.responses;

import java.util.Set;

import com.netas.coop.FlexibleHours.entities.UserEntity;
import com.netas.coop.FlexibleHours.enums.Role;

import lombok.Data;

@Data
public class UserResponse {
    private long id;
    private String fullName;
    private String email;
    private String registrationNumber;
    private DepartmentResponse department;
    private UnitResponse unit;
    private Set<Role> authorities;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.fullName = userEntity.getFullName();
        this.email = userEntity.getEmail();
        this.registrationNumber = userEntity.getRegistrationNumber();
        this.department = new DepartmentResponse(userEntity.getDepartmentEntity());
        this.unit = new UnitResponse(userEntity.getUnitEntity());
        this.authorities = userEntity.getAuthorities();
    }
}
