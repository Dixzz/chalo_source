package defpackage;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import pl.droidsonroids.gif.GifImageView;

/* renamed from: lz  reason: default package */
/* compiled from: TutorialTitleGraphicGenericViewBinding */
public final class lz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2297a;
    public final GifImageView b;
    public final TextView c;

    public lz(ConstraintLayout constraintLayout, GifImageView gifImageView, TextView textView) {
        this.f2297a = constraintLayout;
        this.b = gifImageView;
        this.c = textView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2297a;
    }
}
