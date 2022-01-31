package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import defpackage.wl4;
import java.util.Iterator;

/* renamed from: jm4  reason: default package */
/* compiled from: MonthsPagerAdapter */
public class jm4 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView f;
    public final /* synthetic */ km4 g;

    public jm4(km4 km4, MaterialCalendarGridView materialCalendarGridView) {
        this.g = km4;
        this.f = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        im4 a2 = this.f.getAdapter();
        if (i >= a2.b() && i <= a2.d()) {
            wl4.f fVar = this.g.d;
            long longValue = this.f.getAdapter().getItem(i).longValue();
            wl4.d dVar = (wl4.d) fVar;
            if (wl4.this.i.h.B0(longValue)) {
                wl4.this.h.d1(longValue);
                Iterator<lm4<S>> it = wl4.this.f.iterator();
                while (it.hasNext()) {
                    it.next().b(wl4.this.h.Q0());
                }
                wl4.this.n.getAdapter().notifyDataSetChanged();
                RecyclerView recyclerView = wl4.this.m;
                if (recyclerView != null) {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
