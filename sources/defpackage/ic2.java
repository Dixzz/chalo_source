package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;

/* renamed from: ic2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public interface ic2 extends IInterface {

    /* renamed from: ic2$a */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static abstract class a extends hl2 implements ic2 {
        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        public static ic2 F(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof ic2) {
                return (ic2) queryLocalInterface;
            }
            return new tc2(iBinder);
        }
    }
}
