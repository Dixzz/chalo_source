package com.freshchat.consumer.sdk.m;

import android.os.Bundle;
import com.freshchat.consumer.sdk.a.i;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.m.a;

public class c implements i.a {
    public final /* synthetic */ b oV;

    public c(b bVar) {
        this.oV = bVar;
    }

    @Override // com.freshchat.consumer.sdk.a.i.a
    public void a(CalendarDay.TimeSlot timeSlot) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("EXTRA_CALENDAR_SELECTED_TIMESLOT", timeSlot);
        bundle.putInt("EXTRA_CALENDAR_TYPE", this.oV.getCalendarType());
        this.oV.a(a.EnumC0014a.CALENDAR_TIMESLOT_CONFIRMATION_FRAGMENT, bundle);
    }
}
