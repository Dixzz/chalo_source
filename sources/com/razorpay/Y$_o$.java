package com.razorpay;

import android.content.Context;
import com.razorpay.AdvertisingIdUtil;

/* compiled from: BaseConfig */
public final class Y$_o$ implements AdvertisingIdUtil.AdvertisingIdCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f690a;

    public Y$_o$(Context context) {
        this.f690a = context;
    }

    @Override // com.razorpay.AdvertisingIdUtil.AdvertisingIdCallback
    public final void onResult(String str) {
        BaseConfig.setAdvertisingId(this.f690a, str);
    }
}
