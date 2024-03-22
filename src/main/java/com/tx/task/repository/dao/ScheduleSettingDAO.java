package com.tx.task.repository.dao;

import com.tx.task.entity.ScheduleSettingPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tx
 */
@Repository
public interface ScheduleSettingDAO extends JpaRepository<ScheduleSettingPO, String> {
}
