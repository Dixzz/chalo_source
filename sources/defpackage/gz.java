package defpackage;

import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: gz  reason: default package */
/* compiled from: SoundVerificationFragmentSuperPassBinding */
public final class gz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f1318a;
    public final Button b;
    public final MaterialTextView c;
    public final ShapeableImageView d;
    public final MaterialToolbar e;

    public gz(ConstraintLayout constraintLayout, Button button, MaterialTextView materialTextView, ShapeableImageView shapeableImageView, MaterialToolbar materialToolbar) {
        this.f1318a = constraintLayout;
        this.b = button;
        this.c = materialTextView;
        this.d = shapeableImageView;
        this.e = materialToolbar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1318a;
    }
}
