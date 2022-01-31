package defpackage;

/* renamed from: kd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class kd4 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ long i;
    public final /* synthetic */ dd4 j;

    public kd4(dd4 dd4, String str, String str2, Object obj, long j2) {
        this.j = dd4;
        this.f = str;
        this.g = str2;
        this.h = obj;
        this.i = j2;
    }

    public final void run() {
        this.j.J(this.f, this.g, this.h, this.i);
    }
}
