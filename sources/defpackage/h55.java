package defpackage;

import com.google.firebase.perf.util.Constants;

/* renamed from: h55  reason: default package */
/* compiled from: EdifactEncoder */
public final class h55 implements i55 {
    public static String b(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            char c = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(i + 3);
            }
            int i2 = (charAt << 18) + (charAt2 << '\f') + (charAt3 << 6) + c;
            char c2 = (char) ((i2 >> 8) & Constants.MAX_HOST_LENGTH);
            char c3 = (char) (i2 & Constants.MAX_HOST_LENGTH);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i2 >> 16) & Constants.MAX_HOST_LENGTH));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        throw null;
     */
    @Override // defpackage.i55
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(defpackage.j55 r11) {
        /*
        // Method dump skipped, instructions count: 224
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h55.a(j55):void");
    }
}
