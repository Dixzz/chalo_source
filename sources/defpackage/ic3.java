package defpackage;

import android.content.ComponentName;
import java.util.Objects;

/* renamed from: ic3  reason: default package */
public final class ic3 implements Runnable {
    public final /* synthetic */ ComponentName f;
    public final /* synthetic */ gc3 g;

    public ic3(gc3 gc3, ComponentName componentName) {
        this.g = gc3;
        this.f = componentName;
    }

    public final void run() {
        ec3 ec3 = this.g.c;
        ComponentName componentName = this.f;
        Objects.requireNonNull(ec3);
        jz1.c();
        if (ec3.i != null) {
            ec3.i = null;
            ec3.k("Disconnected from device AnalyticsService", componentName);
            sb3 A = ec3.A();
            A.g0();
            jz1.c();
            mc3 mc3 = A.h;
            jz1.c();
            mc3.g0();
            mc3.M("Service disconnected");
        }
    }
}
