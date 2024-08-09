package com.netas.coop.FlexibleHours.responses;

public class HolidayResponse {
    private long id;
    private long startDate;
    private long endDate;
    private String name;

    public HolidayResponse(long id, long startDate, long endDate, String name) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
    }
}
