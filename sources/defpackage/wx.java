package defpackage;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: wx  reason: default package */
/* compiled from: HistoryScreenEmptyViewBinding */
public final class wx implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f3850a;
    public final MaterialTextView b;
    public final ConstraintLayout c;
    public final MaterialTextView d;

    public wx(ConstraintLayout constraintLayout, MaterialTextView materialTextView, ImageView imageView, ConstraintLayout constraintLayout2, MaterialTextView materialTextView2) {
        this.f3850a = constraintLayout;
        this.b = materialTextView;
        this.c = constraintLayout2;
        this.d = materialTextView2;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3850a;
    }
}
