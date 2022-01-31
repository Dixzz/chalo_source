package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;

/* renamed from: n01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n01 implements View.OnClickListener {
    public final /* synthetic */ ActivateSuperPassFragment f;

    public /* synthetic */ n01(ActivateSuperPassFragment activateSuperPassFragment) {
        this.f = activateSuperPassFragment;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        ActivateSuperPassFragment activateSuperPassFragment = this.f;
        ActivateSuperPassFragment.a aVar = ActivateSuperPassFragment.h;
        n86.e(activateSuperPassFragment, "this$0");
        ve activity = activateSuperPassFragment.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
