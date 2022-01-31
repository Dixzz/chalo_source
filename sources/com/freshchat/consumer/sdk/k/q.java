package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.j.n;

public class q extends a {
    private CalendarDay.TimeSlot qs;

    public q(Context context) {
        super(context);
    }

    public void c(CalendarDay.TimeSlot timeSlot) {
        this.qs = timeSlot;
    }

    public CalendarDay.TimeSlot il() {
        return this.qs;
    }

    public String im() {
        return this.qs != null ? n.p(getContext(), this.qs.getFromMillis()) : "";
    }
}
