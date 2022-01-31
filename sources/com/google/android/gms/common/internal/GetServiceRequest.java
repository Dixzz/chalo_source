package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.c82;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class GetServiceRequest extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new la2();
    public final int f;
    public final int g;
    public int h;
    public String i;
    public IBinder j;
    public Scope[] k;
    public Bundle l;
    public Account m;
    public Feature[] n;
    public Feature[] o;
    public boolean p;
    public int q;
    public boolean r;
    public final String s;

    public GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i5, boolean z2, String str2) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
        if ("com.google.android.gms".equals(str)) {
            this.i = "com.google.android.gms";
        } else {
            this.i = str;
        }
        if (i2 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                c82 F = c82.a.F(iBinder);
                int i6 = v72.f;
                if (F != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        account2 = F.zzb();
                    } catch (RemoteException unused) {
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        throw th;
                    }
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
            this.m = account2;
        } else {
            this.j = iBinder;
            this.m = account;
        }
        this.k = scopeArr;
        this.l = bundle;
        this.n = featureArr;
        this.o = featureArr2;
        this.p = z;
        this.q = i5;
        this.r = z2;
        this.s = str2;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        la2.a(this, parcel, i2);
    }

    public GetServiceRequest(int i2, String str) {
        this.f = 6;
        this.h = r22.f3028a;
        this.g = i2;
        this.p = true;
        this.s = str;
    }
}
