package com.netas.coop.FlexibleHours.requests;

import com.netas.coop.FlexibleHours.enums.Role;

public record UpdateUserRequest(
        String fullName,
        String email,
        Role role
        
) {
}