package com.freshchat.consumer.sdk.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.k.q;
import java.util.List;

public class i extends BaseAdapter {
    private final List<CalendarDay.TimeSlot> ow;
    private final a ox;

    public interface a {
        void a(CalendarDay.TimeSlot timeSlot);
    }

    public class b {
        private final TextView oy;

        private b(View view) {
            this.oy = (TextView) view;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(q qVar) {
            this.oy.setText(qVar.im());
            this.oy.setOnClickListener(new k(this, qVar));
        }
    }

    public i(List<CalendarDay.TimeSlot> list, a aVar) {
        this.ow = list;
        this.ox = aVar;
    }

    /* renamed from: a */
    public CalendarDay.TimeSlot getItem(int i) {
        if (k.isEmpty(this.ow)) {
            return null;
        }
        return this.ow.get(i);
    }

    public int getCount() {
        return k.b(this.ow);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freshchat_calendar_timeslot_view, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        CalendarDay.TimeSlot a2 = getItem(i);
        if (!(bVar == null || a2 == null)) {
            q qVar = new q(viewGroup.getContext());
            qVar.c(a2);
            bVar.a(qVar);
        }
        return view;
    }
}
