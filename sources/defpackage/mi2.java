package defpackage;

/* renamed from: mi2  reason: default package */
public final class mi2 implements xh2 {

    /* renamed from: a  reason: collision with root package name */
    public final zh2 f2382a;
    public final ni2 b;

    public mi2(zh2 zh2, String str, Object[] objArr) {
        this.f2382a = zh2;
        this.b = new ni2(zh2.getClass(), str, objArr);
    }

    @Override // defpackage.xh2
    public final int a() {
        return (this.b.d & 1) == 1 ? 1 : 2;
    }

    @Override // defpackage.xh2
    public final boolean b() {
        return (this.b.d & 2) == 2;
    }

    @Override // defpackage.xh2
    public final zh2 c() {
        return this.f2382a;
    }
}
