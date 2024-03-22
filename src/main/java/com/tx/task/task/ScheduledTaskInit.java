package com.tx.task.task;

import com.tx.task.entity.ScheduleSettingPO;
import com.tx.task.repository.dao.ScheduleSettingDAO;
import com.tx.task.service.ScheduleExecService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author tx
 */
@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Lazy
public class ScheduledTaskInit {

    ScheduleSettingDAO scheduleSettingDAO;

    CronTaskRegistrar scheduledTaskRegistrar;

    @SneakyThrows
    public void refresh(ScheduleExecService scheduleExecService) {
        synchronized (ScheduledTaskInit.class) {
            List<ScheduleSettingPO> list = scheduleSettingDAO.findAll();
            //销毁任务
            scheduledTaskRegistrar.destroy();
            if (CollectionUtils.isEmpty(list)) return;

            for (ScheduleSettingPO scheduleSetting : list) {
                scheduledTaskRegistrar.addCronTask(() -> {
                    scheduleExecService.scheduleExec();
                }, scheduleSetting.getCronExpression(), scheduleSetting.getJobId());
            }
            log.info("//// 定时任务初始化，加载数量：{}", list.size());
        }
    }

}
