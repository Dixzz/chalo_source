package com.razorpay;

import java.util.TimerTask;

/* compiled from: RazorpayUtils */
public final class H$_a_ extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ B$$J$ f674a;

    public H$_a_(B$$J$ b$$j$) {
        this.f674a = b$$j$;
    }

    public final void run() {
        B$$J$ b$$j$ = this.f674a;
        b_$A$.a(b$$j$.c, b$$j$.d, b$$j$.b + 1, b$$j$.f667a);
    }
}
