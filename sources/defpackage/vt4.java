package defpackage;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: vt4  reason: default package */
public final class vt4 {

    /* renamed from: a  reason: collision with root package name */
    public final bs4 f3682a;
    public final kw4<vu4> b;
    public final dt4 c;
    public final kw4<Executor> d;
    public final ss4 e;
    public final bv4 f;

    public vt4(bs4 bs4, kw4<vu4> kw4, dt4 dt4, kw4<Executor> kw42, ss4 ss4, bv4 bv4) {
        this.f3682a = bs4;
        this.b = kw4;
        this.c = dt4;
        this.d = kw42;
        this.e = ss4;
        this.f = bv4;
    }

    public final void a(st4 st4) {
        File m = this.f3682a.m(st4.b, st4.c, st4.d);
        bs4 bs4 = this.f3682a;
        String str = st4.b;
        int i = st4.c;
        long j = st4.d;
        Objects.requireNonNull(bs4);
        File file = new File(new File(bs4.e(str, i, j), "_slices"), "_metadata");
        boolean z = false;
        if (!m.exists() || !file.exists()) {
            throw new os4(String.format("Cannot find pack files to move for pack %s.", st4.b), st4.f1171a);
        }
        File j2 = this.f3682a.j(st4.b, st4.c, st4.d);
        j2.mkdirs();
        if (m.renameTo(j2)) {
            new File(this.f3682a.j(st4.b, st4.c, st4.d), "merge.tmp").delete();
            bs4 bs42 = this.f3682a;
            String str2 = st4.b;
            int i2 = st4.c;
            long j3 = st4.d;
            Objects.requireNonNull(bs42);
            File file2 = new File(bs42.j(str2, i2, j3), "_metadata");
            file2.mkdirs();
            if (file.renameTo(file2)) {
                bv4 bv4 = this.f;
                synchronized (bv4) {
                    if (!bv4.b.get()) {
                        synchronized (bv4) {
                            bv4.f481a.put("assetOnlyUpdates", Boolean.FALSE);
                        }
                    }
                    Object obj = bv4.f481a.get("assetOnlyUpdates");
                    if (obj instanceof Boolean) {
                        z = ((Boolean) obj).booleanValue();
                    }
                }
                Executor a2 = this.d.a();
                if (z) {
                    a2.execute(new tt4(this, st4));
                } else {
                    bs4 bs43 = this.f3682a;
                    bs43.getClass();
                    a2.execute(new ut4(bs43));
                }
                dt4 dt4 = this.c;
                dt4.b(new vs4(dt4, st4.b, st4.c, st4.d));
                this.e.a(st4.b);
                this.b.a().c(st4.f1171a, st4.b);
                return;
            }
            throw new os4("Cannot move metadata files to final location.", st4.f1171a);
        }
        throw new os4("Cannot move merged pack files to final location.", st4.f1171a);
    }
}
