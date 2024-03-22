package com.tx.task.service.impl;

import com.tx.task.dto.ScheduleSettingDTO;
import com.tx.task.service.ScheduleExecService;
import com.tx.task.task.CronTaskRegistrar;
import com.tx.task.task.ScheduledTaskInit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author tanxiong
 * @date 2024/3/22 14:14
 */
@Slf4j
@Service
public class ScheduleExecServiceImpl implements ScheduleExecService {

    @Resource
    ScheduledTaskInit scheduledTaskInit;

    @Autowired
    private CronTaskRegistrar scheduledTaskRegistrar;


    @Override
    public void scheduleExec() {
        log.info("//// 动态定时任务执行了");
    }

    @Override
    public void add(ScheduleSettingDTO scheduleSettingDTO) {

        // 生成ID
        scheduleSettingDTO.setId(UUID.randomUUID().toString());
        scheduleSettingDTO.setJobId(UUID.randomUUID().toString());

        scheduledTaskRegistrar.addCronTask(this::scheduleExec, scheduleSettingDTO.getCronExpression(), scheduleSettingDTO.getJobId());

        // 保存定时任务到数据库

        /**
         * 代码省略
         */

    }

    @Override
    public void stop(ScheduleSettingDTO scheduleSettingDTO) {

        //根据任务ID暂停
        scheduledTaskRegistrar.removeCronTask(scheduleSettingDTO.getJobId());

        //更新定时任务数据到数据库中

        /**
         * 代码省略
         */
    }

    @Override
    public void refresh() {
        scheduledTaskInit.refresh(this);
    }
}
