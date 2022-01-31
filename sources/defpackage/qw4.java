package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: qw4  reason: default package */
public final class qw4 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f2999a = 0;

    static {
        qw4.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
