package com.tx.task.service;

import com.tx.task.dto.ScheduleSettingDTO;

/**
 * @author tanxiong
 * @date 2024/3/22 14:14
 */
public interface ScheduleExecService {

    /**
     * 定时执行的方法
     */
    void scheduleExec();

    /**
     * 添加定时任务
     * @param scheduleSettingDTO
     */
    void add(ScheduleSettingDTO scheduleSettingDTO);

    /**
     * 暂停定时任务
     * @param scheduleSettingDTO
     */
    void stop(ScheduleSettingDTO scheduleSettingDTO);

    /**
     * 刷新定时任务
     */
    void refresh();
}
