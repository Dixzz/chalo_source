package defpackage;

import android.view.View;
import defpackage.h26;

/* renamed from: l26  reason: default package */
/* compiled from: -FallbackViewCreationInterceptor.kt */
public final class l26 implements h26 {
    @Override // defpackage.h26
    public g26 intercept(h26.a aVar) {
        String str;
        Class<?> cls;
        n86.f(aVar, "chain");
        f26 f26 = ((m26) aVar).c;
        View onCreateView = f26.e.onCreateView(f26.d, f26.f1065a, f26.b, f26.c);
        if (onCreateView == null || (cls = onCreateView.getClass()) == null) {
            str = f26.f1065a;
        } else {
            str = cls.getName();
        }
        return new g26(onCreateView, str, f26.b, f26.c);
    }
}
