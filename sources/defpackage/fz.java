package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import com.google.android.material.textview.MaterialTextView;
import pl.droidsonroids.gif.GifImageView;

/* renamed from: fz  reason: default package */
/* compiled from: SoundInfoFragmentBinding */
public final class fz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f1189a;
    public final Button b;

    public fz(ConstraintLayout constraintLayout, Button button, GifImageView gifImageView, MaterialTextView materialTextView) {
        this.f1189a = constraintLayout;
        this.b = button;
    }

    public static fz b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.sound_info_fragment, (ViewGroup) null, false);
        int i = R.id.btn_got_it;
        Button button = (Button) inflate.findViewById(R.id.btn_got_it);
        if (button != null) {
            i = R.id.sound_info_gif;
            GifImageView gifImageView = (GifImageView) inflate.findViewById(R.id.sound_info_gif);
            if (gifImageView != null) {
                i = R.id.sound_info_title;
                MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.sound_info_title);
                if (materialTextView != null) {
                    return new fz((ConstraintLayout) inflate, button, gifImageView, materialTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1189a;
    }
}
