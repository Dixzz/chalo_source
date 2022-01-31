package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* renamed from: j22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class j22 implements qi4 {

    /* renamed from: a  reason: collision with root package name */
    public final o12 f1864a;
    public final Bundle b;

    public j22(o12 o12, Bundle bundle) {
        this.f1864a = o12;
        this.b = bundle;
    }

    @Override // defpackage.qi4
    public final Object then(yi4 yi4) {
        o12 o12 = this.f1864a;
        Bundle bundle = this.b;
        Objects.requireNonNull(o12);
        if (!yi4.q()) {
            return yi4;
        }
        Bundle bundle2 = (Bundle) yi4.m();
        return !(bundle2 != null && bundle2.containsKey("google.messenger")) ? yi4 : o12.c(bundle).s(n22.f, k22.f2013a);
    }
}
