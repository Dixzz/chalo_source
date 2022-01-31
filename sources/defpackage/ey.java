package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.Barrier;
import app.zophop.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: ey  reason: default package */
/* compiled from: HomeScreenMumbaiCardBinding */
public final class ey implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f1041a;

    public ey(MaterialCardView materialCardView, Barrier barrier, MaterialTextView materialTextView, MaterialTextView materialTextView2, ShapeableImageView shapeableImageView) {
        this.f1041a = materialCardView;
    }

    public static ey b(View view) {
        int i = R.id.barrier_for_logo;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier_for_logo);
        if (barrier != null) {
            i = R.id.learn_more;
            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.learn_more);
            if (materialTextView != null) {
                i = R.id.mumbai_home_screen_card_title;
                MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.mumbai_home_screen_card_title);
                if (materialTextView2 != null) {
                    i = R.id.mumbai_logo_home_screen_card;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.mumbai_logo_home_screen_card);
                    if (shapeableImageView != null) {
                        return new ey((MaterialCardView) view, barrier, materialTextView, materialTextView2, shapeableImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1041a;
    }
}
