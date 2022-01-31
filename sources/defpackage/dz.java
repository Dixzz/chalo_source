package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: dz  reason: default package */
/* compiled from: SoundFragmentSuperPassBinding */
public final class dz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f905a;
    public final ez b;
    public final MaterialTextView c;
    public final MaterialTextView d;
    public final ShapeableImageView e;
    public final MaterialToolbar f;

    public dz(ConstraintLayout constraintLayout, ez ezVar, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3, ShapeableImageView shapeableImageView, MaterialToolbar materialToolbar) {
        this.f905a = constraintLayout;
        this.b = ezVar;
        this.c = materialTextView;
        this.d = materialTextView3;
        this.e = shapeableImageView;
        this.f = materialToolbar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f905a;
    }
}
