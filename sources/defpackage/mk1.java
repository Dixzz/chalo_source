package defpackage;

import android.util.Log;
import defpackage.yj1;
import java.io.UnsupportedEncodingException;

/* renamed from: mk1  reason: default package */
/* compiled from: JsonRequest */
public abstract class mk1<T> extends wj1<T> {
    public static final String x = String.format("application/json; charset=%s", "utf-8");
    public final Object u = new Object();
    public yj1.b<T> v;
    public final String w;

    public mk1(int i, String str, String str2, yj1.b<T> bVar, yj1.a aVar) {
        super(i, str, aVar);
        this.v = bVar;
        this.w = str2;
    }

    @Override // defpackage.wj1
    public void c() {
        super.c();
        synchronized (this.u) {
            this.v = null;
        }
    }

    @Override // defpackage.wj1
    public void g(T t) {
        yj1.b<T> bVar;
        synchronized (this.u) {
            bVar = this.v;
        }
        if (bVar != null) {
            bVar.a(t);
        }
    }

    @Override // defpackage.wj1
    public byte[] j() {
        try {
            String str = this.w;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Log.wtf("Volley", ek1.a("Unsupported Encoding while trying to get the bytes of %s using %s", this.w, "utf-8"));
            return null;
        }
    }

    @Override // defpackage.wj1
    public String k() {
        return x;
    }

    @Override // defpackage.wj1
    @Deprecated
    public byte[] p() {
        return j();
    }
}
