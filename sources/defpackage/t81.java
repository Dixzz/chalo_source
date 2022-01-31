package defpackage;

import android.app.Application;
import app.zophop.models.mTicketing.MTicket;

/* renamed from: t81  reason: default package */
/* compiled from: MTicketTripReceiptActivityViewModel.kt */
public final class t81 extends lg {
    public final wh d;
    public final String e;
    public final MTicket f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t81(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        Object obj = whVar.f3779a.get("keySource");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get(KEY_SOURCE)!!");
        this.e = (String) obj;
        Object obj2 = whVar.f3779a.get("keyMTicket");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get(KEY_MTICKET)!!");
        this.f = (MTicket) obj2;
    }
}
