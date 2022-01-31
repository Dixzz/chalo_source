package defpackage;

import android.view.View;
import defpackage.gv0;
import java.util.Objects;

/* renamed from: nr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class nr0 implements View.OnClickListener {
    public final /* synthetic */ gv0 f;

    public /* synthetic */ nr0(gv0 gv0) {
        this.f = gv0;
    }

    public final void onClick(View view) {
        gv0 gv0 = this.f;
        int i = gv0.g;
        n86.e(gv0, "this$0");
        if (gv0.c() instanceof gv0.a) {
            ve activity = gv0.c();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.fragments.LoadingSpinnerFragment.LoadingSpinnerFragmentClickListener");
            ((gv0.a) activity).t();
            gv0.dismiss();
        }
    }
}
