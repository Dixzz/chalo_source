package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: ae2  reason: default package */
public class ae2 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f155a = 0;

    static {
        ae2.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
