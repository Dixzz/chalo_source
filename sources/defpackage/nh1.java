package defpackage;

import android.view.View;

/* renamed from: nh1  reason: default package */
/* compiled from: EnvironmentChangeUtils */
public class nh1 implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener f;

    public nh1(View.OnClickListener onClickListener, int i) {
        this.f = onClickListener;
    }

    public void onClick(View view) {
        this.f.onClick(view);
    }
}
