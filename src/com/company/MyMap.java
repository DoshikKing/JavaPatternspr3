package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Semaphore;

public class MyMap implements Map {

    int size;
    int permits;
    MyObject[] obj;
    private final Semaphore semaphore = new Semaphore(permits);

    public MyMap(int s)
    {
        this.size = s;
        MyObject[] obj = new MyObject[s];
        this.obj = obj;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        this.permits =+ 1;
        System.out.println(this.permits);
        //System.out.println(semaphore.availablePermits());
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != null)
                {
                    return false;
                }
                else{
                    return true;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.permits = this.permits + 1;
        System.out.println(this.permits);
        return false;
    }

    @Override
    public boolean containsKey(Object o) {
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i].getKey() != o)
                {
                    return false;
                }
                else{
                    return true;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.permits++;
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i].getValue() != o)
                {
                    return false;
                }
                else{
                    return true;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.permits++;
        return false;
    }

    @Override
    public Object get(Object o) {
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != o)
                {
                    return null;
                }
                else{
                    return obj[i];
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.permits++;
        return null;
    }

    @Override
    public Object put(Object o, Object o2) {
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
//                if(obj[i].getValue() != o && obj[i].getKey() != o2 && obj[i] == null)
//                {
                    obj[i] = new MyObject(o, o2);
                    return obj[i];
//                }
//                else{
//                    return null;
//                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object remove(Object o) {
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != o)
                {
                    return null;
                }
                else{
                    obj[i] = null;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.permits++;
        return null;
    }

    @Override
    public void putAll(Map map) {
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != map)
                {
                     //= map;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.permits++;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
