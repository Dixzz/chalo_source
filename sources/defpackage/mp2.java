package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: mp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class mp2 {
    static {
        mp2.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
