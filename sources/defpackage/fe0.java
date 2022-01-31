package defpackage;

import android.os.Bundle;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.views.summary_card.LoaderView;

/* renamed from: fe0  reason: default package */
/* compiled from: LoadingActivity */
public abstract class fe0 extends wt {
    public LoaderView l;

    /* renamed from: fe0$a */
    /* compiled from: LoadingActivity */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            fe0.this.l.d();
            fe0.this.init();
        }
    }

    @Override // defpackage.tf1
    public final void e(Bundle bundle) {
        setContentView(R.layout.loading_screen);
        LoaderView loaderView = (LoaderView) findViewById(R.id.loader_view);
        this.l = loaderView;
        loaderView.setRetryHandler(new a());
        this.l.d();
        init();
    }

    public final void h0() {
        jz5.b().o(this);
        this.l.a();
    }

    public final void i0() {
        this.l.setVisibility(8);
        j0();
    }

    public abstract void init();

    public abstract void j0();
}
