package com.epam.ogoltsov.model;

import java.io.Serializable;

public class BaseEntity implements Serializable{

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    BaseEntity() {
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
