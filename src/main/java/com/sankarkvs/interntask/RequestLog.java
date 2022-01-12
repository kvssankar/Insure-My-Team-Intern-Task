package com.sankarkvs.interntask;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class RequestLog {
    @Id
    private String id;
    private String data;
    @CreatedDate
    private Date createdData;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
