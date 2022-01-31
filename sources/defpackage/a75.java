package defpackage;

import com.razorpay.AnalyticsConstants;

/* renamed from: a75  reason: default package */
/* compiled from: ExpandedPair */
public final class a75 {

    /* renamed from: a  reason: collision with root package name */
    public final w65 f131a;
    public final w65 b;
    public final x65 c;

    public a75(w65 w65, w65 w652, x65 x65, boolean z) {
        this.f131a = w65;
        this.b = w652;
        this.c = x65;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a75)) {
            return false;
        }
        a75 a75 = (a75) obj;
        if (!a(this.f131a, a75.f131a) || !a(this.b, a75.b) || !a(this.c, a75.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (b(this.f131a) ^ b(this.b)) ^ b(this.c);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f131a);
        sb.append(" , ");
        sb.append(this.b);
        sb.append(" : ");
        x65 x65 = this.c;
        if (x65 == null) {
            obj = AnalyticsConstants.NULL;
        } else {
            obj = Integer.valueOf(x65.f3893a);
        }
        sb.append(obj);
        sb.append(" ]");
        return sb.toString();
    }
}
