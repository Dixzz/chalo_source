package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import defpackage.nw0;

/* renamed from: gs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gs0 implements View.OnClickListener {
    public final /* synthetic */ nw0 f;

    public /* synthetic */ gs0(nw0 nw0) {
        this.f = nw0;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        nw0 nw0 = this.f;
        nw0.a aVar = nw0.j;
        n86.e(nw0, "this$0");
        n86.e("sound info rationale up button clicked", "lName");
        n86.e("sound info rationale fragment", "lSource");
        ed1 ed1 = new ed1("sound info rationale up button clicked", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment");
        ui1.m0(ed1);
        ve activity = nw0.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
