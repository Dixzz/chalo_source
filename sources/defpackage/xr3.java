package defpackage;

import android.database.ContentObserver;

/* renamed from: xr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class xr3 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ vr3 f3958a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xr3(vr3 vr3) {
        super(null);
        this.f3958a = vr3;
    }

    public final void onChange(boolean z) {
        vr3 vr3 = this.f3958a;
        synchronized (vr3.d) {
            vr3.e = null;
            is3.j.incrementAndGet();
        }
        synchronized (vr3) {
            for (wr3 wr3 : vr3.f) {
                wr3.zza();
            }
        }
    }
}
