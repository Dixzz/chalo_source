package defpackage;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

/* renamed from: la2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class la2 implements Parcelable.Creator<GetServiceRequest> {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        int i2 = getServiceRequest.f;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = getServiceRequest.g;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = getServiceRequest.h;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        gj1.B0(parcel, 4, getServiceRequest.i, false);
        gj1.x0(parcel, 5, getServiceRequest.j, false);
        gj1.E0(parcel, 6, getServiceRequest.k, i, false);
        gj1.t0(parcel, 7, getServiceRequest.l, false);
        gj1.A0(parcel, 8, getServiceRequest.m, i, false);
        gj1.E0(parcel, 10, getServiceRequest.n, i, false);
        gj1.E0(parcel, 11, getServiceRequest.o, i, false);
        boolean z = getServiceRequest.p;
        parcel.writeInt(262156);
        parcel.writeInt(z ? 1 : 0);
        int i5 = getServiceRequest.q;
        parcel.writeInt(262157);
        parcel.writeInt(i5);
        boolean z2 = getServiceRequest.r;
        parcel.writeInt(262158);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.B0(parcel, 15, getServiceRequest.s, false);
        gj1.H1(parcel, o1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GetServiceRequest createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    i2 = gj1.g0(parcel, readInt);
                    break;
                case 3:
                    i3 = gj1.g0(parcel, readInt);
                    break;
                case 4:
                    str = gj1.x(parcel, readInt);
                    break;
                case 5:
                    iBinder = gj1.f0(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) gj1.A(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = gj1.s(parcel, readInt);
                    break;
                case '\b':
                    account = (Account) gj1.w(parcel, readInt, Account.CREATOR);
                    break;
                case '\t':
                default:
                    gj1.p0(parcel, readInt);
                    break;
                case '\n':
                    featureArr = (Feature[]) gj1.A(parcel, readInt, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) gj1.A(parcel, readInt, Feature.CREATOR);
                    break;
                case '\f':
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\r':
                    i4 = gj1.g0(parcel, readInt);
                    break;
                case 14:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case 15:
                    str2 = gj1.x(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i4, z2, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
