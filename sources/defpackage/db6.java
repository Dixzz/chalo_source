package defpackage;

import java.util.Objects;

/* renamed from: db6  reason: default package */
/* compiled from: CancellableContinuationImpl.kt */
public final class db6 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f818a;
    public final pa6 b;
    public final s76<Throwable, s56> c;
    public final Object d;
    public final Throwable e;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: s76<? super java.lang.Throwable, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public db6(Object obj, pa6 pa6, s76<? super Throwable, s56> s76, Object obj2, Throwable th) {
        this.f818a = obj;
        this.b = pa6;
        this.c = s76;
        this.d = obj2;
        this.e = th;
    }

    public static db6 a(db6 db6, Object obj, pa6 pa6, s76 s76, Object obj2, Throwable th, int i) {
        Object obj3 = null;
        Object obj4 = (i & 1) != 0 ? db6.f818a : null;
        if ((i & 2) != 0) {
            pa6 = db6.b;
        }
        s76<Throwable, s56> s762 = (i & 4) != 0 ? db6.c : null;
        if ((i & 8) != 0) {
            obj3 = db6.d;
        }
        if ((i & 16) != 0) {
            th = db6.e;
        }
        Objects.requireNonNull(db6);
        return new db6(obj4, pa6, s762, obj3, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof db6)) {
            return false;
        }
        db6 db6 = (db6) obj;
        return n86.a(this.f818a, db6.f818a) && n86.a(this.b, db6.b) && n86.a(this.c, db6.c) && n86.a(this.d, db6.d) && n86.a(this.e, db6.e);
    }

    public int hashCode() {
        Object obj = this.f818a;
        int i = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        pa6 pa6 = this.b;
        int hashCode2 = (hashCode + (pa6 == null ? 0 : pa6.hashCode())) * 31;
        s76<Throwable, s56> s76 = this.c;
        int hashCode3 = (hashCode2 + (s76 == null ? 0 : s76.hashCode())) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CompletedContinuation(result=");
        i0.append(this.f818a);
        i0.append(", cancelHandler=");
        i0.append(this.b);
        i0.append(", onCancellation=");
        i0.append(this.c);
        i0.append(", idempotentResume=");
        i0.append(this.d);
        i0.append(", cancelCause=");
        i0.append(this.e);
        i0.append(')');
        return i0.toString();
    }

    public db6(Object obj, pa6 pa6, s76 s76, Object obj2, Throwable th, int i) {
        pa6 = (i & 2) != 0 ? null : pa6;
        s76 = (i & 4) != 0 ? null : s76;
        obj2 = (i & 8) != 0 ? null : obj2;
        th = (i & 16) != 0 ? null : th;
        this.f818a = obj;
        this.b = pa6;
        this.c = s76;
        this.d = obj2;
        this.e = th;
    }
}
