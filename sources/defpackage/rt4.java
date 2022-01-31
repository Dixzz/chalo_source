package defpackage;

import android.content.Context;

/* renamed from: rt4  reason: default package */
public final class rt4 implements nw4<qt4> {

    /* renamed from: a  reason: collision with root package name */
    public final nw4 f3128a;
    public final /* synthetic */ int b = 0;

    public rt4(nw4<bs4> nw4) {
        this.f3128a = nw4;
    }

    public rt4(nw4<vu4> nw4, byte[] bArr) {
        this.f3128a = nw4;
    }

    public rt4(nw4<Context> nw4, char[] cArr) {
        this.f3128a = nw4;
    }

    public rt4(nw4<bs4> nw4, short[] sArr) {
        this.f3128a = nw4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.nw4
    public final /* bridge */ /* synthetic */ qt4 a() {
        int i = this.b;
        return i != 0 ? i != 1 ? i != 2 ? new fu4((bs4) this.f3128a.a()) : new xt4(((ru4) this.f3128a).a()) : new hs4(mw4.b(this.f3128a)) : new qt4((bs4) this.f3128a.a());
    }
}
