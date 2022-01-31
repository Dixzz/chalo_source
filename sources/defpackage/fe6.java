package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* renamed from: fe6  reason: default package */
/* compiled from: ConflatedChannel.kt */
public class fe6<E> extends ud6<E> {
    public final ReentrantLock f = new ReentrantLock();
    public Object g = vd6.f3636a;

    public fe6(s76<? super E, s56> s76) {
        super(s76);
    }

    public final jg6 A(Object obj) {
        s76<E, s56> s76;
        Object obj2 = this.g;
        jg6 jg6 = null;
        if (!(obj2 == vd6.f3636a || (s76 = this.b) == null)) {
            jg6 = ec6.h(s76, obj2, null);
        }
        this.g = obj;
        return jg6;
    }

    @Override // defpackage.wd6
    public String j() {
        StringBuilder i0 = hj1.i0("(value=");
        i0.append(this.g);
        i0.append(')');
        return i0.toString();
    }

    @Override // defpackage.wd6
    public final boolean m() {
        return false;
    }

    @Override // defpackage.wd6
    public final boolean n() {
        return false;
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.wd6
    public Object o(E e) {
        je6<E> q;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            ce6<?> k = k();
            if (k == null) {
                if (this.g == vd6.f3636a) {
                    do {
                        q = q();
                        if (q != null) {
                            if (q instanceof ce6) {
                                reentrantLock.unlock();
                                return q;
                            }
                        }
                    } while (q.i(e, null) == null);
                    reentrantLock.unlock();
                    q.g(e);
                    return q.c();
                }
                jg6 A = A(e);
                if (A == null) {
                    dg6 dg6 = vd6.b;
                    reentrantLock.unlock();
                    return dg6;
                }
                throw A;
            }
            reentrantLock.unlock();
            return k;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.ud6
    public boolean s(he6<? super E> he6) {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.s(he6);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.ud6
    public final boolean t() {
        return false;
    }

    @Override // defpackage.ud6
    public final boolean u() {
        return this.g == vd6.f3636a;
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.ud6
    public void w(boolean z) {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            jg6 A = A(vd6.f3636a);
            reentrantLock.unlock();
            super.w(z);
            if (A != null) {
                throw A;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.ud6
    public Object y() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            Object obj = this.g;
            dg6 dg6 = vd6.f3636a;
            if (obj == dg6) {
                Object k = k();
                if (k == null) {
                    k = vd6.d;
                }
                return k;
            }
            this.g = dg6;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
