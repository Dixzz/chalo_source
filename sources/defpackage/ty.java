package defpackage;

import android.view.View;
import android.widget.ImageView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: ty  reason: default package */
/* compiled from: ProductHomeScreenBinding */
public final class ty implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f3419a;
    public final ImageView b;
    public final MaterialTextView c;

    public ty(MaterialCardView materialCardView, ImageView imageView, MaterialTextView materialTextView) {
        this.f3419a = materialCardView;
        this.b = imageView;
        this.c = materialTextView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3419a;
    }
}
