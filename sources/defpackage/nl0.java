package defpackage;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

/* renamed from: nl0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class nl0 implements View.OnClickListener {
    public final /* synthetic */ ol0 f;

    public /* synthetic */ nl0(ol0 ol0) {
        this.f = ol0;
    }

    public final void onClick(View view) {
        ol0 ol0 = this.f;
        int i = ol0.j;
        n86.e(ol0, "this$0");
        Snackbar snackbar = ol0.i;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }
}
