package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: a71  reason: default package */
/* compiled from: VerticalItemDecoration */
public class a71 extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    public final int f129a;

    public a71(int i) {
        this.f129a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        rect.bottom = this.f129a;
    }
}
