package com.yy.provider1.service.impl;

import com.yy.provider1.model.CalendarDateModel;
import com.yy.provider1.repository.CalendarDateRepositroy;
import com.yy.provider1.service.CalendarDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CalendarDateServiceImpl implements CalendarDateService {
    @Autowired
    private CalendarDateRepositroy calendarDateRepositroy;

    @Override
    public CalendarDateModel findCalendarDateModelById(Long id) {
        return calendarDateRepositroy.findCalendarDateModelById(id);
    }

    @Override
    public int countBetweenDate(Long id, Date preDate, Date postDate) {
        return calendarDateRepositroy.countByIdAndDateBetween(id, postDate, postDate);
    }

    @Override
    public List<CalendarDateModel> findCalendarDateModelsByTenantId(Long tenantId) {
        return calendarDateRepositroy.findCalendarDateModelsByTenantId(tenantId);
    }

    @Override
    public List<CalendarDateModel> findAll() {
        return calendarDateRepositroy.findAll();
    }

}
