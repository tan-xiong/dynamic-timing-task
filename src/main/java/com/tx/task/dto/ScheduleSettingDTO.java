package com.tx.task.dto;

import lombok.Data;

/**
 * @author tx
 */
@Data

public class ScheduleSettingDTO {

    private String id;

    private String jobId;

    private String cronExpression;

    private String status;

}
