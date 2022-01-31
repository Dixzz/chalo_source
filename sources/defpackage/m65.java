package defpackage;

import java.util.Map;

/* renamed from: m65  reason: default package */
/* compiled from: UPCAReader */
public final class m65 extends r65 {
    public final r65 i = new b65();

    public static e35 s(e35 e35) throws v25 {
        String str = e35.f921a;
        if (str.charAt(0) == '0') {
            e35 e352 = new e35(str.substring(1), null, e35.c, o25.UPC_A);
            Map<f35, Object> map = e35.e;
            if (map != null) {
                e352.a(map);
            }
            return e352;
        }
        throw v25.a();
    }

    @Override // defpackage.c35, defpackage.k65
    public e35 a(q25 q25, Map<s25, ?> map) throws a35, v25 {
        return s(this.i.a(q25, map));
    }

    @Override // defpackage.c35, defpackage.k65
    public e35 b(q25 q25) throws a35, v25 {
        return s(this.i.b(q25));
    }

    @Override // defpackage.r65, defpackage.k65
    public e35 d(int i2, e45 e45, Map<s25, ?> map) throws a35, v25, r25 {
        return s(this.i.d(i2, e45, map));
    }

    @Override // defpackage.r65
    public int m(e45 e45, int[] iArr, StringBuilder sb) throws a35 {
        return this.i.m(e45, iArr, sb);
    }

    @Override // defpackage.r65
    public e35 n(int i2, e45 e45, int[] iArr, Map<s25, ?> map) throws a35, v25, r25 {
        return s(this.i.n(i2, e45, iArr, map));
    }

    @Override // defpackage.r65
    public o25 q() {
        return o25.UPC_A;
    }
}
