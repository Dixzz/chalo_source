package defpackage;

import android.os.Bundle;

/* renamed from: k22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class k22 implements xi4 {

    /* renamed from: a  reason: collision with root package name */
    public static final xi4 f2013a = new k22();

    @Override // defpackage.xi4
    public final yi4 then(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i = o12.h;
        if (bundle != null && bundle.containsKey("google.messenger")) {
            return hd3.W0(null);
        }
        return hd3.W0(bundle);
    }
}
