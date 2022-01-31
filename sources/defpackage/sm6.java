package defpackage;

import java.io.IOException;

/* renamed from: sm6  reason: default package */
/* compiled from: AsyncTimeout.kt */
public final class sm6 implements on6 {
    public final /* synthetic */ rm6 f;
    public final /* synthetic */ on6 g;

    public sm6(rm6 rm6, on6 on6) {
        this.f = rm6;
        this.g = on6;
    }

    @Override // defpackage.on6, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        rm6 rm6 = this.f;
        rm6.i();
        try {
            this.g.close();
            if (rm6.j()) {
                throw rm6.k(null);
            }
        } catch (IOException e) {
            if (!rm6.j()) {
                throw e;
            }
            throw rm6.k(e);
        } finally {
            rm6.j();
        }
    }

    @Override // defpackage.on6, java.io.Flushable
    public void flush() {
        rm6 rm6 = this.f;
        rm6.i();
        try {
            this.g.flush();
            if (rm6.j()) {
                throw rm6.k(null);
            }
        } catch (IOException e) {
            if (!rm6.j()) {
                throw e;
            }
            throw rm6.k(e);
        } finally {
            rm6.j();
        }
    }

    @Override // defpackage.on6
    public void s0(vm6 vm6, long j) {
        n86.f(vm6, "source");
        ec6.l(vm6.g, 0, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                ln6 ln6 = vm6.f;
                if (ln6 != null) {
                    while (true) {
                        if (j2 >= ((long) 65536)) {
                            break;
                        }
                        j2 += (long) (ln6.c - ln6.b);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        ln6 = ln6.f;
                        if (ln6 == null) {
                            n86.k();
                            throw null;
                        }
                    }
                    rm6 rm6 = this.f;
                    rm6.i();
                    try {
                        this.g.s0(vm6, j2);
                        if (!rm6.j()) {
                            j -= j2;
                        } else {
                            throw rm6.k(null);
                        }
                    } catch (IOException e) {
                        if (!rm6.j()) {
                            throw e;
                        }
                        throw rm6.k(e);
                    } finally {
                        rm6.j();
                    }
                } else {
                    n86.k();
                    throw null;
                }
            } else {
                return;
            }
        }
    }

    @Override // defpackage.on6
    public rn6 timeout() {
        return this.f;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("AsyncTimeout.sink(");
        i0.append(this.g);
        i0.append(')');
        return i0.toString();
    }
}
