package com.yy.provider1.controller;

import com.yy.provider1.model.CalendarDateModel;
import com.yy.provider1.service.CalendarDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CalendarDateController {
    @Autowired
    private  CalendarDateService calendarDateService;

    @RequestMapping("/queryCalendarDateModel/{id}")
    public CalendarDateModel queryCalendarDateModel(@PathVariable("id") Long id){
        System.out.println(id);
        CalendarDateModel calendarDateModelById = calendarDateService.findCalendarDateModelById(id);
        System.out.println(calendarDateModelById);
        return calendarDateModelById;
    }

    @RequestMapping("/countBetweenDate/{id}/{preDate}/{postDate}")
    public int queryCalendarDateModel(@PathVariable("id") Long id,@PathVariable("preDate") Date preDate,@PathVariable("postDate") Date postDate){
        System.out.println(id);
        System.out.println(preDate);
        System.out.println(postDate);
        return calendarDateService.countBetweenDate(id,preDate,postDate);
    }

    @RequestMapping("/findCalendarDateModelsByTenantId/{id}")
    public  List<CalendarDateModel> findCalendarDateModelsByTenantId(@PathVariable("id") Long id){
        System.out.println(id);
        List<CalendarDateModel> calendarDateModelsByTenantId = calendarDateService.findCalendarDateModelsByTenantId(id);
        System.out.println(calendarDateModelsByTenantId);
        return calendarDateModelsByTenantId;
    }

    @RequestMapping("/findAll")
    public  List<CalendarDateModel> findAll(){
        List<CalendarDateModel> findAll = calendarDateService.findAll();
        System.out.println(findAll);
        return findAll;
    }

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
