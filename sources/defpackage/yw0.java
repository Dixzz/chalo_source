package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import pl.droidsonroids.gif.GifImageView;

/* renamed from: yw0  reason: default package */
/* compiled from: TutorialScreenFragment.kt */
public final class yw0 extends rl0<lz> {
    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public lz e() {
        View inflate = getLayoutInflater().inflate(R.layout.tutorial_title_graphic_generic_view, (ViewGroup) null, false);
        int i = R.id.gif_image_view;
        GifImageView gifImageView = (GifImageView) inflate.findViewById(R.id.gif_image_view);
        if (gifImageView != null) {
            i = R.id.title;
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            if (textView != null) {
                lz lzVar = new lz((ConstraintLayout) inflate, gifImageView, textView);
                n86.d(lzVar, "inflate(layoutInflater)");
                return lzVar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        int i = 0;
        if (arguments != null) {
            i = arguments.getInt("screenPosition", 0);
        }
        if (i == 0) {
            T t = this.f;
            n86.c(t);
            lz lzVar = (lz) t;
            lzVar.c.setText(getString(R.string.tutorial_live_track_your_bus));
            lzVar.b.setImageResource(R.drawable.gif_onboarding_live_track);
        } else if (i == 1) {
            T t2 = this.f;
            n86.c(t2);
            lz lzVar2 = (lz) t2;
            lzVar2.c.setText(getString(R.string.tutorial_buy_pass_ticket));
            lzVar2.b.setImageResource(R.drawable.gif_onboarding_buy_tickets);
        }
    }
}
