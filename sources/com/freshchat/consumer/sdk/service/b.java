package com.freshchat.consumer.sdk.service;

public class b<T> {
    private final T data;
    private final Status status;

    public b(Status status2, T t) {
        this.status = status2;
        this.data = t;
    }

    public T getData() {
        return this.data;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Response{Status=");
        i0.append(this.status);
        i0.append(", data=");
        i0.append((Object) this.data);
        i0.append('}');
        return i0.toString();
    }
}
