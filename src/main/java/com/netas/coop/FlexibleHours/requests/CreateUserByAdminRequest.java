package com.netas.coop.FlexibleHours.requests;

import com.netas.coop.FlexibleHours.enums.*;
import lombok.Data;

@Data
public class CreateUserByAdminRequest {
    private String fullName;
    private String email;

    private String password;
    private Role role;
    
    
}
