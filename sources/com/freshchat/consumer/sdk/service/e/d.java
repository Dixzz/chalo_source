package com.freshchat.consumer.sdk.service.e;

public class d implements j {
    private a gi = a.NORMAL;
    private int src;

    public enum a {
        IMMEDIATE,
        NORMAL,
        LAID_BACK
    }

    public void b(a aVar) {
        this.gi = aVar;
    }

    public a dD() {
        return this.gi;
    }

    public int dE() {
        return this.src;
    }

    public void p(int i) {
        this.src = i;
    }
}
