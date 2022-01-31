package defpackage;

import android.database.ContentObserver;

/* renamed from: kf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class kf3 extends ContentObserver {
    public kf3() {
        super(null);
    }

    public final void onChange(boolean z) {
        hf3.e.set(true);
    }
}
