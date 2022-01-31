package defpackage;

import com.urbanairship.UAirship;
import com.urbanairship.push.PushProvider;

/* renamed from: wv5  reason: default package */
/* compiled from: PushProviderBridge */
public final class wv5 implements UAirship.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f3844a;
    public final /* synthetic */ String b;

    public wv5(Class cls, String str) {
        this.f3844a = cls;
        this.b = str;
    }

    @Override // com.urbanairship.UAirship.c
    public void a(UAirship uAirship) {
        PushProvider pushProvider;
        vv5 vv5 = uAirship.i;
        Class cls = this.f3844a;
        String str = this.b;
        if (vv5.o.d(4) && (pushProvider = vv5.w) != null) {
            if (cls != null && pushProvider.getClass().equals(cls)) {
                String g = vv5.k.g("com.urbanairship.push.REGISTRATION_TOKEN_KEY", null);
                if (str != null && !hd3.R0(str, g)) {
                    vv5.k.l("com.urbanairship.push.REGISTRATION_TOKEN_KEY");
                    vv5.k.l("com.urbanairship.push.PUSH_DELIVERY_TYPE");
                }
            }
            vv5.j();
        }
    }
}
