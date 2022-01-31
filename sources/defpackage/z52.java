package defpackage;

import android.os.Looper;
import android.os.Message;
import defpackage.t32;

/* renamed from: z52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class z52 extends ve2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t32 f4131a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z52(t32 t32, Looper looper) {
        super(looper);
        this.f4131a = t32;
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        if (message.what != 1) {
            z = false;
        }
        gj1.b(z);
        t32.b bVar = (t32.b) message.obj;
        L l = this.f4131a.b;
        if (l == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(l);
        } catch (RuntimeException e) {
            bVar.b();
            throw e;
        }
    }
}
