package com.netas.coop.FlexibleHours.responses;

import com.netas.coop.FlexibleHours.entities.UserEntity;
import lombok.Data;

@Data
public class UserResponse {
    private long userId;
    private String fullName;
    private String email;
    private String departmentName;
    private String unitName;
    private long departmentId;
    private long unitId;


    public UserResponse(UserEntity userEntity) {
        this.userId = userEntity.getId();
        this.fullName  = userEntity.getFullName();
        this.email = userEntity.getEmail();
        this.departmentName = userEntity.getDepartmentEntity().getUnitEntity().getName();
        this.unitName = userEntity.getDepartmentEntity().getName();
        this.departmentId = userEntity.getDepartmentEntity().getUnitEntity().getId();
        this.unitId = userEntity.getDepartmentEntity().getId();
    }

}
