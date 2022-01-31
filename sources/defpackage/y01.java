package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;

/* renamed from: y01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class y01 implements View.OnClickListener {
    public final /* synthetic */ ActiveSuperPassFragment f;

    public /* synthetic */ y01(ActiveSuperPassFragment activeSuperPassFragment) {
        this.f = activeSuperPassFragment;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        ActiveSuperPassFragment activeSuperPassFragment = this.f;
        ActiveSuperPassFragment.a aVar = ActiveSuperPassFragment.i;
        n86.e(activeSuperPassFragment, "this$0");
        ve activity = activeSuperPassFragment.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
