package defpackage;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: wt4  reason: default package */
public final class wt4 implements nw4<vt4> {

    /* renamed from: a  reason: collision with root package name */
    public final nw4 f3837a;
    public final nw4 b;
    public final nw4 c;
    public final nw4 d;
    public final nw4 e;
    public final nw4 f;
    public final /* synthetic */ int g = 0;

    public wt4(nw4<bs4> nw4, nw4<vu4> nw42, nw4<dt4> nw43, nw4<Executor> nw44, nw4<ss4> nw45, nw4<bv4> nw46) {
        this.f3837a = nw4;
        this.b = nw42;
        this.c = nw43;
        this.d = nw44;
        this.e = nw45;
        this.f = nw46;
    }

    public wt4(nw4<String> nw4, nw4<yr4> nw42, nw4<ss4> nw43, nw4<Context> nw44, nw4<xt4> nw45, nw4<Executor> nw46, byte[] bArr) {
        this.f = nw4;
        this.b = nw42;
        this.e = nw43;
        this.d = nw44;
        this.c = nw45;
        this.f3837a = nw46;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.nw4
    public final /* bridge */ /* synthetic */ vt4 a() {
        if (this.g != 0) {
            String str = (String) this.f.a();
            Object a2 = this.b.a();
            Object a3 = this.e.a();
            Context b2 = ((ru4) this.d).a();
            Object a4 = this.c.a();
            return new lt4(str != null ? new File(b2.getExternalFilesDir(null), str) : b2.getExternalFilesDir(null), (yr4) a2, (ss4) a3, b2, (xt4) a4, mw4.b(this.f3837a));
        }
        Object a5 = this.f3837a.a();
        kw4 b3 = mw4.b(this.b);
        Object a6 = this.c.a();
        return new vt4((bs4) a5, b3, (dt4) a6, mw4.b(this.d), (ss4) this.e.a(), (bv4) this.f.a());
    }
}
