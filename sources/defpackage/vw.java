package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: vw  reason: default package */
/* compiled from: CityViewBinding */
public final class vw implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f3686a;
    public final View b;
    public final TextView c;
    public final ImageView d;

    public vw(RelativeLayout relativeLayout, View view, TextView textView, ImageView imageView) {
        this.f3686a = relativeLayout;
        this.b = view;
        this.c = textView;
        this.d = imageView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3686a;
    }
}
