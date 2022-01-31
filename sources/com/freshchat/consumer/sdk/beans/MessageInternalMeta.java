package com.freshchat.consumer.sdk.beans;

public class MessageInternalMeta {
    private CalendarMessageMeta calendarMessageMeta;

    public CalendarMessageMeta getCalendarMessageMeta() {
        return this.calendarMessageMeta;
    }

    public void setCalendarMessageMeta(CalendarMessageMeta calendarMessageMeta2) {
        this.calendarMessageMeta = calendarMessageMeta2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MessageInternalMeta{calendarMessageMeta = ");
        i0.append(this.calendarMessageMeta);
        i0.append('}');
        return i0.toString();
    }
}
