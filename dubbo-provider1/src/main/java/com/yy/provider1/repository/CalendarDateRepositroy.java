package com.yy.provider1.repository;

import com.yy.provider1.model.CalendarDateModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface CalendarDateRepositroy extends JpaRepository<CalendarDateModel,Long> {
    CalendarDateModel findCalendarDateModelById(Long id);

    int countByIdAndDateBetween(Long id, Date preDate, Date postDate);

    List<CalendarDateModel> findCalendarDateModelsByTenantId(Long tenantId);



}
