package com.tx.task.controller;

import com.tx.task.dto.ScheduleSettingDTO;
import com.tx.task.service.ScheduleExecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tx
 */
@RestController
@RequestMapping("/timer")
public class ScheduleExecController {

    @Autowired
    private ScheduleExecService scheduleExecService;


    @RequestMapping("/add")
    public void add(@RequestBody ScheduleSettingDTO scheduleSettingDTO){
        scheduleExecService.add(scheduleSettingDTO);
    }

    @RequestMapping("/stop")
    public void stop(@RequestBody ScheduleSettingDTO scheduleSettingDTO){
        scheduleExecService.stop(scheduleSettingDTO);
    }

    @RequestMapping("/refresh")
    public void refresh(){
        scheduleExecService.refresh();
    }
}
