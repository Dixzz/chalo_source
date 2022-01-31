package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* renamed from: s5  reason: default package */
/* compiled from: ComplexColorCompat */
public final class s5 {

    /* renamed from: a  reason: collision with root package name */
    public final Shader f3186a;
    public final ColorStateList b;
    public int c;

    public s5(Shader shader, ColorStateList colorStateList, int i) {
        this.f3186a = shader;
        this.b = colorStateList;
        this.c = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0209, code lost:
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x020c, code lost:
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x020e, code lost:
        r3 = new android.graphics.LinearGradient(r12, r26, r14, r15, r4, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x021f, code lost:
        r3 = new android.graphics.SweepGradient(r7, r8, r0.f3885a, r0.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0234, code lost:
        if (r0 <= 0.0f) goto L_0x0263;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0236, code lost:
        r1 = r0.f3885a;
        r0 = r0.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x023d, code lost:
        if (r6 == 1) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0240, code lost:
        if (r6 == 2) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0242, code lost:
        r2 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0245, code lost:
        r2 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0248, code lost:
        r2 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x024a, code lost:
        r3 = new android.graphics.RadialGradient(r7, r8, r0, r1, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0262, code lost:
        return new defpackage.s5(r3, null, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x026a, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01dc, code lost:
        if (r8.size() <= 0) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01de, code lost:
        r0 = new defpackage.x5(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01e4, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e5, code lost:
        if (r0 == null) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01e9, code lost:
        if (r18 == false) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01eb, code lost:
        r0 = new defpackage.x5(r5, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01f1, code lost:
        r0 = new defpackage.x5(r5, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f7, code lost:
        if (r9 == 1) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01fa, code lost:
        if (r9 == 2) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01fc, code lost:
        r4 = r0.f3885a;
        r0 = r0.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0202, code lost:
        if (r6 == 1) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0204, code lost:
        if (r6 == 2) goto L_0x0209;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0206, code lost:
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.s5 a(android.content.res.Resources r28, int r29, android.content.res.Resources.Theme r30) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
        // Method dump skipped, instructions count: 657
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s5.a(android.content.res.Resources, int, android.content.res.Resources$Theme):s5");
    }

    public boolean b() {
        return this.f3186a != null;
    }

    public boolean c() {
        ColorStateList colorStateList;
        return this.f3186a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean d(int[] iArr) {
        if (c()) {
            ColorStateList colorStateList = this.b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.c) {
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }
}
