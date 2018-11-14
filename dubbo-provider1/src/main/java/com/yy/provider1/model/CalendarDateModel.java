package com.yy.provider1.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "calendar_date", schema = "pandora_dev", catalog = "")
public class CalendarDateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String createdBy;

    @Temporal(TemporalType.DATE)
    private Date createdTime;
    private String updatedBy;
    @Temporal(TemporalType.DATE)
    private Date updatedTime;
    private Long tenantId;
    private String areaCode;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private String type;


}
