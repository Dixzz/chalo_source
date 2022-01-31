package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;

/* renamed from: n11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n11 implements View.OnClickListener {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f;

    public /* synthetic */ n11(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment) {
        this.f = activeSuperPassVisualValidationFragment;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment = this.f;
        ActiveSuperPassVisualValidationFragment.a aVar = ActiveSuperPassVisualValidationFragment.i;
        n86.e(activeSuperPassVisualValidationFragment, "this$0");
        ve activity = activeSuperPassVisualValidationFragment.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
