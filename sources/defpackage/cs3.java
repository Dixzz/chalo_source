package defpackage;

import android.database.ContentObserver;

/* renamed from: cs3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class cs3 extends ContentObserver {
    public cs3() {
        super(null);
    }

    public final void onChange(boolean z) {
        is3.j.incrementAndGet();
    }
}
