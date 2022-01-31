package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.review.a;

/* renamed from: lv4  reason: default package */
public abstract class lv4 extends pw4 implements mv4 {
    public lv4() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override // defpackage.pw4
    public final boolean C(int i, Parcel parcel) throws RemoteException {
        if (i != 2) {
            return false;
        }
        kx4 kx4 = (kx4) this;
        kx4.h.f2291a.b();
        kx4.f.b(4, "onGetLaunchReviewFlowInfo", new Object[0]);
        kx4.g.b((T) new a((PendingIntent) ((Bundle) qw4.a(parcel, Bundle.CREATOR)).get("confirmation_intent")));
        return true;
    }
}
