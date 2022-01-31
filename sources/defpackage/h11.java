package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment;

/* renamed from: h11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class h11 implements View.OnClickListener {
    public final /* synthetic */ ActiveSuperPassQrZoomedFragment f;

    public /* synthetic */ h11(ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment) {
        this.f = activeSuperPassQrZoomedFragment;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment = this.f;
        ActiveSuperPassQrZoomedFragment.a aVar = ActiveSuperPassQrZoomedFragment.h;
        n86.e(activeSuperPassQrZoomedFragment, "this$0");
        ve activity = activeSuperPassQrZoomedFragment.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
