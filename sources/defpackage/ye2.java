package defpackage;

import android.database.ContentObserver;

/* renamed from: ye2  reason: default package */
public final class ye2 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ xe2 f4039a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ye2(xe2 xe2) {
        super(null);
        this.f4039a = xe2;
    }

    public final void onChange(boolean z) {
        xe2 xe2 = this.f4039a;
        synchronized (xe2.d) {
            xe2.e = null;
        }
        xe2 xe22 = this.f4039a;
        synchronized (xe22.f) {
            for (ze2 ze2 : xe22.g) {
                ze2.c();
            }
        }
    }
}
