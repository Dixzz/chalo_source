package app.zophop.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import app.zophop.R;

/* compiled from: LanguageSelectionActivity.kt */
public final class LanguageSelectionActivity extends f0 {
    @Override // defpackage.f0
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context == null ? null : j26.c.a(context));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_language_selection, (ViewGroup) null, false);
        if (((FragmentContainerView) inflate.findViewById(R.id.nav_host_fragment)) != null) {
            setContentView((ConstraintLayout) inflate);
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.nav_host_fragment)));
    }
}
