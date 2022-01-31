package defpackage;

import android.view.View;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: qz  reason: default package */
/* compiled from: YourPlansCardHomeBinding */
public final class qz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f3012a;
    public final MaterialTextView b;
    public final MaterialTextView c;
    public final CircleImageView d;

    public qz(MaterialCardView materialCardView, MaterialTextView materialTextView, MaterialTextView materialTextView2, CircleImageView circleImageView) {
        this.f3012a = materialCardView;
        this.b = materialTextView;
        this.c = materialTextView2;
        this.d = circleImageView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3012a;
    }
}
