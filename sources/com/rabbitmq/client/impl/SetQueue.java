package com.rabbitmq.client.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SetQueue<T> {
    private final Set<T> members = new HashSet();
    private final Queue<T> queue = new LinkedList();

    public boolean addIfNotPresent(T t) {
        if (this.members.contains(t)) {
            return false;
        }
        this.members.add(t);
        this.queue.offer(t);
        return true;
    }

    public void clear() {
        this.queue.clear();
        this.members.clear();
    }

    public boolean contains(T t) {
        return this.members.contains(t);
    }

    public boolean isEmpty() {
        return this.members.isEmpty();
    }

    public T poll() {
        T poll = this.queue.poll();
        if (poll != null) {
            this.members.remove(poll);
        }
        return poll;
    }

    public boolean remove(T t) {
        this.queue.remove(t);
        return this.members.remove(t);
    }
}
