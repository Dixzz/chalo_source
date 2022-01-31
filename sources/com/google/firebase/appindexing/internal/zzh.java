package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.Looper;
import com.google.firebase.FirebaseExceptionMapper;
import defpackage.x22;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzh extends z22<x22.d.c> {
    public zzh(Context context) {
        super(context, zze.API, null, Looper.getMainLooper(), new FirebaseExceptionMapper());
        Context context2;
        synchronized (yf3.f) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (yf3.g != context) {
                mf3.b();
                bg3.c();
                synchronized (qf3.class) {
                    qf3 qf3 = qf3.c;
                    if (!(qf3 == null || (context2 = qf3.f2939a) == null || qf3.b == null)) {
                        context2.getContentResolver().unregisterContentObserver(qf3.c.b);
                    }
                    qf3.c = null;
                }
                yf3.i.incrementAndGet();
                yf3.g = context;
                yf3.h = hd3.v3(xf3.f);
            }
        }
    }
}
