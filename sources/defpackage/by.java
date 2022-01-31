package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: by  reason: default package */
/* compiled from: HomeScreenHeadingWithSeeMoreBinding */
public final class by implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f489a;
    public final MaterialTextView b;
    public final ConstraintLayout c;
    public final MaterialTextView d;

    public by(ConstraintLayout constraintLayout, MaterialTextView materialTextView, ConstraintLayout constraintLayout2, MaterialTextView materialTextView2) {
        this.f489a = constraintLayout;
        this.b = materialTextView;
        this.c = constraintLayout2;
        this.d = materialTextView2;
    }

    public static by b(View view) {
        int i = R.id.home_screen_heading;
        MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.home_screen_heading);
        if (materialTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.see_more);
            if (materialTextView2 != null) {
                return new by(constraintLayout, materialTextView, constraintLayout, materialTextView2);
            }
            i = R.id.see_more;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f489a;
    }
}
