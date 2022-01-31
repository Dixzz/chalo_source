package defpackage;

import defpackage.cn1;
import defpackage.ip1;
import defpackage.km1;
import java.io.File;
import java.util.List;

/* renamed from: zm1  reason: default package */
/* compiled from: DataCacheGenerator */
public class zm1 implements cn1, km1.a<Object> {
    public List<dm1> f;
    public final dn1<?> g;
    public final cn1.a h;
    public int i = -1;
    public dm1 j;
    public List<ip1<File, ?>> k;
    public int l;
    public volatile ip1.a<?> m;
    public File n;

    public zm1(dn1<?> dn1, cn1.a aVar) {
        List<dm1> a2 = dn1.a();
        this.f = a2;
        this.g = dn1;
        this.h = aVar;
    }

    @Override // defpackage.cn1
    public boolean b() {
        while (true) {
            List<ip1<File, ?>> list = this.k;
            if (list != null) {
                if (this.l < list.size()) {
                    this.m = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.l < this.k.size())) {
                            break;
                        }
                        List<ip1<File, ?>> list2 = this.k;
                        int i2 = this.l;
                        this.l = i2 + 1;
                        File file = this.n;
                        dn1<?> dn1 = this.g;
                        this.m = list2.get(i2).b(file, dn1.e, dn1.f, dn1.i);
                        if (this.m != null && this.g.g(this.m.c.a())) {
                            this.m.c.e(this.g.o, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i3 = this.i + 1;
            this.i = i3;
            if (i3 >= this.f.size()) {
                return false;
            }
            dm1 dm1 = this.f.get(this.i);
            dn1<?> dn12 = this.g;
            File b = dn12.b().b(new an1(dm1, dn12.n));
            this.n = b;
            if (b != null) {
                this.j = dm1;
                this.k = this.g.c.b.d(b);
                this.l = 0;
            }
        }
    }

    @Override // defpackage.km1.a
    public void c(Exception exc) {
        this.h.a(this.j, exc, this.m.c, xl1.DATA_DISK_CACHE);
    }

    @Override // defpackage.cn1
    public void cancel() {
        ip1.a<?> aVar = this.m;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // defpackage.km1.a
    public void g(Object obj) {
        this.h.h(this.j, obj, this.m.c, xl1.DATA_DISK_CACHE, this.j);
    }

    public zm1(List<dm1> list, dn1<?> dn1, cn1.a aVar) {
        this.f = list;
        this.g = dn1;
        this.h = aVar;
    }
}
