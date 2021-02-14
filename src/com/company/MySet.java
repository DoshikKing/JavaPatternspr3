package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set {
    @Override
    public int size() {
        return 0;
    }

    @Override
    synchronized public boolean isEmpty() {
        return false;
    }

    @Override
    synchronized public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    synchronized public Object[] toArray() {
        return new Object[0];
    }

    @Override
    synchronized public boolean add(Object o) {
        return false;
    }

    @Override
    synchronized public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    synchronized public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    synchronized public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    synchronized public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
