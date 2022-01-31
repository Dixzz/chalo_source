package com.google.firebase.database.core.view;

import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EventGenerator {
    private final Index index;
    private final QuerySpec query;

    public EventGenerator(QuerySpec querySpec) {
        this.query = querySpec;
        this.index = querySpec.getIndex();
    }

    private Comparator<Change> changeComparator() {
        return new Object() {
            /* class com.google.firebase.database.core.view.EventGenerator.AnonymousClass1 */

            /* Return type fixed from 'java.util.Comparator' to match base method */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ Comparator<Change> reversed() {
                return Comparator.CC.$default$reversed(this);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(Function function) {
                return Comparator.CC.$default$thenComparing(this, function);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
                return Comparator.CC.$default$thenComparing(this, function, comparator);
            }

            /* Return type fixed from 'java.util.Comparator' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ java.util.Comparator<Change> thenComparing(java.util.Comparator<? super Change> comparator) {
                return Comparator.CC.$default$thenComparing(this, comparator);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
                return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
                return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
                return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
            }

            public int compare(Change change, Change change2) {
                Utilities.hardAssert((change.getChildKey() == null || change2.getChildKey() == null) ? false : true);
                return EventGenerator.this.index.compare(new NamedNode(change.getChildKey(), change.getIndexedNode().getNode()), new NamedNode(change2.getChildKey(), change2.getIndexedNode().getNode()));
            }
        };
    }

    private DataEvent generateEvent(Change change, EventRegistration eventRegistration, IndexedNode indexedNode) {
        if (!change.getEventType().equals(Event.EventType.VALUE) && !change.getEventType().equals(Event.EventType.CHILD_REMOVED)) {
            change = change.changeWithPrevName(indexedNode.getPredecessorChildName(change.getChildKey(), change.getIndexedNode().getNode(), this.index));
        }
        return eventRegistration.createEvent(change, this.query);
    }

    private void generateEventsForType(List<DataEvent> list, Event.EventType eventType, List<Change> list2, List<EventRegistration> list3, IndexedNode indexedNode) {
        ArrayList arrayList = new ArrayList();
        for (Change change : list2) {
            if (change.getEventType().equals(eventType)) {
                arrayList.add(change);
            }
        }
        Collections.sort(arrayList, changeComparator());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Change change2 = (Change) it.next();
            for (EventRegistration eventRegistration : list3) {
                if (eventRegistration.respondsTo(eventType)) {
                    list.add(generateEvent(change2, eventRegistration, indexedNode));
                }
            }
        }
    }

    public List<DataEvent> generateEventsForChanges(List<Change> list, IndexedNode indexedNode, List<EventRegistration> list2) {
        List<DataEvent> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (Change change : list) {
            if (change.getEventType().equals(Event.EventType.CHILD_CHANGED) && this.index.indexedValueChanged(change.getOldIndexedNode().getNode(), change.getIndexedNode().getNode())) {
                arrayList2.add(Change.childMovedChange(change.getChildKey(), change.getIndexedNode()));
            }
        }
        generateEventsForType(arrayList, Event.EventType.CHILD_REMOVED, list, list2, indexedNode);
        generateEventsForType(arrayList, Event.EventType.CHILD_ADDED, list, list2, indexedNode);
        generateEventsForType(arrayList, Event.EventType.CHILD_MOVED, arrayList2, list2, indexedNode);
        generateEventsForType(arrayList, Event.EventType.CHILD_CHANGED, list, list2, indexedNode);
        generateEventsForType(arrayList, Event.EventType.VALUE, list, list2, indexedNode);
        return arrayList;
    }
}
