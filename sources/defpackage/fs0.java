package defpackage;

import android.view.View;
import defpackage.nw0;

/* renamed from: fs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fs0 implements View.OnClickListener {
    public final /* synthetic */ nw0 f;

    public /* synthetic */ fs0(nw0 nw0) {
        this.f = nw0;
    }

    public final void onClick(View view) {
        nw0 nw0 = this.f;
        nw0.a aVar = nw0.j;
        n86.e(nw0, "this$0");
        n86.e("sound info continue clicked", "lName");
        n86.e("sound info rationale fragment", "lSource");
        ed1 ed1 = new ed1("sound info continue clicked", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment");
        ui1.m0(ed1);
        if (ui1.T(nw0.getContext(), "android.permission.RECORD_AUDIO")) {
            nw0.g();
        } else {
            nw0.i.a("android.permission.RECORD_AUDIO", null);
        }
    }
}
