package defpackage;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: vy  reason: default package */
/* compiled from: ProofDocumentItemBinding */
public final class vy implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f3691a;
    public final CircleImageView b;
    public final TextView c;

    public vy(ConstraintLayout constraintLayout, CircleImageView circleImageView, TextView textView) {
        this.f3691a = constraintLayout;
        this.b = circleImageView;
        this.c = textView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3691a;
    }
}
