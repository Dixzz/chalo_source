package defpackage;

import java.io.IOException;

/* renamed from: i22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class i22 implements Runnable {
    public final zi4 f;

    public i22(zi4 zi4) {
        this.f = zi4;
    }

    public final void run() {
        this.f.a(new IOException("TIMEOUT"));
    }
}
