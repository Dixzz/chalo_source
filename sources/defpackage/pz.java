package defpackage;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: pz  reason: default package */
/* compiled from: UserDetailsLayoutBinding */
public final class pz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2871a;
    public final MaterialTextView b;
    public final MaterialTextView c;
    public final ProgressBar d;
    public final CircleImageView e;
    public final MaterialTextView f;

    public pz(ConstraintLayout constraintLayout, MaterialTextView materialTextView, MaterialTextView materialTextView2, ProgressBar progressBar, ConstraintLayout constraintLayout2, CircleImageView circleImageView, MaterialTextView materialTextView3, MaterialTextView materialTextView4) {
        this.f2871a = constraintLayout;
        this.b = materialTextView;
        this.c = materialTextView2;
        this.d = progressBar;
        this.e = circleImageView;
        this.f = materialTextView4;
    }

    public static pz b(View view) {
        int i = R.id.dob;
        MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.dob);
        if (materialTextView != null) {
            i = R.id.gender;
            MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.gender);
            if (materialTextView2 != null) {
                i = R.id.pass_profile_pic_progressbar;
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pass_profile_pic_progressbar);
                if (progressBar != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.profile_pic;
                    CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.profile_pic);
                    if (circleImageView != null) {
                        i = R.id.title;
                        MaterialTextView materialTextView3 = (MaterialTextView) view.findViewById(R.id.title);
                        if (materialTextView3 != null) {
                            i = R.id.user_name;
                            MaterialTextView materialTextView4 = (MaterialTextView) view.findViewById(R.id.user_name);
                            if (materialTextView4 != null) {
                                return new pz(constraintLayout, materialTextView, materialTextView2, progressBar, constraintLayout, circleImageView, materialTextView3, materialTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2871a;
    }
}
