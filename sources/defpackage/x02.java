package defpackage;

import android.content.Context;
import android.os.Binder;

/* renamed from: x02  reason: default package */
public final class x02 extends s02 {
    public final Context f;

    public x02(Context context) {
        this.f = context;
    }

    public final void F() {
        if (!u22.isGooglePlayServicesUid(this.f, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder sb = new StringBuilder(52);
            sb.append("Calling UID ");
            sb.append(callingUid);
            sb.append(" is not Google Play services.");
            throw new SecurityException(sb.toString());
        }
    }
}
