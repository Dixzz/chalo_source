package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import defpackage.h26;

public class CalligraphyInterceptor implements h26 {
    private final Calligraphy calligraphy;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphy = new Calligraphy(calligraphyConfig);
    }

    @Override // defpackage.h26
    public g26 intercept(h26.a aVar) {
        g26 a2 = aVar.a(aVar.request());
        View onViewCreated = this.calligraphy.onViewCreated(a2.f1206a, a2.c, a2.d);
        n86.f(a2, "result");
        String str = a2.b;
        Context context = a2.c;
        AttributeSet attributeSet = a2.d;
        if (str != null) {
            if (onViewCreated == null) {
                onViewCreated = null;
            } else if (!n86.a(str, onViewCreated.getClass().getName())) {
                StringBuilder l0 = hj1.l0("name (", str, ") must be the view's fully qualified name (");
                l0.append(onViewCreated.getClass().getName());
                l0.append(')');
                throw new IllegalStateException(l0.toString().toString());
            }
            if (context != null) {
                return new g26(onViewCreated, str, context, attributeSet);
            }
            throw new IllegalStateException("context == null");
        }
        throw new IllegalStateException("name == null".toString());
    }
}
