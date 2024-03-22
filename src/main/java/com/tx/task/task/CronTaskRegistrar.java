package com.tx.task.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定时任务注册类
 * <p>
 * 定时任务注册类, 主要用于增加、删除定时任务
 * </p>
 */
@Slf4j
@Component
@SuppressWarnings("all")
public class CronTaskRegistrar implements DisposableBean {

    @Resource
    private TaskScheduler taskScheduler;

    //用于缓存定时任务
    private final Map<String, ScheduledTask> scheduledTasks = new ConcurrentHashMap<>(64);

    //添加定时任务
    public void addCronTask(Runnable task, String cronExpression,String jobId) {
        addCronTask(new CronTask(task, cronExpression),jobId);
    }

    public void addCronTask(CronTask cronTask,String jobId) {
        if (Objects.nonNull(cronTask)) {
            Runnable task = cronTask.getRunnable();
            if (this.scheduledTasks.containsKey(task)) {
                removeCronTask(jobId);
            }
            //缓存任务
            this.scheduledTasks.put(jobId, scheduleCronTask(cronTask));
        }
    }

    public void removeCronTask(String jobId) {
        log.info("//// 取消定时任务,任务数量{}", this.scheduledTasks.size());
        ScheduledTask scheduledTask = this.scheduledTasks.remove(jobId);
        if (Objects.nonNull(scheduledTask)) {
            scheduledTask.cancel();
            log.info("//// 取消定时任务成功");
        }
        log.info("//// 剩余任务数量{}", this.scheduledTasks.size());
    }

    public ScheduledTask scheduleCronTask(CronTask cronTask) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.future = this.taskScheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
        return scheduledTask;
    }

    @Override
    public void destroy() {
        this.scheduledTasks.values().forEach(ScheduledTask::cancel);
        this.scheduledTasks.clear();
    }
}