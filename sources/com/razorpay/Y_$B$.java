package com.razorpay;

/* compiled from: RazorpayExceptionHandler */
public final class Y_$B$ extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Throwable f691a;
    private /* synthetic */ r_$Z$ b;

    public Y_$B$(r_$Z$ r__z_, Throwable th) {
        this.b = r__z_;
        this.f691a = th;
    }

    public final void run() {
        AnalyticsUtil.reportUncaughtException(this.f691a);
        AnalyticsUtil.saveEventsToPreferences(this.b.f699a);
    }
}
