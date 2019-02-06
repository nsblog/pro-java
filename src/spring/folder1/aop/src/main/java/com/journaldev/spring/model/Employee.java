package com.journaldev.spring.model;

import com.journaldev.spring.aspect.Loggable;

public class Employee {

    private String name;

    @Loggable
    public String getName() {
        return getName1();
    }

    @Loggable
    public String getName1() {
        return getName2();
    }

    @Loggable
    private String getName2() {
        return name;
    }

    public void setName(String nm) {
        this.name = nm;
    }

    public void throwException() {
        throw new RuntimeException("Dummy Exception");
    }

}
