package com.company;

import java.util.*;

public class MySet<E> implements Set {

    List<Object> col = new ArrayList();

    @Override
    synchronized public int size()
    {
        return col.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return col.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return col.contains(o);
    }

    @Override
    synchronized public Iterator iterator() {
        return col.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return col.toArray();
    }

    @Override
    synchronized public boolean add(Object o) {
        return col.add(o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return col.remove(o);
    }

    @Override
    synchronized public boolean addAll(Collection collection) {
        return col.addAll(collection);
    }

    @Override
    public void clear() {
        col.clear();
    }

    @Override
    synchronized public boolean removeAll(Collection collection) {
        return col.removeAll(collection);
    }

    @Override
    synchronized public boolean retainAll(Collection collection) {
        return col.retainAll(collection);
    }

    @Override
    synchronized public boolean containsAll(Collection collection) {
        return col.containsAll(collection);
    }

    @Override
    synchronized public Object[] toArray(Object[] objects) {
        return col.toArray();
    }
}
