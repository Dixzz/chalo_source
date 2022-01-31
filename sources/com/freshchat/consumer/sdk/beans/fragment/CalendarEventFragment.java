package com.freshchat.consumer.sdk.beans.fragment;

import java.util.Set;

public class CalendarEventFragment extends MessageFragment {
    private long endMillis;
    private String eventId;
    private int eventProviderType;
    private Set<Long> participantIds;
    private long startMillis;
    private String userTimeZone;

    public CalendarEventFragment() {
        super(FragmentType.CALENDAR_EVENT.asInt());
    }

    public long getEndMillis() {
        return this.endMillis;
    }

    public String getEventId() {
        return this.eventId;
    }

    public int getEventProviderType() {
        return this.eventProviderType;
    }

    public Set<Long> getParticipantIds() {
        return this.participantIds;
    }

    public long getStartMillis() {
        return this.startMillis;
    }

    public String getUserTimeZone() {
        return this.userTimeZone;
    }

    public void setEndMillis(long j) {
        this.endMillis = j;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventProviderType(int i) {
        this.eventProviderType = i;
    }

    public void setParticipantIds(Set<Long> set) {
        this.participantIds = set;
    }

    public void setStartMillis(long j) {
        this.startMillis = j;
    }

    public void setUserTimeZone(String str) {
        this.userTimeZone = str;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("CalendarEventFragment{eventId='");
        hj1.U0(i0, this.eventId, '\'', ", eventProviderType=");
        i0.append(this.eventProviderType);
        i0.append(", startMillis=");
        i0.append(this.startMillis);
        i0.append(", endMillis=");
        i0.append(this.endMillis);
        i0.append(", userTimeZone='");
        hj1.U0(i0, this.userTimeZone, '\'', ", participantIds=");
        i0.append(this.participantIds);
        i0.append('}');
        return i0.toString();
    }
}
