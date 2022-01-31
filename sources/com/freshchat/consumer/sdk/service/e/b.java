package com.freshchat.consumer.sdk.service.e;

public class b implements j {
    private a gd = a.LAID_BACK;

    public enum a {
        IMMEDIATE,
        NORMAL,
        LAID_BACK
    }

    public void b(a aVar) {
        this.gd = aVar;
    }

    public a dC() {
        return this.gd;
    }
}
