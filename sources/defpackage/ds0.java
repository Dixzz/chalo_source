package defpackage;

import android.content.DialogInterface;
import defpackage.nw0;

/* renamed from: ds0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ds0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ nw0 f;

    public /* synthetic */ ds0(nw0 nw0) {
        this.f = nw0;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        nw0 nw0 = this.f;
        nw0.a aVar = nw0.j;
        n86.e(nw0, "this$0");
        n86.e("sound permission through settings canceled", "lName");
        n86.e("sound info rationale fragment", "lSource");
        ed1 ed1 = new ed1("sound permission through settings canceled", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment");
        ui1.m0(ed1);
        dialogInterface.dismiss();
        nw0.g();
    }
}
