package com.freshchat.consumer.sdk.m;

import android.view.View;
import com.freshchat.consumer.sdk.beans.CalendarDay;

public class v implements View.OnClickListener {
    public final /* synthetic */ t pp;

    public v(t tVar) {
        this.pp = tVar;
    }

    public void onClick(View view) {
        f hB = this.pp.hB();
        if (hB != null) {
            CalendarDay.TimeSlot ih = this.pp.pn.ih();
            int calendarType = this.pp.pn.getCalendarType();
            if (ih != null) {
                hB.a(ih, calendarType);
            }
        }
    }
}
