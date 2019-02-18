package com.deepexi.ai.mes.dto;

/**
 * 导入模型
 */
public class ImportModelDto {
    /**
     * 保留 code
     */
    private String code;
    /**
     * 模型名
     */
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
