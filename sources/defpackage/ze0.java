package defpackage;

import android.os.Bundle;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.views.summary_card.LoaderView;

/* renamed from: ze0  reason: default package */
/* compiled from: NewLoadingActivity */
public abstract class ze0 extends wt {
    public LoaderView l;

    /* renamed from: ze0$a */
    /* compiled from: NewLoadingActivity */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Bundle f;

        public a(Bundle bundle) {
            this.f = bundle;
        }

        public void onClick(View view) {
            ze0.this.l.d();
            ze0.this.h0(this.f);
        }
    }

    @Override // defpackage.tf1
    public final void e(Bundle bundle) {
        setContentView(R.layout.loading_screen);
        LoaderView loaderView = (LoaderView) findViewById(R.id.loader_view);
        this.l = loaderView;
        loaderView.setRetryHandler(new a(bundle));
        this.l.d();
        h0(bundle);
    }

    public abstract void h0(Bundle bundle);

    public final void i0() {
        this.l.setVisibility(8);
        j0();
    }

    public abstract void j0();
}
