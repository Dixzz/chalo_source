package defpackage;

import java.io.IOException;

/* renamed from: tm6  reason: default package */
/* compiled from: AsyncTimeout.kt */
public final class tm6 implements qn6 {
    public final /* synthetic */ rm6 f;
    public final /* synthetic */ qn6 g;

    public tm6(rm6 rm6, qn6 qn6) {
        this.f = rm6;
        this.g = qn6;
    }

    @Override // java.io.Closeable, defpackage.qn6, java.lang.AutoCloseable
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

    @Override // defpackage.qn6
    public long read(vm6 vm6, long j) {
        n86.f(vm6, "sink");
        rm6 rm6 = this.f;
        rm6.i();
        try {
            long read = this.g.read(vm6, j);
            if (!rm6.j()) {
                return read;
            }
            throw rm6.k(null);
        } catch (IOException e) {
            if (!rm6.j()) {
                throw e;
            }
            throw rm6.k(e);
        } finally {
            rm6.j();
        }
    }

    @Override // defpackage.qn6
    public rn6 timeout() {
        return this.f;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("AsyncTimeout.source(");
        i0.append(this.g);
        i0.append(')');
        return i0.toString();
    }
}
