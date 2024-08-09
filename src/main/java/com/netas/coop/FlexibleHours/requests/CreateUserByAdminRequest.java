package com.netas.coop.FlexibleHours.requests;

import java.util.Set;

import com.netas.coop.FlexibleHours.entities.DepartmentEntity;
import com.netas.coop.FlexibleHours.entities.UnitEntity;
import com.netas.coop.FlexibleHours.enums.Role;

public record CreateUserByAdminRequest(
    String fullName,
    String email,
    String password,
    String registrationNumber,
    DepartmentEntity departmentEntity,
    UnitEntity unitEntity,
    Set<Role> roles
) {
}
