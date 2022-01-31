package defpackage;

import android.os.Bundle;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.SkeletonLoader;
import app.zophop.ui.views.summary_card.LoaderView;

/* renamed from: pf0  reason: default package */
/* compiled from: SkeletonLoadingActivity */
public abstract class pf0 extends wt {
    public LoaderView l;
    public SkeletonLoader m;
    public String n;

    /* renamed from: pf0$a */
    /* compiled from: SkeletonLoadingActivity */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            pf0 pf0 = pf0.this;
            pf0.m.d(true, pf0.n, true);
            pf0.this.l.setVisibility(8);
            pf0.this.findViewById(R.id.toolbar).setVisibility(0);
            pf0.this.init();
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.skeleton_loading_screen);
        this.l = (LoaderView) findViewById(R.id.loader_view);
        this.m = (SkeletonLoader) findViewById(R.id.skeleton_loader);
        this.l.setRetryHandler(new a());
        this.m.d(true, this.n, true);
        this.l.setVisibility(8);
        init();
    }

    public final void h0() {
        this.m.d(false, this.n, true);
        this.l.a();
        findViewById(R.id.toolbar).setVisibility(8);
    }

    public final void i0() {
        this.l.setVisibility(8);
        this.m.a(null);
        j0();
    }

    public abstract void init();

    public abstract void j0();
}
