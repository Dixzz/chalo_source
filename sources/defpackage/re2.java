package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: re2  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class re2 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f3072a = 0;

    static {
        re2.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
