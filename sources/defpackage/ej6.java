package defpackage;

import java.io.IOException;

/* renamed from: ej6  reason: default package */
/* compiled from: FaultHidingSink.kt */
public class ej6 extends bn6 {
    public boolean g;
    public final s76<IOException, s56> h;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: s76<? super java.io.IOException, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ej6(on6 on6, s76<? super IOException, s56> s76) {
        super(on6);
        n86.f(on6, "delegate");
        n86.f(s76, "onException");
        this.h = s76;
    }

    @Override // defpackage.on6, java.io.Closeable, defpackage.bn6, java.lang.AutoCloseable
    public void close() {
        if (!this.g) {
            try {
                super.close();
            } catch (IOException e) {
                this.g = true;
                this.h.invoke(e);
            }
        }
    }

    @Override // defpackage.on6, defpackage.bn6, java.io.Flushable
    public void flush() {
        if (!this.g) {
            try {
                this.f.flush();
            } catch (IOException e) {
                this.g = true;
                this.h.invoke(e);
            }
        }
    }

    @Override // defpackage.on6, defpackage.bn6
    public void s0(vm6 vm6, long j) {
        n86.f(vm6, "source");
        if (this.g) {
            vm6.d(j);
            return;
        }
        try {
            n86.f(vm6, "source");
            this.f.s0(vm6, j);
        } catch (IOException e) {
            this.g = true;
            this.h.invoke(e);
        }
    }
}
