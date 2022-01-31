package defpackage;

/* renamed from: y64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class y64 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;
    public final /* synthetic */ b64 h;

    public y64(b64 b64, String str, long j) {
        this.h = b64;
        this.f = str;
        this.g = j;
    }

    public final void run() {
        b64 b64 = this.h;
        String str = this.f;
        long j = this.g;
        b64.b();
        gj1.j(str);
        Integer num = b64.c.get(str);
        if (num != null) {
            je4 v = b64.o().v(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                b64.c.remove(str);
                Long l = b64.b.get(str);
                if (l == null) {
                    b64.g().f.a("First ad unit exposure time was never set");
                } else {
                    b64.b.remove(str);
                    b64.v(str, j - l.longValue(), v);
                }
                if (b64.c.isEmpty()) {
                    long j2 = b64.d;
                    if (j2 == 0) {
                        b64.g().f.a("First ad exposure time was never set");
                        return;
                    }
                    b64.t(j - j2, v);
                    b64.d = 0;
                    return;
                }
                return;
            }
            b64.c.put(str, Integer.valueOf(intValue));
            return;
        }
        b64.g().f.b("Call to endAdUnitExposure for unknown ad unit id", str);
    }
}
