package defpackage;

import java.util.concurrent.Executor;

/* renamed from: et4  reason: default package */
public final class et4 implements nw4<dt4> {

    /* renamed from: a  reason: collision with root package name */
    public final nw4 f1029a;
    public final nw4 b;
    public final nw4 c;
    public final nw4 d;
    public final /* synthetic */ int e = 0;

    public et4(nw4<bs4> nw4, nw4<vu4> nw42, nw4<ss4> nw43, nw4<Executor> nw44) {
        this.f1029a = nw4;
        this.b = nw42;
        this.c = nw43;
        this.d = nw44;
    }

    public et4(nw4<bs4> nw4, nw4<vu4> nw42, nw4<yr4> nw43, nw4<ss4> nw44, byte[] bArr) {
        this.f1029a = nw4;
        this.b = nw42;
        this.c = nw43;
        this.d = nw44;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.nw4
    public final /* bridge */ /* synthetic */ dt4 a() {
        if (this.e != 0) {
            return new ns4((bs4) this.f1029a.a(), mw4.b(this.b), mw4.b(this.c), (ss4) this.d.a());
        }
        Object a2 = this.f1029a.a();
        return new dt4((bs4) a2, mw4.b(this.b), (ss4) this.c.a(), mw4.b(this.d));
    }
}
