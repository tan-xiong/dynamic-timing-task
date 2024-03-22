package com.tx.task.repository;

import com.tx.task.entity.ScheduleSettingPO;
import com.tx.task.repository.dao.ScheduleSettingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tx
 */
@Component
public class ScheduleSettingRepository {

    @Autowired
    private ScheduleSettingDAO scheduleSettingDAO;

    public List<ScheduleSettingPO> findAll() {
        return scheduleSettingDAO.findAll();
    }
}
