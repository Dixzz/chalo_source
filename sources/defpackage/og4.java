package defpackage;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: og4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class og4 implements wg4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ lg4 f2690a;

    public og4(lg4 lg4) {
        this.f2690a = lg4;
    }

    @Override // defpackage.wg4
    public final void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f2690a.j.g().f.a("AppId not known when logging error event");
        } else {
            this.f2690a.f().u(new qg4(this, str, bundle));
        }
    }
}
