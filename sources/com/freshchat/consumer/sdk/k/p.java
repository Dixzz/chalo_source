package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.j.n;

public class p extends a {
    private CalendarMessageMeta calendarMessageMeta;
    private int calendarType;
    private String oY;
    public CalendarDay.TimeSlot qq;

    public p(Context context) {
        super(context);
    }

    public void b(CalendarDay.TimeSlot timeSlot) {
        this.qq = timeSlot;
    }

    public void br(String str) {
        this.oY = str;
    }

    public int getCalendarType() {
        return this.calendarType;
    }

    public String hL() {
        return this.oY;
    }

    public CalendarDay.TimeSlot ih() {
        return this.qq;
    }

    public String ii() {
        return this.qq == null ? "" : hj1.T(n.p(getContext(), this.qq.getFromMillis()), " - ", n.p(getContext(), this.qq.getToMillis()));
    }

    public String ij() {
        return this.qq == null ? "" : n.q(getContext(), this.qq.getFromMillis());
    }

    public boolean ik() {
        return e.i(getContext()).isTeamMemberInfoVisible();
    }

    public void setCalendarMessageMeta(CalendarMessageMeta calendarMessageMeta2) {
        this.calendarMessageMeta = calendarMessageMeta2;
    }

    public void setCalendarType(int i) {
        this.calendarType = i;
    }
}
