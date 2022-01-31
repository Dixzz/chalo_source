package defpackage;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: rd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class rd4 implements wg4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dd4 f3069a;

    public rd4(dd4 dd4) {
        this.f3069a = dd4;
    }

    @Override // defpackage.wg4
    public final void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f3069a.G("auto", "_err", bundle);
        } else {
            this.f3069a.f3331a.j();
            throw null;
        }
    }
}
