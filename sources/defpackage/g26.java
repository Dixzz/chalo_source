package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.razorpay.AnalyticsConstants;

/* renamed from: g26  reason: default package */
/* compiled from: InflateResult.kt */
public final class g26 {

    /* renamed from: a  reason: collision with root package name */
    public final View f1206a;
    public final String b;
    public final Context c;
    public final AttributeSet d;

    public g26(View view, String str, Context context, AttributeSet attributeSet) {
        n86.f(str, "name");
        n86.f(context, AnalyticsConstants.CONTEXT);
        this.f1206a = view;
        this.b = str;
        this.c = context;
        this.d = attributeSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g26)) {
            return false;
        }
        g26 g26 = (g26) obj;
        return n86.a(this.f1206a, g26.f1206a) && n86.a(this.b, g26.b) && n86.a(this.c, g26.c) && n86.a(this.d, g26.d);
    }

    public int hashCode() {
        View view = this.f1206a;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Context context = this.c;
        int hashCode3 = (hashCode2 + (context != null ? context.hashCode() : 0)) * 31;
        AttributeSet attributeSet = this.d;
        if (attributeSet != null) {
            i = attributeSet.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("InflateResult(view=");
        i0.append(this.f1206a);
        i0.append(", name=");
        i0.append(this.b);
        i0.append(", context=");
        i0.append(this.c);
        i0.append(", attrs=");
        i0.append(this.d);
        i0.append(")");
        return i0.toString();
    }
}
