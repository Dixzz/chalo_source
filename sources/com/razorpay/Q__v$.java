package com.razorpay;

/* compiled from: RzpAssist */
public final class Q__v$ implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ boolean f685a;
    private /* synthetic */ RzpAssist b;

    public Q__v$(RzpAssist rzpAssist, boolean z) {
        this.b = rzpAssist;
        this.f685a = z;
    }

    public final void run() {
        this.b.webview.getSettings().setUseWideViewPort(this.f685a);
    }
}
