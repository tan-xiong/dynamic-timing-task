package com.tx.task.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author tx
 */
@Data
@Entity
@Table(name = "schedule_setting")
public class ScheduleSettingPO {

    @Id
    private String id;

    private String jobId;

    private String cronExpression;

    private String jobResult;

    private Date createDate;

    private String status;

    private String createBy;

    private String creator;

    private Long version;
}


