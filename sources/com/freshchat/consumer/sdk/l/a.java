package com.freshchat.consumer.sdk.l;

import android.app.Application;
import android.content.Context;
import com.freshchat.consumer.sdk.f.c;

public class a extends b {
    private static volatile a mV;

    private a() {
    }

    public static synchronized a gR() {
        a aVar;
        synchronized (a.class) {
            if (mV == null) {
                synchronized (a.class) {
                    if (mV == null) {
                        mV = new a();
                    }
                }
            }
            aVar = mV;
        }
        return aVar;
    }

    public boolean bW(Context context) {
        return c.a((Application) context.getApplicationContext()).cE();
    }

    public void bX(Context context) {
        c.a((Application) context.getApplicationContext()).m(true);
    }
}
