package com.company;

public class MyObject {
    Object key;
    Object value;

    public MyObject(Object key, Object value)
    {
        this.key = key;
        this.value = value;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}