package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.ui.activities.ActivePassScreen;

/* renamed from: ec0  reason: default package */
/* compiled from: ActivePassScreen */
public class ec0 implements View.OnClickListener {
    public final ImageView f;
    public final /* synthetic */ ImageView g;
    public final /* synthetic */ ActivePassScreen h;

    public ec0(ActivePassScreen activePassScreen, ImageView imageView) {
        this.h = activePassScreen;
        this.g = imageView;
        this.f = imageView;
    }

    public void onClick(View view) {
        ActivePassScreen activePassScreen = this.h;
        activePassScreen.setContentView(activePassScreen.A);
        ImageView imageView = (ImageView) this.h.A.findViewById(R.id.qr_code_zoomed);
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView.setImageDrawable(imageView2.getDrawable());
        } else {
            imageView.setImageDrawable(((ImageView) view).getDrawable());
        }
        imageView.startAnimation(this.h.k);
        this.h.h0(imageView, true);
        this.h.i0();
        this.h.k0(1.0f);
        this.h.m = true;
        ed1 ed1 = new ed1("mpass qr code zoomed", Long.MIN_VALUE);
        ed1.a("date", jh1.c(ui1.Q()));
        ed1.a("time", jh1.g(ui1.Q()));
        jz5.b().g(ed1);
    }
}
