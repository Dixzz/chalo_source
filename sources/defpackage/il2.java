package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: il2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class il2 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f1532a = 0;

    static {
        il2.class.getClassLoader();
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

    public static void c(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
