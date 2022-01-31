package defpackage;

import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* renamed from: ez  reason: default package */
/* compiled from: SoundFragmentSuperPassBottomSheetBinding */
public final class ez implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f1046a;
    public final ProgressBar b;
    public final MaterialTextView c;
    public final CircleImageView d;
    public final zy e;

    public ez(MaterialCardView materialCardView, ProgressBar progressBar, MaterialTextView materialTextView, CircleImageView circleImageView, zy zyVar, MaterialTextView materialTextView2) {
        this.f1046a = materialCardView;
        this.b = progressBar;
        this.c = materialTextView;
        this.d = circleImageView;
        this.e = zyVar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1046a;
    }
}
