package com.deepexi.ai.mes.enums;

/**
 * @author lyon
 * @date   2018/12/5 11:32
 * @detail 测试任务状态枚举类
 */
public interface TestTaskStatusEnums {
    /**
     * 任务未开始
     */
    Integer NOTBEGIN = 0;
    /**
     * 任务进行中
     */
    Integer BEGIN = 1;
    /**
     * 任务已暂停
     */
    Integer SUSPEND = 2;
    /**
     * 任务异常
     */
    Integer ABNORMAL = 3;
    /**
     * 任务已完成
     */
    Integer COMPLETE = 5;
}
