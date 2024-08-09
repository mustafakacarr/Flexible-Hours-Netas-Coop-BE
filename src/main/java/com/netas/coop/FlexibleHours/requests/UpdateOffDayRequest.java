package com.netas.coop.FlexibleHours.requests;

public record UpdateOffDayRequest(
    long id,
    long date,
    String description,
    long userId
) {
    
}
