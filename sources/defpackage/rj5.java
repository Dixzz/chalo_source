package defpackage;

/* renamed from: rj5  reason: default package */
/* compiled from: ApplicationMetrics */
public class rj5 extends dm5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ik5 f3090a;
    public final /* synthetic */ sj5 b;

    public rj5(sj5 sj5, ik5 ik5) {
        this.b = sj5;
        this.f3090a = ik5;
    }

    @Override // defpackage.xl5
    public void a(long j) {
        if (this.f3090a.b(16, 1)) {
            this.b.f2698a.f("com.urbanairship.application.metrics.LAST_OPEN").b(String.valueOf(j));
        }
    }
}
