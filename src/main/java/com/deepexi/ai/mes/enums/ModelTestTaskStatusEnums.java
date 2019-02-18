package com.deepexi.ai.mes.enums;

/**
 * @author lyon
 * @date   2018/12/5 15:32
 * @detail 模型测试任务组状态枚举类
 */
public interface ModelTestTaskStatusEnums {
    /**
     * 任务异常
     */
    Integer ABNORMAL = 0;
    /**
     * 任务进行中
     */
    Integer BEGIN = 1;
    /**
     * 任务全部暂停
     */
    Integer SUSPEND = 2;
    /**
     * 任务已结束
     */
    Integer COMPLETE = 5;
}
