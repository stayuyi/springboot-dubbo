package com.yy.provider1.service;

import com.yy.provider1.model.CalendarDateModel;

import java.util.Date;
import java.util.List;

public interface CalendarDateService {
    CalendarDateModel findCalendarDateModelById(Long id);

    int countBetweenDate(Long id, Date preDate, Date postDate);

    List<CalendarDateModel> findCalendarDateModelsByTenantId(Long tenantId);

    List<CalendarDateModel> findAll();


}
