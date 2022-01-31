package defpackage;

import android.app.Application;

/* renamed from: x91  reason: default package */
/* compiled from: SoundFragmentSuperPassLocalViewModel.kt */
public final class x91 extends lg {
    public final wh d;
    public final boolean e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        Boolean bool = (Boolean) whVar.f3779a.get("keyCanShowSoundInfo");
        this.e = bool == null ? false : bool.booleanValue();
    }
}
