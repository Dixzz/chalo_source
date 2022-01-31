package defpackage;

import android.os.SystemClock;
import android.util.Log;
import defpackage.cn1;
import defpackage.ip1;
import defpackage.km1;
import java.util.Collections;
import java.util.List;

/* renamed from: vn1  reason: default package */
/* compiled from: SourceGenerator */
public class vn1 implements cn1, km1.a<Object>, cn1.a {
    public final dn1<?> f;
    public final cn1.a g;
    public int h;
    public zm1 i;
    public Object j;
    public volatile ip1.a<?> k;
    public an1 l;

    public vn1(dn1<?> dn1, cn1.a aVar) {
        this.f = dn1;
        this.g = aVar;
    }

    @Override // defpackage.cn1.a
    public void a(dm1 dm1, Exception exc, km1<?> km1, xl1 xl1) {
        this.g.a(dm1, exc, km1, this.k.c.d());
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.cn1
    public boolean b() {
        Object obj = this.j;
        if (obj != null) {
            this.j = null;
            int i2 = nt1.b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                am1<X> e = this.f.e(obj);
                bn1 bn1 = new bn1(e, obj, this.f.i);
                dm1 dm1 = this.k.f1550a;
                dn1<?> dn1 = this.f;
                this.l = new an1(dm1, dn1.n);
                dn1.b().a(this.l, bn1);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    String str = "Finished encoding source to cache, key: " + this.l + ", data: " + obj + ", encoder: " + e + ", duration: " + nt1.a(elapsedRealtimeNanos);
                }
                this.k.c.b();
                this.i = new zm1(Collections.singletonList(this.k.f1550a), this.f, this);
            } catch (Throwable th) {
                this.k.c.b();
                throw th;
            }
        }
        zm1 zm1 = this.i;
        if (zm1 != null && zm1.b()) {
            return true;
        }
        this.i = null;
        this.k = null;
        boolean z = false;
        while (!z) {
            if (!(this.h < this.f.c().size())) {
                break;
            }
            List<ip1.a<?>> c = this.f.c();
            int i3 = this.h;
            this.h = i3 + 1;
            this.k = c.get(i3);
            if (this.k != null && (this.f.p.c(this.k.c.d()) || this.f.g(this.k.c.a()))) {
                this.k.c.e(this.f.o, this);
                z = true;
            }
        }
        return z;
    }

    @Override // defpackage.km1.a
    public void c(Exception exc) {
        this.g.a(this.l, exc, this.k.c, this.k.c.d());
    }

    @Override // defpackage.cn1
    public void cancel() {
        ip1.a<?> aVar = this.k;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // defpackage.cn1.a
    public void f() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.km1.a
    public void g(Object obj) {
        gn1 gn1 = this.f.p;
        if (obj == null || !gn1.c(this.k.c.d())) {
            this.g.h(this.k.f1550a, obj, this.k.c, this.k.c.d(), this.l);
            return;
        }
        this.j = obj;
        this.g.f();
    }

    @Override // defpackage.cn1.a
    public void h(dm1 dm1, Object obj, km1<?> km1, xl1 xl1, dm1 dm12) {
        this.g.h(dm1, obj, km1, this.k.c.d(), dm1);
    }
}
