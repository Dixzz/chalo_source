package com.freshchat.consumer.sdk.service.b;

import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.j;
import java.lang.ref.WeakReference;

public class c {
    private final j fI;
    private final WeakReference<a> fJ;

    public c(j jVar, a aVar) {
        this.fI = jVar;
        this.fJ = new WeakReference<>(aVar);
    }

    public a du() {
        WeakReference<a> weakReference = this.fJ;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public j dv() {
        return this.fI;
    }
}
