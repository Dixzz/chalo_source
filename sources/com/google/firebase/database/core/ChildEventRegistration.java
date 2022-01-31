package com.google.firebase.database.core;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;

public class ChildEventRegistration extends EventRegistration {
    private final ChildEventListener eventListener;
    private final Repo repo;
    private final QuerySpec spec;

    /* renamed from: com.google.firebase.database.core.ChildEventRegistration$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$core$view$Event$EventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|5|6|7|8|9|10|12) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        static {
            /*
                com.google.firebase.database.core.view.Event.EventType.values()
                r0 = 5
                int[] r0 = new int[r0]
                com.google.firebase.database.core.ChildEventRegistration.AnonymousClass1.$SwitchMap$com$google$firebase$database$core$view$Event$EventType = r0
                com.google.firebase.database.core.view.Event$EventType r1 = com.google.firebase.database.core.view.Event.EventType.CHILD_ADDED     // Catch:{ NoSuchFieldError -> 0x000d }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000d }
            L_0x000d:
                r0 = 2
                r1 = 3
                int[] r2 = com.google.firebase.database.core.ChildEventRegistration.AnonymousClass1.$SwitchMap$com$google$firebase$database$core$view$Event$EventType     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.google.firebase.database.core.view.Event$EventType r3 = com.google.firebase.database.core.view.Event.EventType.CHILD_CHANGED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r2 = com.google.firebase.database.core.ChildEventRegistration.AnonymousClass1.$SwitchMap$com$google$firebase$database$core$view$Event$EventType     // Catch:{ NoSuchFieldError -> 0x001b }
                com.google.firebase.database.core.view.Event$EventType r3 = com.google.firebase.database.core.view.Event.EventType.CHILD_MOVED     // Catch:{ NoSuchFieldError -> 0x001b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001b }
            L_0x001b:
                int[] r0 = com.google.firebase.database.core.ChildEventRegistration.AnonymousClass1.$SwitchMap$com$google$firebase$database$core$view$Event$EventType     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.google.firebase.database.core.view.Event$EventType r1 = com.google.firebase.database.core.view.Event.EventType.CHILD_REMOVED     // Catch:{ NoSuchFieldError -> 0x0023 }
                r1 = 0
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.ChildEventRegistration.AnonymousClass1.<clinit>():void");
        }
    }

    public ChildEventRegistration(@NotNull Repo repo2, @NotNull ChildEventListener childEventListener, @NotNull QuerySpec querySpec) {
        this.repo = repo2;
        this.eventListener = childEventListener;
        this.spec = querySpec;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public EventRegistration clone(QuerySpec querySpec) {
        return new ChildEventRegistration(this.repo, this.eventListener, querySpec);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public DataEvent createEvent(Change change, QuerySpec querySpec) {
        return new DataEvent(change.getEventType(), this, InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this.repo, querySpec.getPath().child(change.getChildKey())), change.getIndexedNode()), change.getPrevName() != null ? change.getPrevName().asString() : null);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChildEventRegistration) {
            ChildEventRegistration childEventRegistration = (ChildEventRegistration) obj;
            return childEventRegistration.eventListener.equals(this.eventListener) && childEventRegistration.repo.equals(this.repo) && childEventRegistration.spec.equals(this.spec);
        }
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void fireCancelEvent(DatabaseError databaseError) {
        this.eventListener.onCancelled(databaseError);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void fireEvent(DataEvent dataEvent) {
        if (!isZombied()) {
            int ordinal = dataEvent.getEventType().ordinal();
            if (ordinal == 0) {
                this.eventListener.onChildRemoved(dataEvent.getSnapshot());
            } else if (ordinal == 1) {
                this.eventListener.onChildAdded(dataEvent.getSnapshot(), dataEvent.getPreviousName());
            } else if (ordinal == 2) {
                this.eventListener.onChildMoved(dataEvent.getSnapshot(), dataEvent.getPreviousName());
            } else if (ordinal == 3) {
                this.eventListener.onChildChanged(dataEvent.getSnapshot(), dataEvent.getPreviousName());
            }
        }
    }

    @Override // com.google.firebase.database.core.EventRegistration
    @NotNull
    public QuerySpec getQuerySpec() {
        return this.spec;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public Repo getRepo() {
        return this.repo;
    }

    public int hashCode() {
        int hashCode = this.repo.hashCode();
        return this.spec.hashCode() + ((hashCode + (this.eventListener.hashCode() * 31)) * 31);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean isSameListener(EventRegistration eventRegistration) {
        return (eventRegistration instanceof ChildEventRegistration) && ((ChildEventRegistration) eventRegistration).eventListener.equals(this.eventListener);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean respondsTo(Event.EventType eventType) {
        return eventType != Event.EventType.VALUE;
    }

    public String toString() {
        return "ChildEventRegistration";
    }
}
