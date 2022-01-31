package defpackage;

import android.content.Context;
import android.os.Looper;
import defpackage.x22;
import defpackage.x22.d;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* renamed from: t52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class t52<O extends x22.d> extends i42 {
    @NotOnlyInitialized
    public final z22<O> b;

    public t52(z22<O> z22) {
        this.b = z22;
    }

    @Override // defpackage.a32
    public final <A extends x22.b, R extends f32, T extends l32<R, A>> T i(T t) {
        return (T) this.b.doRead(t);
    }

    @Override // defpackage.a32
    public final <A extends x22.b, T extends l32<? extends f32, A>> T j(T t) {
        return (T) this.b.doWrite(t);
    }

    @Override // defpackage.a32
    public final Context l() {
        return this.b.getApplicationContext();
    }

    @Override // defpackage.a32
    public final Looper m() {
        return this.b.getLooper();
    }
}
