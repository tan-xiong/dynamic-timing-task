create table schedule_setting
(
    id              varchar(32)  not null comment '唯一id'
        primary key,
    job_id          varchar(64)  null comment '任务ID',
    cron_expression varchar(255) null comment 'cron表达式',
    job_result      varchar(32)  null comment '任务结果（通过 复议 拒绝）',
    create_date     datetime     null comment '创建时间',
    status          varchar(4)   null,
    create_by       varchar(64)  null comment '创建人账号',
    creator         varchar(64)  null comment '创建人',
    version         bigint(19)   null comment '版本号'
)
    comment '定时任务表';

INSERT INTO schedule_setting (id, job_id, cron_expression, job_result, create_date, status, create_by, creator, version) VALUES ('1', '1', '0/2 * * * * ?', null, '2024-03-22 15:15:33', '1', null, null, 0);