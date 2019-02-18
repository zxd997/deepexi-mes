package com.deepexi.ai.mes.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

/**
 * @Author central
 * @Date 2018/11/26 12:22
 */
@Document
public class Test {

    @Id
    private String id;

    private String username;

    public Test() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
