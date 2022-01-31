package defpackage;

import android.view.View;
import defpackage.mw0;

/* renamed from: bs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bs0 implements View.OnClickListener {
    public final /* synthetic */ mw0 f;
    public final /* synthetic */ String g;

    public /* synthetic */ bs0(mw0 mw0, String str) {
        this.f = mw0;
        this.g = str;
    }

    public final void onClick(View view) {
        mw0 mw0 = this.f;
        String str = this.g;
        mw0.a aVar = mw0.j;
        n86.e(mw0, "this$0");
        n86.e(str, "$lPermission");
        n86.e("sound info got it clicked", "lName");
        n86.e("Sound info fragment", "lSource");
        ed1 ed1 = new ed1("sound info got it clicked", Long.MIN_VALUE);
        ed1.a("source", "Sound info fragment");
        ui1.m0(ed1);
        if (ui1.T(mw0.getContext(), str)) {
            mw0.g();
        } else {
            mw0.h.a(str, null);
        }
    }
}
