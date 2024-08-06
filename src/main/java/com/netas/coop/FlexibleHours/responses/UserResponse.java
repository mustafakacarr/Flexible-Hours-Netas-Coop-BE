package com.netas.coop.FlexibleHours.responses;

import java.util.List;
import com.netas.coop.FlexibleHours.entities.User;

public class UserResponse {
    private long userId;
    private String fullName;
    private String email;
    private String department;
    private String management;
    private List<Long> permissions;

    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.fullName  = user.getFullName();
        this.email = user.getEmail();
        this.department = user.getDepartment().getDepartmentName();
        this.management = user.getManagement().getManagementName();

    }

}
