package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: rm4  reason: default package */
/* compiled from: YearGridAdapter */
public class rm4 extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final wl4<?> f3100a;

    /* renamed from: rm4$a */
    /* compiled from: YearGridAdapter */
    public static class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f3101a;

        public a(TextView textView) {
            super(textView);
            this.f3101a = textView;
        }
    }

    public rm4(wl4<?> wl4) {
        this.f3100a = wl4;
    }

    public int c(int i) {
        return i - this.f3100a.i.f.h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.f3100a.i.j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        int i2 = this.f3100a.i.f.h + i;
        String string = aVar2.f3101a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        aVar2.f3101a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        aVar2.f3101a.setContentDescription(String.format(string, Integer.valueOf(i2)));
        sl4 sl4 = this.f3100a.l;
        Calendar f = pm4.f();
        rl4 rl4 = f.get(1) == i2 ? sl4.f : sl4.d;
        for (Long l : this.f3100a.h.K0()) {
            f.setTimeInMillis(l.longValue());
            if (f.get(1) == i2) {
                rl4 = sl4.e;
            }
        }
        rl4.b(aVar2.f3101a);
        aVar2.f3101a.setOnClickListener(new qm4(this, i2));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
