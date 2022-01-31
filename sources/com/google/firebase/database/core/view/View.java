package com.google.firebase.database.core.view;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.ViewProcessor;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {
    private final EventGenerator eventGenerator;
    private final List<EventRegistration> eventRegistrations = new ArrayList();
    private final ViewProcessor processor;
    private final QuerySpec query;
    private ViewCache viewCache;

    public static class OperationResult {
        public final List<Change> changes;
        public final List<DataEvent> events;

        public OperationResult(List<DataEvent> list, List<Change> list2) {
            this.events = list;
            this.changes = list2;
        }
    }

    public View(QuerySpec querySpec, ViewCache viewCache2) {
        this.query = querySpec;
        IndexedFilter indexedFilter = new IndexedFilter(querySpec.getIndex());
        NodeFilter nodeFilter = querySpec.getParams().getNodeFilter();
        this.processor = new ViewProcessor(nodeFilter);
        CacheNode serverCache = viewCache2.getServerCache();
        CacheNode eventCache = viewCache2.getEventCache();
        IndexedNode from = IndexedNode.from(EmptyNode.Empty(), querySpec.getIndex());
        IndexedNode updateFullNode = indexedFilter.updateFullNode(from, serverCache.getIndexedNode(), null);
        IndexedNode updateFullNode2 = nodeFilter.updateFullNode(from, eventCache.getIndexedNode(), null);
        this.viewCache = new ViewCache(new CacheNode(updateFullNode2, eventCache.isFullyInitialized(), nodeFilter.filtersNodes()), new CacheNode(updateFullNode, serverCache.isFullyInitialized(), indexedFilter.filtersNodes()));
        this.eventGenerator = new EventGenerator(querySpec);
    }

    private List<DataEvent> generateEventsForChanges(List<Change> list, IndexedNode indexedNode, EventRegistration eventRegistration) {
        List<EventRegistration> list2;
        if (eventRegistration == null) {
            list2 = this.eventRegistrations;
        } else {
            list2 = Arrays.asList(eventRegistration);
        }
        return this.eventGenerator.generateEventsForChanges(list, indexedNode, list2);
    }

    public void addEventRegistration(@NotNull EventRegistration eventRegistration) {
        this.eventRegistrations.add(eventRegistration);
    }

    public OperationResult applyOperation(Operation operation, WriteTreeRef writeTreeRef, Node node) {
        boolean z = false;
        if (operation.getType() == Operation.OperationType.Merge && operation.getSource().getQueryParams() != null) {
            Utilities.hardAssert(this.viewCache.getCompleteServerSnap() != null, "We should always have a full cache before handling merges");
            Utilities.hardAssert(this.viewCache.getCompleteEventSnap() != null, "Missing event cache, even though we have a server cache");
        }
        ViewCache viewCache2 = this.viewCache;
        ViewProcessor.ProcessorResult applyOperation = this.processor.applyOperation(viewCache2, operation, writeTreeRef, node);
        if (applyOperation.viewCache.getServerCache().isFullyInitialized() || !viewCache2.getServerCache().isFullyInitialized()) {
            z = true;
        }
        Utilities.hardAssert(z, "Once a server snap is complete, it should never go back");
        ViewCache viewCache3 = applyOperation.viewCache;
        this.viewCache = viewCache3;
        return new OperationResult(generateEventsForChanges(applyOperation.changes, viewCache3.getEventCache().getIndexedNode(), null), applyOperation.changes);
    }

    public Node getCompleteNode() {
        return this.viewCache.getCompleteEventSnap();
    }

    public Node getCompleteServerCache(Path path) {
        Node completeServerSnap = this.viewCache.getCompleteServerSnap();
        if (completeServerSnap == null) {
            return null;
        }
        if (this.query.loadsAllData() || (!path.isEmpty() && !completeServerSnap.getImmediateChild(path.getFront()).isEmpty())) {
            return completeServerSnap.getChild(path);
        }
        return null;
    }

    public Node getEventCache() {
        return this.viewCache.getEventCache().getNode();
    }

    public List<EventRegistration> getEventRegistrations() {
        return this.eventRegistrations;
    }

    public List<DataEvent> getInitialEvents(EventRegistration eventRegistration) {
        CacheNode eventCache = this.viewCache.getEventCache();
        ArrayList arrayList = new ArrayList();
        for (NamedNode namedNode : eventCache.getNode()) {
            arrayList.add(Change.childAddedChange(namedNode.getName(), namedNode.getNode()));
        }
        if (eventCache.isFullyInitialized()) {
            arrayList.add(Change.valueChange(eventCache.getIndexedNode()));
        }
        return generateEventsForChanges(arrayList, eventCache.getIndexedNode(), eventRegistration);
    }

    public QuerySpec getQuery() {
        return this.query;
    }

    public Node getServerCache() {
        return this.viewCache.getServerCache().getNode();
    }

    public boolean isEmpty() {
        return this.eventRegistrations.isEmpty();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<com.google.firebase.database.core.view.Event>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.firebase.database.core.view.Event> removeEventRegistration(@com.google.firebase.database.annotations.Nullable com.google.firebase.database.core.EventRegistration r7, com.google.firebase.database.DatabaseError r8) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.view.View.removeEventRegistration(com.google.firebase.database.core.EventRegistration, com.google.firebase.database.DatabaseError):java.util.List");
    }
}
