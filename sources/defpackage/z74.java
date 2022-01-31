package defpackage;

/* renamed from: z74  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class z74 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;
    public final /* synthetic */ b64 h;

    public z74(b64 b64, String str, long j) {
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
        if (b64.c.isEmpty()) {
            b64.d = j;
        }
        Integer num = b64.c.get(str);
        if (num != null) {
            b64.c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (b64.c.size() >= 100) {
            b64.g().i.a("Too many ads visible");
        } else {
            b64.c.put(str, 1);
            b64.b.put(str, Long.valueOf(j));
        }
    }
}
