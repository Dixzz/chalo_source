package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: ay  reason: default package */
/* compiled from: HomeScreenHeadingBinding */
public final class ay implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f346a;
    public final MaterialTextView b;

    public ay(ConstraintLayout constraintLayout, MaterialTextView materialTextView, ConstraintLayout constraintLayout2) {
        this.f346a = constraintLayout;
        this.b = materialTextView;
    }

    public static ay b(View view) {
        MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.home_screen_heading);
        if (materialTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new ay(constraintLayout, materialTextView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.home_screen_heading)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f346a;
    }
}
