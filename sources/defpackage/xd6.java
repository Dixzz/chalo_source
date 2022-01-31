package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* renamed from: xd6  reason: default package */
/* compiled from: ArrayChannel.kt */
public class xd6<E> extends ud6<E> {
    public final int f;
    public final yd6 g;
    public final ReentrantLock h;
    public Object[] i;
    public int j;
    private volatile /* synthetic */ int size;

    public xd6(int i2, yd6 yd6, s76<? super E, s56> s76) {
        super(s76);
        this.f = i2;
        this.g = yd6;
        if (i2 < 1 ? false : true) {
            this.h = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i2, 8)];
            y56.g(objArr, vd6.f3636a, 0, 0, 6);
            this.i = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(hj1.J("ArrayChannel capacity must be at least 1, but ", i2, " was specified").toString());
    }

    public final void A(int i2, E e) {
        int i3 = this.f;
        if (i2 < i3) {
            Object[] objArr = this.i;
            if (i2 >= objArr.length) {
                int min = Math.min(objArr.length * 2, i3);
                Object[] objArr2 = new Object[min];
                if (i2 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        Object[] objArr3 = this.i;
                        objArr2[i4] = objArr3[(this.j + i4) % objArr3.length];
                        if (i5 >= i2) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                y56.f(objArr2, vd6.f3636a, i2, min);
                this.i = objArr2;
                this.j = 0;
            }
            Object[] objArr4 = this.i;
            objArr4[(this.j + i2) % objArr4.length] = e;
            return;
        }
        Object[] objArr5 = this.i;
        int i6 = this.j;
        objArr5[i6 % objArr5.length] = null;
        objArr5[(i2 + i6) % objArr5.length] = e;
        this.j = (i6 + 1) % objArr5.length;
    }

    @Override // defpackage.wd6
    public Object i(le6 le6) {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            return super.i(le6);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.wd6
    public String j() {
        StringBuilder i0 = hj1.i0("(buffer:capacity=");
        i0.append(this.f);
        i0.append(",size=");
        return hj1.W(i0, this.size, ')');
    }

    @Override // defpackage.wd6
    public final boolean m() {
        return false;
    }

    @Override // defpackage.wd6
    public final boolean n() {
        return this.size == this.f && this.g == yd6.SUSPEND;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035 A[Catch:{ all -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0062  */
    @Override // defpackage.wd6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object o(E r7) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xd6.o(java.lang.Object):java.lang.Object");
    }

    @Override // defpackage.ud6
    public boolean s(he6<? super E> he6) {
        ReentrantLock reentrantLock = this.h;
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
        return this.size == 0;
    }

    @Override // defpackage.ud6
    public boolean v() {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            return super.v();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.ud6
    public void w(boolean z) {
        dg6 dg6 = vd6.f3636a;
        s76<E, s56> s76 = this.b;
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            jg6 jg6 = null;
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = this.i[this.j];
                if (!(s76 == null || obj == dg6)) {
                    jg6 = ec6.h(s76, obj, jg6);
                }
                Object[] objArr = this.i;
                int i4 = this.j;
                objArr[i4] = dg6;
                this.j = (i4 + 1) % objArr.length;
            }
            this.size = 0;
            reentrantLock.unlock();
            super.w(z);
            if (jg6 != null) {
                throw jg6;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.ud6
    public Object y() {
        Object obj;
        Object obj2 = vd6.d;
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                ce6<?> k = k();
                if (k != null) {
                    obj2 = k;
                }
                return obj2;
            }
            Object[] objArr = this.i;
            int i3 = this.j;
            Object obj3 = objArr[i3];
            le6 le6 = null;
            objArr[i3] = null;
            this.size = i2 - 1;
            boolean z = false;
            if (i2 == this.f) {
                le6 le62 = null;
                while (true) {
                    le6 r = r();
                    if (r == null) {
                        le6 = le62;
                        break;
                    } else if (r.y(null) != null) {
                        obj = r.w();
                        le6 = r;
                        z = true;
                        break;
                    } else {
                        r.z();
                        le62 = r;
                    }
                }
            }
            obj = obj2;
            if (obj != obj2 && !(obj instanceof ce6)) {
                this.size = i2;
                Object[] objArr2 = this.i;
                objArr2[(this.j + i2) % objArr2.length] = obj;
            }
            this.j = (this.j + 1) % this.i.length;
            reentrantLock.unlock();
            if (z) {
                n86.c(le6);
                le6.v();
            }
            return obj3;
        } finally {
            reentrantLock.unlock();
        }
    }
}
