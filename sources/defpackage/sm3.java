package defpackage;

import android.content.Context;
import android.os.Looper;
import defpackage.a32;
import javax.annotation.Nullable;

/* renamed from: sm3  reason: default package */
public final class sm3 extends dn3 {
    public final nm3 c;

    public sm3(Context context, Looper looper, a32.b bVar, a32.c cVar, String str, @Nullable x72 x72) {
        super(context, looper, bVar, cVar, str, x72);
        this.c = new nm3(context, this.b);
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final void disconnect() {
        synchronized (this.c) {
            if (isConnected()) {
                try {
                    this.c.a();
                    this.c.c();
                } catch (Exception unused) {
                }
            }
            super.disconnect();
        }
    }
}
