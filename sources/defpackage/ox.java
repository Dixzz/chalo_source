package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import app.zophop.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;
import pl.droidsonroids.gif.GifImageView;

/* renamed from: ox  reason: default package */
/* compiled from: FragmentSoundInfoRationaleBinding */
public final class ox implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2739a;
    public final Button b;
    public final MaterialToolbar c;

    public ox(ConstraintLayout constraintLayout, Button button, MaterialTextView materialTextView, Guideline guideline, MaterialTextView materialTextView2, Guideline guideline2, GifImageView gifImageView, MaterialToolbar materialToolbar) {
        this.f2739a = constraintLayout;
        this.b = button;
        this.c = materialToolbar;
    }

    public static ox b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sound_info_rationale, (ViewGroup) null, false);
        int i = R.id.btn_continue;
        Button button = (Button) inflate.findViewById(R.id.btn_continue);
        if (button != null) {
            i = R.id.heading;
            MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.heading);
            if (materialTextView != null) {
                i = R.id.left_guideline;
                Guideline guideline = (Guideline) inflate.findViewById(R.id.left_guideline);
                if (guideline != null) {
                    i = R.id.rationale;
                    MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.rationale);
                    if (materialTextView2 != null) {
                        i = R.id.right_guideline;
                        Guideline guideline2 = (Guideline) inflate.findViewById(R.id.right_guideline);
                        if (guideline2 != null) {
                            i = R.id.sound_info_rationale_gif;
                            GifImageView gifImageView = (GifImageView) inflate.findViewById(R.id.sound_info_rationale_gif);
                            if (gifImageView != null) {
                                i = R.id.toolbar;
                                MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                                if (materialToolbar != null) {
                                    return new ox((ConstraintLayout) inflate, button, materialTextView, guideline, materialTextView2, guideline2, gifImageView, materialToolbar);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2739a;
    }
}
