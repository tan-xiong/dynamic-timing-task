package com.tx.task.task;

import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

@SuppressWarnings("all")
public final class ScheduledTask {

    public volatile ScheduledFuture<?> future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture<?> scheduledFuture = this.future;
        if (Objects.nonNull(scheduledFuture)) {
            scheduledFuture.cancel(true);
        }
    }
}