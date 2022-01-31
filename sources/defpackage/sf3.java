package defpackage;

import android.database.ContentObserver;

/* renamed from: sf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class sf3 extends ContentObserver {
    public sf3() {
        super(null);
    }

    public final void onChange(boolean z) {
        yf3.i.incrementAndGet();
    }
}
