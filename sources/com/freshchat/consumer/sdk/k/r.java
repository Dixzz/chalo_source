package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.l.c;
import com.freshchat.consumer.sdk.service.Status;
import com.freshchat.consumer.sdk.service.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class r extends a {
    private CalendarMessageMeta calendarMessageMeta;
    private final c rt = new c();
    private AgentAvailabilityResponse ru;
    private List<l.b> rv;

    public r(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public void b(com.freshchat.consumer.sdk.service.c<List<l.b>> cVar) {
        cVar.b(new b<>(Status.SUCCESS, this.rv));
    }

    /* access modifiers changed from: private */
    public void c(com.freshchat.consumer.sdk.service.c<List<l.b>> cVar) {
        cVar.b(new b<>(Status.ERROR, null));
    }

    /* access modifiers changed from: private */
    public List<l.b> jq() {
        ArrayList arrayList = new ArrayList();
        AgentAvailabilityResponse agentAvailabilityResponse = this.ru;
        if (agentAvailabilityResponse == null) {
            return arrayList;
        }
        Map<String, CalendarDay> processedCalendarDataMap = agentAvailabilityResponse.getProcessedCalendarDataMap();
        if (k.c(processedCalendarDataMap)) {
            return arrayList;
        }
        CalendarDay next = processedCalendarDataMap.values().iterator().next();
        arrayList.add(new l.a(next.getDay()));
        int i = 0;
        for (Map.Entry<CalendarDay.PartOfDay, List<CalendarDay.TimeSlot>> entry : next.getTimeSlotsMap().entrySet()) {
            if (i >= 8) {
                break;
            }
            List<CalendarDay.TimeSlot> value = entry.getValue();
            int b = k.b(value);
            if (b > 0) {
                Collections.sort(value);
                if (b + i > 8) {
                    value = value.subList(0, 8 - i);
                }
                i += value.size();
            }
            arrayList.add(new l.c(entry.getKey(), value));
        }
        return arrayList;
    }

    public void a(com.freshchat.consumer.sdk.service.c<List<l.b>> cVar) {
        if (this.rv != null) {
            b(cVar);
        }
        CalendarMessageMeta calendarMessageMeta2 = this.calendarMessageMeta;
        if (calendarMessageMeta2 == null) {
            c(cVar);
            return;
        }
        this.rt.a(getContext(), calendarMessageMeta2.getCalendarAgentAlias(), new s(this, cVar));
    }

    public int getCalendarType() {
        AgentAvailabilityResponse agentAvailabilityResponse = this.ru;
        if (agentAvailabilityResponse == null) {
            return 0;
        }
        return agentAvailabilityResponse.getCalendarType();
    }

    public String ia() {
        try {
            AgentAvailabilityResponse agentAvailabilityResponse = this.ru;
            if (agentAvailabilityResponse == null || agentAvailabilityResponse.getMeetingLength() <= 0) {
                return "";
            }
            return getContext().getString(R.string.freshchat_calendar_duration).replace(getContext().getString(R.string.freshchat_calendar_duration_place_holder), String.valueOf(((long) this.ru.getMeetingLength()) / 60));
        } catch (Exception e) {
            q.a(e);
            return "";
        }
    }

    public ArrayList<l.b> jp() {
        ArrayList<l.b> arrayList = new ArrayList<>();
        AgentAvailabilityResponse agentAvailabilityResponse = this.ru;
        if (agentAvailabilityResponse == null) {
            return arrayList;
        }
        Map<String, CalendarDay> processedCalendarDataMap = agentAvailabilityResponse.getProcessedCalendarDataMap();
        if (k.d(processedCalendarDataMap)) {
            for (CalendarDay calendarDay : processedCalendarDataMap.values()) {
                arrayList.add(new l.a(calendarDay.getDay()));
                for (Map.Entry<CalendarDay.PartOfDay, List<CalendarDay.TimeSlot>> entry : calendarDay.getTimeSlotsMap().entrySet()) {
                    Collections.sort(entry.getValue());
                    arrayList.add(new l.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public void jr() {
        CalendarMessageMeta calendarMessageMeta2 = this.calendarMessageMeta;
        String calendarInviteId = calendarMessageMeta2 != null ? calendarMessageMeta2.getCalendarInviteId() : null;
        if (as.a(calendarInviteId)) {
            bg.L(getContext(), calendarInviteId);
        }
    }

    public void setCalendarMessageMeta(CalendarMessageMeta calendarMessageMeta2) {
        this.calendarMessageMeta = calendarMessageMeta2;
    }
}
