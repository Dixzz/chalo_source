package defpackage;

import android.app.Application;
import androidx.lifecycle.LiveData;

/* renamed from: s91  reason: default package */
/* compiled from: PendingSuperPassBookingSummaryViewModel.kt */
public final class s91 extends lg {
    public final wh d;
    public final oh<Boolean> e;
    public final LiveData<Boolean> f;
    public final oh<Boolean> g;
    public final LiveData<Boolean> h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        Boolean bool = Boolean.FALSE;
        oh<Boolean> a2 = whVar.a("keyProofDocumentsExpansionState", bool);
        n86.d(a2, "savedStateHandle.getLive…S_EXPANSION_STATE, false)");
        this.e = a2;
        this.f = a2;
        oh<Boolean> a3 = whVar.a("keyFareLayoutExpansionState", bool);
        n86.d(a3, "savedStateHandle.getLive…T_EXPANSION_STATE, false)");
        this.g = a3;
        this.h = a3;
    }
}
