package com.netas.coop.FlexibleHours.requests;

public record ChangePasswordRequest(
        String oldPassword,
        String newPassword
) {
}
