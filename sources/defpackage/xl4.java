package defpackage;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Objects;

/* renamed from: xl4  reason: default package */
/* compiled from: MaterialCalendar */
public class xl4 extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f3940a = pm4.g();
    public final Calendar b = pm4.g();
    public final /* synthetic */ wl4 c;

    public xl4(wl4 wl4) {
        this.c = wl4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        if ((recyclerView.getAdapter() instanceof rm4) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            rm4 rm4 = (rm4) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (u7<Long, Long> u7Var : this.c.h.E()) {
                Objects.requireNonNull(u7Var);
            }
        }
    }
}
