package defpackage;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.MaterialToolbar;

/* renamed from: fx  reason: default package */
/* compiled from: FragmentActiveSuperPassZoomedBinding */
public final class fx implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f1179a;
    public final ImageView b;
    public final MaterialToolbar c;

    public fx(ConstraintLayout constraintLayout, ImageView imageView, MaterialToolbar materialToolbar) {
        this.f1179a = constraintLayout;
        this.b = imageView;
        this.c = materialToolbar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1179a;
    }
}
