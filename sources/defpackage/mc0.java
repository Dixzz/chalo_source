package defpackage;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.ui.activities.AlertsListActivity;

/* renamed from: mc0  reason: default package */
/* compiled from: AlertsListActivity */
public class mc0 implements Runnable {
    public final /* synthetic */ Context f;
    public final /* synthetic */ int g;
    public final /* synthetic */ AlertsListActivity h;

    /* renamed from: mc0$a */
    /* compiled from: AlertsListActivity */
    public class a extends nk {
        public a(mc0 mc0, Context context) {
            super(context);
        }

        @Override // defpackage.nk
        public int g() {
            return -1;
        }
    }

    public mc0(AlertsListActivity alertsListActivity, Context context, int i) {
        this.h = alertsListActivity;
        this.f = context;
        this.g = i;
    }

    public void run() {
        RecyclerView recyclerView = this.h.l;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            a aVar = new a(this, this.f);
            aVar.f242a = this.g;
            this.h.l.getLayoutManager().j1(aVar);
        }
    }
}
