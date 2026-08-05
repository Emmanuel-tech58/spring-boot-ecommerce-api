package com.codewithemncore.com.sb_ecom.model;

public class Category {

    private Long Id;
    private String name;

    public Category(Long Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public void setId(Long Id) {
        this.Id = Id;
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
