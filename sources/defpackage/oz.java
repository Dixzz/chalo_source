package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: oz  reason: default package */
/* compiled from: UniversalPassInfoItemBinding */
public final class oz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f2746a;
    public final MaterialTextView b;
    public final MaterialTextView c;

    public oz(MaterialCardView materialCardView, MaterialTextView materialTextView, ConstraintLayout constraintLayout, MaterialTextView materialTextView2) {
        this.f2746a = materialCardView;
        this.b = materialTextView;
        this.c = materialTextView2;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2746a;
    }
}
