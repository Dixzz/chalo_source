package defpackage;

import android.os.SystemClock;

/* renamed from: b06  reason: default package */
/* compiled from: InitializationTask */
public class b06<Result> extends w06<Void, Void, Result> {
    public final c06<Result> t;

    public b06(c06<Result> c06) {
        this.t = c06;
    }

    public final r06 c(String str) {
        r06 r06 = new r06(this.t.getIdentifier() + "." + str, "KitInitialization");
        synchronized (r06) {
            if (!r06.b) {
                r06.c = SystemClock.elapsedRealtime();
                r06.d = 0;
            }
        }
        return r06;
    }

    @Override // defpackage.y06
    public v06 getPriority() {
        return v06.HIGH;
    }
}
