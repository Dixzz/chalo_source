package com.freshchat.consumer.sdk.beans;

public class CalendarTimeSlot {
    private long from;
    private int id;
    private int prevTo;
    private long to;

    public long getFrom() {
        return this.from;
    }

    public int getId() {
        return this.id;
    }

    public int getPrevTo() {
        return this.prevTo;
    }

    public long getTo() {
        return this.to;
    }

    public void setFrom(long j) {
        this.from = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setPrevTo(int i) {
        this.prevTo = i;
    }

    public void setTo(long j) {
        this.to = j;
    }
}
