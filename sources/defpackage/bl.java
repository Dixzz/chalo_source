package defpackage;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: bl  reason: default package */
/* compiled from: SnapHelper */
public abstract class bl extends RecyclerView.p {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f446a;
    public final RecyclerView.r b = new a();

    /* renamed from: bl$a */
    /* compiled from: SnapHelper */
    public class a extends RecyclerView.r {

        /* renamed from: a  reason: collision with root package name */
        public boolean f447a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f447a) {
                this.f447a = false;
                bl.this.d();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f447a = true;
            }
        }
    }

    public void a(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f446a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                RecyclerView.r rVar = this.b;
                List<RecyclerView.r> list = recyclerView2.p0;
                if (list != null) {
                    list.remove(rVar);
                }
                this.f446a.setOnFlingListener(null);
            }
            this.f446a = recyclerView;
            if (recyclerView == null) {
                return;
            }
            if (recyclerView.getOnFlingListener() == null) {
                this.f446a.g(this.b);
                this.f446a.setOnFlingListener(this);
                new Scroller(this.f446a.getContext(), new DecelerateInterpolator());
                d();
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    public abstract int[] b(RecyclerView.m mVar, View view);

    public abstract View c(RecyclerView.m mVar);

    public void d() {
        RecyclerView.m layoutManager;
        View c;
        RecyclerView recyclerView = this.f446a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (c = c(layoutManager)) != null) {
            int[] b2 = b(layoutManager, c);
            if (b2[0] != 0 || b2[1] != 0) {
                this.f446a.k0(b2[0], b2[1], null, RtlSpacingHelper.UNDEFINED, false);
            }
        }
    }
}
