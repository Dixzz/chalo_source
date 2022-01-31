package defpackage;

import defpackage.em1;
import defpackage.t2;
import java.security.MessageDigest;
import java.util.Iterator;

/* renamed from: fm1  reason: default package */
/* compiled from: Options */
public final class fm1 implements dm1 {
    public final n2<em1<?>, Object> b = new n2<>();

    @Override // defpackage.dm1
    public void a(MessageDigest messageDigest) {
        Iterator it = ((t2.b) this.b.entrySet()).iterator();
        while (true) {
            t2.d dVar = (t2.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                t2.d dVar2 = dVar;
                em1 em1 = (em1) dVar2.getKey();
                Object value = dVar2.getValue();
                em1.b<T> bVar = em1.b;
                if (em1.d == null) {
                    em1.d = em1.c.getBytes(dm1.f856a);
                }
                bVar.a(em1.d, value, messageDigest);
            } else {
                return;
            }
        }
    }

    public <T> T c(em1<T> em1) {
        return this.b.e(em1) >= 0 ? (T) this.b.getOrDefault(em1, null) : em1.f992a;
    }

    public void d(fm1 fm1) {
        this.b.i(fm1.b);
    }

    @Override // defpackage.dm1
    public boolean equals(Object obj) {
        if (obj instanceof fm1) {
            return this.b.equals(((fm1) obj).b);
        }
        return false;
    }

    @Override // defpackage.dm1
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Options{values=");
        i0.append(this.b);
        i0.append('}');
        return i0.toString();
    }
}
