package defpackage;

import defpackage.yj1;
import java.io.UnsupportedEncodingException;

/* renamed from: ok1  reason: default package */
/* compiled from: StringRequest */
public class ok1 extends wj1<String> {
    public final Object u = new Object();
    public yj1.b<String> v;

    public ok1(int i, String str, yj1.b<String> bVar, yj1.a aVar) {
        super(i, str, aVar);
        this.v = bVar;
    }

    @Override // defpackage.wj1
    public yj1<String> A(tj1 tj1) {
        String str;
        try {
            str = new String(tj1.b, gj1.X(tj1.c, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
            str = new String(tj1.b);
        }
        return new yj1<>(str, gj1.W(tj1));
    }

    @Override // defpackage.wj1
    public void c() {
        super.c();
        synchronized (this.u) {
            this.v = null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.wj1
    public void g(String str) {
        yj1.b<String> bVar;
        String str2 = str;
        synchronized (this.u) {
            bVar = this.v;
        }
        if (bVar != null) {
            bVar.a(str2);
        }
    }
}
