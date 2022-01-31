package com.razorpay;

import android.content.Context;
import java.lang.Thread;

/* compiled from: RazorpayExceptionHandler */
public final class r_$Z$ implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public Context f699a;
    private Thread.UncaughtExceptionHandler b;

    private r_$Z$(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = uncaughtExceptionHandler;
        this.f699a = context;
    }

    public static void a(Context context) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!(defaultUncaughtExceptionHandler instanceof r_$Z$)) {
            Thread.setDefaultUncaughtExceptionHandler(new r_$Z$(context, defaultUncaughtExceptionHandler));
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        new Y_$B$(this, th).start();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public static void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof r_$Z$) {
            Thread.setDefaultUncaughtExceptionHandler(((r_$Z$) defaultUncaughtExceptionHandler).b);
        }
    }
}
