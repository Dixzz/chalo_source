package defpackage;

import defpackage.fi6;

/* renamed from: fk6  reason: default package */
/* compiled from: RealResponseBody.kt */
public final class fk6 extends oi6 {
    public final String f;
    public final long g;
    public final ym6 h;

    public fk6(String str, long j, ym6 ym6) {
        n86.f(ym6, "source");
        this.f = str;
        this.g = j;
        this.h = ym6;
    }

    @Override // defpackage.oi6
    public long contentLength() {
        return this.g;
    }

    @Override // defpackage.oi6
    public fi6 contentType() {
        String str = this.f;
        if (str == null) {
            return null;
        }
        fi6.a aVar = fi6.f;
        return fi6.a.b(str);
    }

    @Override // defpackage.oi6
    public ym6 source() {
        return this.h;
    }
}
