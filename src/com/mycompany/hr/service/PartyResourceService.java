package com.mycompany.hr.service;

import java.util.Date;

public interface PartyResourceService {
    void bookHoliday(Date startDate, Date endDate, String name);
}