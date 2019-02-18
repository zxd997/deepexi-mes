package com.deepexi.ai.mes.enums;

/**
 * @description: 标记状态 枚举类
 * @author: Daniel Li
 * @create: 2018-08-16
 */
public interface MarkStatusEnums {
    /**
     * 未标记
     */
    Integer UNMARKED = 0;

    /**
     * 初始标记
     */
    Integer PRELIMINARY_MARK = 1;

    /**
     * 初始标记完成
     */
    Integer PRELIMINARY_MARK_FINISH = 11;

    /**
     * 疑难标记
     */

    Integer DIFFICULT_MARK = 2;
    /**
     * 疑难标记完成
     */
    Integer DIFFICULT_MARK_FINISH = 21;

    /**
     * 最终标记
     */

    Integer ULTIMATE_MARK = 3;
    /**
     * 最终标记完成
     */
    Integer ULTIMATE_MARK_FINISH =31;
    /**
     * 在最后阶段点击疑难按钮后的状态
     */
    Integer UNKNOWN_RESULT = -1;
}
