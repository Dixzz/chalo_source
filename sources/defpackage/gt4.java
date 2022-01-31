package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: gt4  reason: default package */
public final class gt4 {
    public static final nv4 d = new nv4("ExtractorTaskFinder");

    /* renamed from: a  reason: collision with root package name */
    public final dt4 f1301a;
    public final bs4 b;
    public final hs4 c;

    public gt4(dt4 dt4, bs4 bs4, hs4 hs4) {
        this.f1301a = dt4;
        this.b = bs4;
        this.c = hs4;
    }

    public final ft4 a() {
        ReentrantLock reentrantLock;
        int i;
        char c2;
        ft4 ft4;
        dt4 dt4;
        ms4 ms4;
        int i2;
        try {
            this.f1301a.f.lock();
            ArrayList arrayList = new ArrayList();
            for (at4 at4 : this.f1301a.e.values()) {
                if (mt4.f(at4.c.c)) {
                    arrayList.add(at4);
                }
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    i = 3;
                    c2 = 0;
                    if (!it.hasNext()) {
                        ft4 = null;
                        break;
                    }
                    at4 at42 = (at4) it.next();
                    try {
                        bs4 bs4 = this.b;
                        zs4 zs4 = at42.c;
                        if (bs4.n(zs4.f4206a, at42.b, zs4.b) == at42.c.e.size()) {
                            d.b(3, "Found final move task for session %s with pack %s.", new Object[]{Integer.valueOf(at42.f329a), at42.c.f4206a});
                            int i3 = at42.f329a;
                            zs4 zs42 = at42.c;
                            ft4 = new st4(i3, zs42.f4206a, at42.b, zs42.b);
                            break;
                        }
                    } catch (IOException e) {
                        throw new os4(String.format("Failed to check number of completed merges for session %s, pack %s", Integer.valueOf(at42.f329a), at42.c.f4206a), e, at42.f329a);
                    }
                }
                if (ft4 == null) {
                    Iterator it2 = arrayList.iterator();
                    loop2:
                    while (true) {
                        if (!it2.hasNext()) {
                            ft4 = null;
                            break;
                        }
                        at4 at43 = (at4) it2.next();
                        if (mt4.f(at43.c.c)) {
                            for (Iterator<bt4> it3 = at43.c.e.iterator(); it3.hasNext(); it3 = it3) {
                                bt4 next = it3.next();
                                bs4 bs42 = this.b;
                                zs4 zs43 = at43.c;
                                if (bs42.l(zs43.f4206a, at43.b, zs43.b, next.f473a).exists()) {
                                    d.b(3, "Found merge task for session %s with pack %s and slice %s.", new Object[]{Integer.valueOf(at43.f329a), at43.c.f4206a, next.f473a});
                                    int i4 = at43.f329a;
                                    zs4 zs44 = at43.c;
                                    ft4 = new pt4(i4, zs44.f4206a, at43.b, zs44.b, next.f473a);
                                    break loop2;
                                }
                            }
                            continue;
                        }
                    }
                    if (ft4 == null) {
                        Iterator it4 = arrayList.iterator();
                        loop4:
                        while (true) {
                            if (!it4.hasNext()) {
                                ft4 = null;
                                break;
                            }
                            at4 at44 = (at4) it4.next();
                            if (mt4.f(at44.c.c)) {
                                for (bt4 bt4 : at44.c.e) {
                                    if (b(at44, bt4)) {
                                        bs4 bs43 = this.b;
                                        zs4 zs45 = at44.c;
                                        if (bs43.k(zs45.f4206a, at44.b, zs45.b, bt4.f473a).exists()) {
                                            d.b(3, "Found verify task for session %s with pack %s and slice %s.", new Object[]{Integer.valueOf(at44.f329a), at44.c.f4206a, bt4.f473a});
                                            int i5 = at44.f329a;
                                            zs4 zs46 = at44.c;
                                            ft4 = new eu4(i5, zs46.f4206a, at44.b, zs46.b, bt4.f473a, bt4.b);
                                            break loop4;
                                        }
                                    }
                                }
                                continue;
                            }
                        }
                        if (ft4 == null) {
                            Iterator it5 = arrayList.iterator();
                            loop6:
                            while (true) {
                                char c3 = 4;
                                if (!it5.hasNext()) {
                                    ms4 = null;
                                    break;
                                }
                                at4 at45 = (at4) it5.next();
                                if (mt4.f(at45.c.c)) {
                                    for (bt4 bt42 : at45.c.e) {
                                        int i6 = bt42.f;
                                        if (!(i6 == 1 || i6 == 2)) {
                                            bs4 bs44 = this.b;
                                            zs4 zs47 = at45.c;
                                            try {
                                                i2 = new bu4(bs44, zs47.f4206a, at45.b, zs47.b, bt42.f473a).j();
                                            } catch (IOException e2) {
                                                nv4 nv4 = d;
                                                Object[] objArr = new Object[1];
                                                objArr[c2] = e2;
                                                nv4.b(6, "Slice checkpoint corrupt, restarting extraction. %s", objArr);
                                                i2 = 0;
                                            }
                                            if (i2 != -1 && bt42.d.get(i2).f4083a) {
                                                nv4 nv42 = d;
                                                Object[] objArr2 = new Object[5];
                                                objArr2[c2] = Integer.valueOf(bt42.e);
                                                objArr2[1] = Integer.valueOf(at45.f329a);
                                                objArr2[2] = at45.c.f4206a;
                                                objArr2[i] = bt42.f473a;
                                                objArr2[c3] = Integer.valueOf(i2);
                                                nv42.b(i, "Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s.", objArr2);
                                                InputStream a2 = this.c.a(at45.f329a, at45.c.f4206a, bt42.f473a, i2);
                                                int i7 = at45.f329a;
                                                zs4 zs48 = at45.c;
                                                String str = zs48.f4206a;
                                                int i8 = at45.b;
                                                long j = zs48.b;
                                                String str2 = bt42.f473a;
                                                int i9 = bt42.e;
                                                int size = bt42.d.size();
                                                zs4 zs49 = at45.c;
                                                ms4 = new ms4(i7, str, i8, j, str2, i9, i2, size, zs49.d, zs49.c, a2);
                                                break loop6;
                                            }
                                            it5 = it5;
                                            i = 3;
                                            c2 = 0;
                                            c3 = 4;
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (ms4 != null) {
                                return ms4;
                            }
                            Iterator it6 = arrayList.iterator();
                            loop8:
                            while (true) {
                                if (!it6.hasNext()) {
                                    ft4 = null;
                                    break;
                                }
                                at4 at46 = (at4) it6.next();
                                if (mt4.f(at46.c.c)) {
                                    for (bt4 bt43 : at46.c.e) {
                                        int i10 = bt43.f;
                                        if ((i10 == 1 || i10 == 2) && bt43.d.get(0).f4083a && !b(at46, bt43)) {
                                            d.b(3, "Found patch slice task using patch format %s for session %s, pack %s, slice %s.", new Object[]{Integer.valueOf(bt43.f), Integer.valueOf(at46.f329a), at46.c.f4206a, bt43.f473a});
                                            InputStream a3 = this.c.a(at46.f329a, at46.c.f4206a, bt43.f473a, 0);
                                            int i11 = at46.f329a;
                                            String str3 = at46.c.f4206a;
                                            ft4 = new yt4(i11, str3, (int) bs4.c(this.b.a(str3), true), this.b.s(at46.c.f4206a), at46.b, at46.c.b, bt43.f, bt43.f473a, bt43.c, a3);
                                            break loop8;
                                        }
                                    }
                                    continue;
                                }
                            }
                            dt4 = this.f1301a;
                            if (ft4 == null) {
                                reentrantLock = dt4.f;
                            }
                            dt4.f.unlock();
                            return ft4;
                        }
                    }
                }
                dt4 = this.f1301a;
                dt4.f.unlock();
                return ft4;
            }
            reentrantLock = this.f1301a.f;
            reentrantLock.unlock();
            return null;
        } finally {
            this.f1301a.f.unlock();
        }
    }

    public final boolean b(at4 at4, bt4 bt4) {
        bs4 bs4 = this.b;
        zs4 zs4 = at4.c;
        File p = bs4.p(zs4.f4206a, at4.b, zs4.b, bt4.f473a);
        if (p.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(p);
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    if (properties.getProperty("fileStatus") == null) {
                        bu4.h.b(6, "Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                    } else if (Integer.parseInt(properties.getProperty("fileStatus")) == 4) {
                        return true;
                    }
                } catch (Throwable th) {
                    jw4.f1988a.a(th, th);
                }
            } catch (IOException e) {
                bu4.h.b(6, "Could not read checkpoint while checking if extraction finished. %s", new Object[]{e});
            }
        }
        return false;
        throw th;
    }
}
