package defpackage;

import android.view.View;
import android.widget.ImageView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: xy  reason: default package */
/* compiled from: RecentCardHomeBinding */
public final class xy implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f3977a;
    public final MaterialTextView b;
    public final ImageView c;
    public final MaterialTextView d;

    public xy(MaterialCardView materialCardView, MaterialTextView materialTextView, ImageView imageView, MaterialTextView materialTextView2) {
        this.f3977a = materialCardView;
        this.b = materialTextView;
        this.c = imageView;
        this.d = materialTextView2;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3977a;
    }
}
