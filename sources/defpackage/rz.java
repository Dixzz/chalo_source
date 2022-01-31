package defpackage;

import android.view.View;
import app.zophop.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.card.MaterialCardView;

/* renamed from: rz  reason: default package */
/* compiled from: YourPlansMaterialSkeletonLayoutBinding */
public final class rz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f3153a;

    public rz(MaterialCardView materialCardView, ShimmerFrameLayout shimmerFrameLayout, View view) {
        this.f3153a = materialCardView;
    }

    public static rz b(View view) {
        int i = R.id.shimmer_view_container;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view.findViewById(R.id.shimmer_view_container);
        if (shimmerFrameLayout != null) {
            i = R.id.view;
            View findViewById = view.findViewById(R.id.view);
            if (findViewById != null) {
                return new rz((MaterialCardView) view, shimmerFrameLayout, findViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3153a;
    }
}
