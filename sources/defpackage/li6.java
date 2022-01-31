package defpackage;

/* renamed from: li6  reason: default package */
/* compiled from: RequestBody.kt */
public final class li6 extends mi6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zm6 f2224a;
    public final /* synthetic */ fi6 b;

    public li6(zm6 zm6, fi6 fi6) {
        this.f2224a = zm6;
        this.b = fi6;
    }

    @Override // defpackage.mi6
    public long contentLength() {
        return (long) this.f2224a.g();
    }

    @Override // defpackage.mi6
    public fi6 contentType() {
        return this.b;
    }

    @Override // defpackage.mi6
    public void writeTo(xm6 xm6) {
        n86.f(xm6, "sink");
        xm6.P0(this.f2224a);
    }
}
