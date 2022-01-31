package com.freshchat.consumer.sdk.a;

import android.view.View;
import com.freshchat.consumer.sdk.a.d;
import com.freshchat.consumer.sdk.b.i;

public class h implements Runnable {
    public final /* synthetic */ d ot;
    public final /* synthetic */ View pW;
    public final /* synthetic */ d.e pX;

    public h(d dVar, View view, d.e eVar) {
        this.ot = dVar;
        this.pW = view;
        this.pX = eVar;
    }

    public void run() {
        d.a(this.ot, this.pW.getWidth());
        i.a(d.a(this.ot), this.pX.bc(), 0, d.b(this.ot) - d.c(this.ot));
    }
}
