package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: wn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class wn2 implements io2 {

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f3806a;

    public wn2(OutputStream outputStream) {
        this.f3806a = outputStream;
    }

    @Override // defpackage.io2
    public final void a(kv2 kv2) throws IOException {
        OutputStream outputStream = this.f3806a;
        Objects.requireNonNull(kv2);
        int k = kv2.k();
        Logger logger = n93.b;
        if (k > 4096) {
            k = 4096;
        }
        m93 m93 = new m93(outputStream, k);
        kv2.p(m93);
        if (m93.f > 0) {
            m93.E();
        }
    }

    @Override // defpackage.io2
    public final void b(gu2 gu2) throws IOException {
        throw null;
    }
}
