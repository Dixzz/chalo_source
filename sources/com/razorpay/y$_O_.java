package com.razorpay;

import android.widget.Toast;

/* compiled from: RzpAssist */
public final class y$_O_ implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f701a;
    private /* synthetic */ RzpAssist b;

    public y$_O_(RzpAssist rzpAssist, String str) {
        this.b = rzpAssist;
        this.f701a = str;
    }

    public final void run() {
        Toast.makeText(this.b.activity, this.f701a, 1).show();
    }
}
