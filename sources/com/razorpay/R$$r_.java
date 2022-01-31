package com.razorpay;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: AdvertisingIdUtil */
public final class R$$r_ implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f686a;

    public R$$r_(IBinder iBinder) {
        this.f686a = iBinder;
    }

    public final String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f686a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f686a;
    }
}
