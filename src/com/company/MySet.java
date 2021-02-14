package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MySet<E> extends TreeSet {
    @Override
    synchronized public int size() {
        return super.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    synchronized public Iterator iterator() {
        return super.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return super.toArray();
    }

    @Override
    synchronized public boolean add(Object o) {
        return super.add(o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    synchronized public boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    synchronized public boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override
    synchronized public boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override
    synchronized public boolean containsAll(Collection collection) {
        return super.containsAll(collection);
    }

    @Override
    synchronized public Object[] toArray(Object[] objects) {
        return super.toArray();
    }
}
