package com.razorpay;

import android.view.inputmethod.InputMethodManager;

/* compiled from: RzpAssist */
public final class t_$J_ implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ RzpAssist f700a;

    public t_$J_(RzpAssist rzpAssist) {
        this.f700a = rzpAssist;
    }

    public final void run() {
        ((InputMethodManager) this.f700a.activity.getSystemService("input_method")).showSoftInput(this.f700a.webview, 0);
    }
}
