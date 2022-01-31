package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class CalendarMessageMeta implements Parcelable {
    public static final Parcelable.Creator<CalendarMessageMeta> CREATOR = new Parcelable.Creator<CalendarMessageMeta>() {
        /* class com.freshchat.consumer.sdk.beans.CalendarMessageMeta.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public CalendarMessageMeta createFromParcel(Parcel parcel) {
            return new CalendarMessageMeta(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CalendarMessageMeta[] newArray(int i) {
            return new CalendarMessageMeta[i];
        }
    };
    private String calendarAgentAlias;
    private long calendarAgentId;
    private String calendarBookingEmail;
    private String calendarEventLink;
    private String calendarInviteId;
    private long calendarSenderId;
    private boolean retryCalendarEvent;

    public CalendarMessageMeta() {
    }

    public CalendarMessageMeta(Parcel parcel) {
        this.calendarSenderId = parcel.readLong();
        this.calendarAgentId = parcel.readLong();
        this.calendarAgentAlias = parcel.readString();
        this.calendarInviteId = parcel.readString();
        this.retryCalendarEvent = parcel.readByte() != 0;
        this.calendarBookingEmail = parcel.readString();
        this.calendarEventLink = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCalendarAgentAlias() {
        return this.calendarAgentAlias;
    }

    public long getCalendarAgentId() {
        return this.calendarAgentId;
    }

    public String getCalendarBookingEmail() {
        return this.calendarBookingEmail;
    }

    public String getCalendarEventLink() {
        return this.calendarEventLink;
    }

    public String getCalendarInviteId() {
        return this.calendarInviteId;
    }

    public long getCalendarSenderId() {
        return this.calendarSenderId;
    }

    public boolean isRetryCalendarEvent() {
        return this.retryCalendarEvent;
    }

    public void setCalendarAgentAlias(String str) {
        this.calendarAgentAlias = str;
    }

    public void setCalendarAgentId(long j) {
        this.calendarAgentId = j;
    }

    public void setCalendarBookingEmail(String str) {
        this.calendarBookingEmail = str;
    }

    public void setCalendarEventLink(String str) {
        this.calendarEventLink = str;
    }

    public void setCalendarInviteId(String str) {
        this.calendarInviteId = str;
    }

    public void setCalendarSenderId(long j) {
        this.calendarSenderId = j;
    }

    public void setRetryCalendarEvent(boolean z) {
        this.retryCalendarEvent = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CalendarMessageMeta{");
        sb.append("calendarSenderId=");
        sb.append(this.calendarSenderId);
        sb.append("calendarAgentId = ");
        sb.append(this.calendarSenderId);
        sb.append(", calendarAgentAlias='");
        hj1.U0(sb, this.calendarAgentAlias, '\'', ", calendarInviteId='");
        hj1.U0(sb, this.calendarInviteId, '\'', ", retryCalendarEvent=");
        sb.append(this.retryCalendarEvent);
        sb.append(", calendarBookingEmail=");
        sb.append(this.calendarBookingEmail);
        sb.append(", calendarEventLink=");
        return hj1.Z(sb, this.calendarEventLink, '}');
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.calendarSenderId);
        parcel.writeLong(this.calendarAgentId);
        parcel.writeString(this.calendarAgentAlias);
        parcel.writeString(this.calendarInviteId);
        parcel.writeByte(this.retryCalendarEvent ? (byte) 1 : 0);
        parcel.writeString(this.calendarBookingEmail);
        parcel.writeString(this.calendarEventLink);
    }
}
