package com.google.firebase.database.core.view;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.view.Event;

public class DataEvent implements Event {
    private final EventRegistration eventRegistration;
    private final Event.EventType eventType;
    private final String prevName;
    private final DataSnapshot snapshot;

    public DataEvent(Event.EventType eventType2, EventRegistration eventRegistration2, DataSnapshot dataSnapshot, String str) {
        this.eventType = eventType2;
        this.eventRegistration = eventRegistration2;
        this.snapshot = dataSnapshot;
        this.prevName = str;
    }

    @Override // com.google.firebase.database.core.view.Event
    public void fire() {
        this.eventRegistration.fireEvent(this);
    }

    public Event.EventType getEventType() {
        return this.eventType;
    }

    @Override // com.google.firebase.database.core.view.Event
    public Path getPath() {
        Path path = this.snapshot.getRef().getPath();
        if (this.eventType == Event.EventType.VALUE) {
            return path;
        }
        return path.getParent();
    }

    public String getPreviousName() {
        return this.prevName;
    }

    public DataSnapshot getSnapshot() {
        return this.snapshot;
    }

    @Override // com.google.firebase.database.core.view.Event
    public String toString() {
        if (this.eventType == Event.EventType.VALUE) {
            return getPath() + ": " + this.eventType + ": " + this.snapshot.getValue(true);
        }
        return getPath() + ": " + this.eventType + ": { " + this.snapshot.getKey() + ": " + this.snapshot.getValue(true) + " }";
    }
}
