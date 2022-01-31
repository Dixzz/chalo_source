package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.j.bg;

public final class cu implements Runnable {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ bg.b qJ;

    public cu(Context context, bg.b bVar) {
        this.iI = context;
        this.qJ = bVar;
    }

    public void run() {
        if (this.iI == null) {
            ai.e("FRESHCHAT_WARNING", "context cannot be null while broadcasting event.");
            return;
        }
        try {
            a.a(this.iI, bg.a(this.qJ.gy()));
        } catch (Exception e) {
            q.a(e);
        }
    }
}
