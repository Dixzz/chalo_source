package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: vk  reason: default package */
/* compiled from: PagerSnapHelper */
public class vk extends nk {
    public final /* synthetic */ wk q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public vk(wk wkVar, Context context) {
        super(context);
        this.q = wkVar;
    }

    @Override // defpackage.nk, androidx.recyclerview.widget.RecyclerView.w
    public void b(View view, RecyclerView.x xVar, RecyclerView.w.a aVar) {
        wk wkVar = this.q;
        int[] b = wkVar.b(wkVar.f446a.getLayoutManager(), view);
        int i = b[0];
        int i2 = b[1];
        int ceil = (int) Math.ceil(((double) f(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (ceil > 0) {
            aVar.b(i, i2, ceil, this.j);
        }
    }

    @Override // defpackage.nk
    public float e(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }

    @Override // defpackage.nk
    public int f(int i) {
        return Math.min(100, super.f(i));
    }
}
