package defpackage;

import android.content.Context;
import java.util.concurrent.Executor;

/* renamed from: qs4  reason: default package */
public final class qs4 implements nw4<ps4> {

    /* renamed from: a  reason: collision with root package name */
    public final nw4 f2986a;
    public final nw4 b;
    public final nw4 c;
    public final nw4 d;
    public final nw4 e;
    public final nw4 f;
    public final nw4 g;
    public final nw4 h;
    public final /* synthetic */ int i = 0;

    public qs4(nw4<dt4> nw4, nw4<vu4> nw42, nw4<ns4> nw43, nw4<fu4> nw44, nw4<qt4> nw45, nw4<vt4> nw46, nw4<zt4> nw47, nw4<gt4> nw48) {
        this.f2986a = nw4;
        this.b = nw42;
        this.c = nw43;
        this.d = nw44;
        this.e = nw45;
        this.f = nw46;
        this.g = nw47;
        this.h = nw48;
    }

    public qs4(nw4<Context> nw4, nw4<dt4> nw42, nw4<ps4> nw43, nw4<vu4> nw44, nw4<ss4> nw45, nw4<js4> nw46, nw4<Executor> nw47, nw4<Executor> nw48, byte[] bArr) {
        this.f2986a = nw4;
        this.g = nw42;
        this.h = nw43;
        this.b = nw44;
        this.e = nw45;
        this.f = nw46;
        this.c = nw47;
        this.d = nw48;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.nw4
    public final /* bridge */ /* synthetic */ ps4 a() {
        if (this.i != 0) {
            Context b2 = ((ru4) this.f2986a).a();
            Object a2 = this.g.a();
            Object a3 = this.h.a();
            kw4 b3 = mw4.b(this.b);
            Object a4 = this.e.a();
            Object a5 = this.f.a();
            return new yr4(b2, (dt4) a2, (ps4) a3, b3, (ss4) a4, (js4) a5, mw4.b(this.c), mw4.b(this.d));
        }
        Object a6 = this.f2986a.a();
        return new ps4((dt4) a6, mw4.b(this.b), (ns4) this.c.a(), (fu4) this.d.a(), (qt4) this.e.a(), (vt4) this.f.a(), (zt4) this.g.a(), (gt4) this.h.a());
    }
}
