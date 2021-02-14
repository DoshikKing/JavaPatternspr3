package com.company;

import java.util.Map;

public class MyObject implements Map.Entry {
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

    public Object setValue(Object value) {
        this.value = value;
        return value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
