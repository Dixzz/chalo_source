package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: nm4  reason: default package */
/* compiled from: SmoothCalendarLayoutManager */
public class nm4 extends LinearLayoutManager {

    /* renamed from: nm4$a */
    /* compiled from: SmoothCalendarLayoutManager */
    public class a extends nk {
        public a(nm4 nm4, Context context) {
            super(context);
        }

        @Override // defpackage.nk
        public float e(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    public nm4(Context context, int i, boolean z) {
        super(i, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void i1(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.f242a = i;
        j1(aVar);
    }
}
