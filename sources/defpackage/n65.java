package defpackage;

import java.util.Map;

/* renamed from: n65  reason: default package */
/* compiled from: UPCAWriter */
public final class n65 implements i35 {

    /* renamed from: a  reason: collision with root package name */
    public final c65 f2518a = new c65();

    @Override // defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        if (o25 == o25.UPC_A) {
            return this.f2518a.a("0".concat(String.valueOf(str)), o25.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(o25)));
    }
}
