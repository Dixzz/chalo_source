package defpackage;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: mz  reason: default package */
/* compiled from: UniversalPassEmptyViewBinding */
public final class mz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2462a;
    public final MaterialTextView b;
    public final MaterialTextView c;

    public mz(ConstraintLayout constraintLayout, MaterialTextView materialTextView, MaterialTextView materialTextView2, ImageView imageView) {
        this.f2462a = constraintLayout;
        this.b = materialTextView;
        this.c = materialTextView2;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2462a;
    }
}
