package com.razorpay;

import android.view.View;

/* compiled from: AppSelectorFragment */
public final class Q_$2$ implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ AppSelectorFragment f684a;

    public Q_$2$(AppSelectorFragment appSelectorFragment) {
        this.f684a = appSelectorFragment;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        AppSelectorFragment appSelectorFragment = this.f684a;
        OnAppSelectedListener onAppSelectedListener = appSelectorFragment.onAppSelectedListener;
        if (onAppSelectedListener != null) {
            onAppSelectedListener.onUpiAppLaunched(str, appSelectorFragment.urlData);
        }
        AppSelectorFragment appSelectorFragment2 = this.f684a;
        appSelectorFragment2.onAppSelectedListener.openUpiApp(str, appSelectorFragment2.urlData);
    }
}
