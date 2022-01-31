package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: ix4  reason: default package */
public final /* synthetic */ class ix4 implements tv4 {

    /* renamed from: a  reason: collision with root package name */
    public static final tv4 f1582a = new ix4();

    @Override // defpackage.tv4
    public final Object a(IBinder iBinder) {
        int i = jv4.f;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof kv4 ? (kv4) queryLocalInterface : new iv4(iBinder);
    }
}
