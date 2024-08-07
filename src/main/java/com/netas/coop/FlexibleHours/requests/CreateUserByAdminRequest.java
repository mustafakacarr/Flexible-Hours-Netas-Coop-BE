package com.netas.coop.FlexibleHours.requests;

import com.netas.coop.FlexibleHours.enums.*;
import lombok.Data;


public record CreateUserByAdminRequest(
        String fullName,
        String email,
        String password,
        Role role,
        long departmentId,
        long unitId,
        long registrationNumber
) {


}
