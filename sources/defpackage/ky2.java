package defpackage;

/* renamed from: ky2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ky2 extends vx2 {
    public final String toString() {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        int i = 46;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return hj1.b0(new StringBuilder(String.valueOf(copyValueOf).length() + 18), "CharMatcher.is('", copyValueOf, "')");
    }
}
