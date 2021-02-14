package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Semaphore;

public class MyMap<E> implements Map {

    int size;
    int permits = 1;
    MyObject[] obj;
    //private final Semaphore semaphore = new Semaphore(permits);

    public MyMap(int s)
    {
        this.size = s;
        MyObject[] obj = new MyObject[s];
        this.obj = obj;
    }
    @Override
    public int size() {
        int count = 0;
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != null)
                {
                    count = count + 1;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            count = 0;
            e.printStackTrace();
        }finally {
            permits++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        boolean b = true;
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != null)
                {
                    b = false;
                    break;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            b = true;
            e.printStackTrace();
        }finally {
            permits++;
        }
        return b;
    }

    @Override
    public boolean containsKey(Object k) {
        boolean b = false;
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i].getKey() == k)
                {
                    b = true;
                    break;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            b = false;
            e.printStackTrace();
        }finally {
            permits++;
        }
        return b;
    }

    @Override
    public boolean containsValue(Object v) {
        boolean b = false;
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i].getValue() == v)
                {
                    b = true;
                    break;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            b = false;
            e.printStackTrace();
        }
        finally {
            permits++;
        }
        return b;
    }

    @Override
    public Object get(Object k) {
        Object temp = null;
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != null && obj[i].getKey() == k)
                {
                    temp = obj[i].getValue();
                    break;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            temp = null;
            e.printStackTrace();
        }
        finally {
            permits++;
        }
        return temp;
    }

    @Override
    public Object put(Object k, Object o) {
        int permits = 1;
        MyObject temp = new MyObject(k, o);
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] == null)
                {
                    obj[i] = temp;
                    break;
                }
                if(obj[i].getKey() == k)
                {
                    obj[i] = temp;
                    break;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            temp = null;
            e.printStackTrace();
        } finally {
            permits++;
        }
        return temp;
    }

    @Override
    public Object remove(Object k) {
        MyObject o = null;
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if(obj[i] != null && obj[i].getKey() == k)
                {
                    o = obj[i];
                    obj[i] = null;
                    break;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            o = null;
            e.printStackTrace();
        }finally {
            permits++;
        }
        return o;
    }

    @Override
    public void putAll(Map map) {
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            Set<Object> key = map.keySet();

            for (Object k : key) {
                Object o = map.get(k);
                this.put(k,o);
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            permits++;
        }
    }

    @Override
    public void clear() {
        this.obj = null;
    }

    @Override
    public Set keySet() {

        Set<Object> set = new HashSet<Object>();
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                set.add(obj[i].getKey());
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            permits++;
        }
        return set;
    }

    @Override
    public Collection values() {
        List <Object> list1= new ArrayList();
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                list1.add(obj[i].getValue());
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            permits++;
        }
        return list1;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> set = new HashSet<Entry>();
        try {
            Semaphore semaphore = new Semaphore(permits);
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                set.add(obj[i]);
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            permits++;
        }
        return set;
    }
}
