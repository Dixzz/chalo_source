package com.razorpay;

import android.view.View;

/* compiled from: AppSelectorFragment */
public final class E$_j$ implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ AppSelectorFragment f672a;

    public E$_j$(AppSelectorFragment appSelectorFragment) {
        this.f672a = appSelectorFragment;
    }

    public final void onClick(View view) {
        this.f672a.getActivity().onBackPressed();
    }
}
