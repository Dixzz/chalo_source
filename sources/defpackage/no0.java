package defpackage;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import app.zophop.ui.fragments.CitySelectionFragment;

/* renamed from: no0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class no0 implements View.OnClickListener {
    public final /* synthetic */ CitySelectionFragment f;

    public /* synthetic */ no0(CitySelectionFragment citySelectionFragment) {
        this.f = citySelectionFragment;
    }

    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        CitySelectionFragment citySelectionFragment = this.f;
        int i = CitySelectionFragment.k;
        n86.e(citySelectionFragment, "this$0");
        ve activity = citySelectionFragment.c();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.b();
        }
    }
}
