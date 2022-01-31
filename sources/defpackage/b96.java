package defpackage;

import com.razorpay.AnalyticsConstants;
import java.util.List;

/* renamed from: b96  reason: default package */
/* compiled from: TypeIntrinsics */
public class b96 {
    public static List a(Object obj) {
        if (!(obj instanceof c96)) {
            try {
                return (List) obj;
            } catch (ClassCastException e) {
                n86.i(e, b96.class.getName());
                throw e;
            }
        } else {
            c(obj, "kotlin.collections.MutableList");
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00b7, code lost:
        if (r0 == r4) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object b(java.lang.Object r3, int r4) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b96.b(java.lang.Object, int):java.lang.Object");
    }

    public static void c(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(hj1.T(obj == null ? AnalyticsConstants.NULL : obj.getClass().getName(), " cannot be cast to ", str));
        n86.i(classCastException, b96.class.getName());
        throw classCastException;
    }
}
