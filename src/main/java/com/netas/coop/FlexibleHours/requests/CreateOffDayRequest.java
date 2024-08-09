package com.netas.coop.FlexibleHours.requests;

public record CreateOffDayRequest(
    long date,
    String description,
    long userId
) {
    
}
