package defpackage;

/* renamed from: qc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class qc4 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ long i;
    public final /* synthetic */ ac4 j;

    public qc4(ac4 ac4, String str, String str2, String str3, long j2) {
        this.j = ac4;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = j2;
    }

    public final void run() {
        if (this.f == null) {
            this.j.f.j.w().C(this.g, null);
            return;
        }
        ie4 w = this.j.f.j.w();
        String str = this.g;
        w.b();
        synchronized (w) {
            String str2 = w.m;
            if (str2 != null) {
                str2.equals(str);
            }
            w.m = str;
        }
    }
}
