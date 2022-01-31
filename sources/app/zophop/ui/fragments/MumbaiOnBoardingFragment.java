package app.zophop.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import kotlinx.coroutines.CoroutineExceptionHandler;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: MumbaiOnBoardingFragment.kt */
public final class MumbaiOnBoardingFragment extends rl0<nx> {
    public static final a g = new a(null);

    /* compiled from: MumbaiOnBoardingFragment.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public nx e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_mumbai_on_boarding, (ViewGroup) null, false);
        int i = R.id.footer_bus_anim;
        GifImageView gifImageView = (GifImageView) inflate.findViewById(R.id.footer_bus_anim);
        if (gifImageView != null) {
            i = R.id.mumbai_logo_on_boarding;
            ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(R.id.mumbai_logo_on_boarding);
            if (shapeableImageView != null) {
                i = R.id.mumbai_on_boarding_text;
                MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.mumbai_on_boarding_text);
                if (materialTextView != null) {
                    nx nxVar = new nx((ConstraintLayout) inflate, gifImageView, shapeableImageView, materialTextView);
                    n86.d(nxVar, "inflate(layoutInflater)");
                    return nxVar;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        hj1.R0("mumbai on boarding screen open", "lName", "mumbai on boarding fragment", "lSource", "mumbai on boarding screen open", Long.MIN_VALUE, "source", "mumbai on boarding fragment");
        ah b = wg.b(this);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new hv0(this, null), 2, null);
    }
}
