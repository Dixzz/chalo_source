package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: ng2  reason: default package */
public class ng2 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f2550a = 0;

    static {
        ng2.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
