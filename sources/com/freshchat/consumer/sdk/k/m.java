package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import java.util.ArrayList;
import java.util.List;

public class m extends a {
    private l.b qk;

    public m(Context context) {
        super(context);
    }

    public void a(l.b bVar) {
        this.qk = bVar;
    }

    public String ib() {
        l.b bVar = this.qk;
        if (bVar != null && (bVar instanceof l.a)) {
            l.a aVar = (l.a) bVar;
            if (as.a(aVar.hw())) {
                return n.I(getContext(), aVar.hw());
            }
        }
        return "";
    }

    public String ic() {
        CalendarDay.PartOfDay hy;
        l.b bVar = this.qk;
        return (bVar == null || !(bVar instanceof l.c) || (hy = ((l.c) bVar).hy()) == null) ? "" : getContext().getString(hy.getStringResId());
    }

    public List<CalendarDay.TimeSlot> id() {
        ArrayList arrayList = new ArrayList();
        l.b bVar = this.qk;
        if (bVar != null && (bVar instanceof l.c)) {
            List<CalendarDay.TimeSlot> hz = ((l.c) bVar).hz();
            if (k.a(hz)) {
                arrayList.addAll(hz);
            }
        }
        return arrayList;
    }
}
