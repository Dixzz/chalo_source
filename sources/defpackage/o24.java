package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o24  reason: default package */
public class o24 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f2636a = 0;

    static {
        o24.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
