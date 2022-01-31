package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: x83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class x83 extends in2 {
    public x83(q93 q93, un2 un2, CharSequence charSequence) {
        super(un2, charSequence);
    }

    @Override // defpackage.in2
    public final int a(int i) {
        String str;
        CharSequence charSequence = this.h;
        int length = charSequence.length();
        if (i < 0 || i > length) {
            if (i < 0) {
                str = gj1.F1("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
            } else if (length < 0) {
                throw new IllegalArgumentException(hj1.v(26, "negative size: ", length));
            } else {
                str = gj1.F1("%s (%s) must not be greater than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(length));
            }
            throw new IndexOutOfBoundsException(str);
        }
        while (i < length) {
            if (charSequence.charAt(i) == '.') {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // defpackage.in2
    public final int b(int i) {
        return i + 1;
    }
}
