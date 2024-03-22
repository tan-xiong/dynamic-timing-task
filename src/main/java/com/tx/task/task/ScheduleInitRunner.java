package com.tx.task.task;


import com.tx.task.entity.ScheduleSettingPO;
import com.tx.task.repository.ScheduleSettingRepository;
import com.tx.task.service.ScheduleExecService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tx
 *
 */
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScheduleInitRunner implements CommandLineRunner {

    ScheduleSettingRepository scheduleSettingRepository;

    ScheduleExecService scheduleExecService;

    CronTaskRegistrar scheduledTaskRegistrar;

    /**
     *
     * 在项目启动的时候，将需要执行的定时任务加载到缓存中
     *
     */

    @Override
    public void run(String... args) throws Exception {
        List<ScheduleSettingPO> riskScheduleSettingList = scheduleSettingRepository.findAll();
        for (ScheduleSettingPO riskScheduleSetting : riskScheduleSettingList) {
            scheduledTaskRegistrar.addCronTask(scheduleExecService::scheduleExec, riskScheduleSetting.getCronExpression(), riskScheduleSetting.getJobId());
        }
    }
}
