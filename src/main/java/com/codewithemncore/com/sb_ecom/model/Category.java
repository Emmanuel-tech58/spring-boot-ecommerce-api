package com.codewithemncore.com.sb_ecom.model;

public class Category {

    private Long Id;
    private String name;

    public Category(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
