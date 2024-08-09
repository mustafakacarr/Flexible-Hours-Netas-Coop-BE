package com.netas.coop.FlexibleHours.responses;

public class OffDayResponse {
    private long id;
    private long date;
    private String description;
    private long userId;

    public OffDayResponse(long id, long date, String description, long userId) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.userId = userId;
    }
}
