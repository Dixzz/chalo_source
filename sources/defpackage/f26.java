package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.razorpay.AnalyticsConstants;

/* renamed from: f26  reason: default package */
/* compiled from: InflateRequest.kt */
public final class f26 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1065a;
    public final Context b;
    public final AttributeSet c;
    public final View d;
    public final e26 e;

    public f26(String str, Context context, AttributeSet attributeSet, View view, e26 e26) {
        n86.f(str, "name");
        n86.f(context, AnalyticsConstants.CONTEXT);
        n86.f(e26, "fallbackViewCreator");
        this.f1065a = str;
        this.b = context;
        this.c = attributeSet;
        this.d = view;
        this.e = e26;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f26)) {
            return false;
        }
        f26 f26 = (f26) obj;
        return n86.a(this.f1065a, f26.f1065a) && n86.a(this.b, f26.b) && n86.a(this.c, f26.c) && n86.a(this.d, f26.d) && n86.a(this.e, f26.e);
    }

    public int hashCode() {
        String str = this.f1065a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Context context = this.b;
        int hashCode2 = (hashCode + (context != null ? context.hashCode() : 0)) * 31;
        AttributeSet attributeSet = this.c;
        int hashCode3 = (hashCode2 + (attributeSet != null ? attributeSet.hashCode() : 0)) * 31;
        View view = this.d;
        int hashCode4 = (hashCode3 + (view != null ? view.hashCode() : 0)) * 31;
        e26 e26 = this.e;
        if (e26 != null) {
            i = e26.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("InflateRequest(name=");
        i0.append(this.f1065a);
        i0.append(", context=");
        i0.append(this.b);
        i0.append(", attrs=");
        i0.append(this.c);
        i0.append(", parent=");
        i0.append(this.d);
        i0.append(", fallbackViewCreator=");
        i0.append(this.e);
        i0.append(")");
        return i0.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f26(java.lang.String r7, android.content.Context r8, android.util.AttributeSet r9, android.view.View r10, defpackage.e26 r11, int r12) {
        /*
            r6 = this;
            r10 = r12 & 4
            if (r10 == 0) goto L_0x0005
            r9 = 0
        L_0x0005:
            r3 = r9
            r9 = r12 & 8
            r4 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f26.<init>(java.lang.String, android.content.Context, android.util.AttributeSet, android.view.View, e26, int):void");
    }
}
