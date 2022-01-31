package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrackedQueryManager {
    private static final Predicate<Map<QueryParams, TrackedQuery>> HAS_ACTIVE_DEFAULT_PREDICATE = new Predicate<Map<QueryParams, TrackedQuery>>() {
        /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass2 */

        public boolean evaluate(Map<QueryParams, TrackedQuery> map) {
            TrackedQuery trackedQuery = map.get(QueryParams.DEFAULT_PARAMS);
            return trackedQuery != null && trackedQuery.active;
        }
    };
    private static final Predicate<Map<QueryParams, TrackedQuery>> HAS_DEFAULT_COMPLETE_PREDICATE = new Predicate<Map<QueryParams, TrackedQuery>>() {
        /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass1 */

        public boolean evaluate(Map<QueryParams, TrackedQuery> map) {
            TrackedQuery trackedQuery = map.get(QueryParams.DEFAULT_PARAMS);
            return trackedQuery != null && trackedQuery.complete;
        }
    };
    private static final Predicate<TrackedQuery> IS_QUERY_PRUNABLE_PREDICATE = new Predicate<TrackedQuery>() {
        /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass3 */

        public boolean evaluate(TrackedQuery trackedQuery) {
            return !trackedQuery.active;
        }
    };
    private static final Predicate<TrackedQuery> IS_QUERY_UNPRUNABLE_PREDICATE = new Predicate<TrackedQuery>() {
        /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass4 */

        public boolean evaluate(TrackedQuery trackedQuery) {
            return !TrackedQueryManager.IS_QUERY_PRUNABLE_PREDICATE.evaluate(trackedQuery);
        }
    };
    private final Clock clock;
    private long currentQueryId = 0;
    private final LogWrapper logger;
    private final PersistenceStorageEngine storageLayer;
    private ImmutableTree<Map<QueryParams, TrackedQuery>> trackedQueryTree;

    public TrackedQueryManager(PersistenceStorageEngine persistenceStorageEngine, LogWrapper logWrapper, Clock clock2) {
        this.storageLayer = persistenceStorageEngine;
        this.logger = logWrapper;
        this.clock = clock2;
        this.trackedQueryTree = new ImmutableTree<>(null);
        resetPreviouslyActiveTrackedQueries();
        for (TrackedQuery trackedQuery : persistenceStorageEngine.loadTrackedQueries()) {
            this.currentQueryId = Math.max(trackedQuery.id + 1, this.currentQueryId);
            cacheTrackedQuery(trackedQuery);
        }
    }

    private static void assertValidTrackedQuery(QuerySpec querySpec) {
        Utilities.hardAssert(!querySpec.loadsAllData() || querySpec.isDefault(), "Can't have tracked non-default query that loads all data");
    }

    private void cacheTrackedQuery(TrackedQuery trackedQuery) {
        assertValidTrackedQuery(trackedQuery.querySpec);
        Map<QueryParams, TrackedQuery> map = this.trackedQueryTree.get(trackedQuery.querySpec.getPath());
        if (map == null) {
            map = new HashMap<>();
            this.trackedQueryTree = this.trackedQueryTree.set(trackedQuery.querySpec.getPath(), map);
        }
        TrackedQuery trackedQuery2 = map.get(trackedQuery.querySpec.getParams());
        Utilities.hardAssert(trackedQuery2 == null || trackedQuery2.id == trackedQuery.id);
        map.put(trackedQuery.querySpec.getParams(), trackedQuery);
    }

    private static long calculateCountToPrune(CachePolicy cachePolicy, long j) {
        return j - Math.min((long) Math.floor((double) (((float) j) * (1.0f - cachePolicy.getPercentOfQueriesToPruneAtOnce()))), cachePolicy.getMaxNumberOfQueriesToKeep());
    }

    private Set<Long> filteredQueryIdsAtPath(Path path) {
        HashSet hashSet = new HashSet();
        Map<QueryParams, TrackedQuery> map = this.trackedQueryTree.get(path);
        if (map != null) {
            for (TrackedQuery trackedQuery : map.values()) {
                if (!trackedQuery.querySpec.loadsAllData()) {
                    hashSet.add(Long.valueOf(trackedQuery.id));
                }
            }
        }
        return hashSet;
    }

    private List<TrackedQuery> getQueriesMatching(Predicate<TrackedQuery> predicate) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Path, Map<QueryParams, TrackedQuery>>> it = this.trackedQueryTree.iterator();
        while (it.hasNext()) {
            for (TrackedQuery trackedQuery : it.next().getValue().values()) {
                if (predicate.evaluate(trackedQuery)) {
                    arrayList.add(trackedQuery);
                }
            }
        }
        return arrayList;
    }

    private boolean includedInDefaultCompleteQuery(Path path) {
        return this.trackedQueryTree.findRootMostMatchingPath(path, HAS_DEFAULT_COMPLETE_PREDICATE) != null;
    }

    private static QuerySpec normalizeQuery(QuerySpec querySpec) {
        return querySpec.loadsAllData() ? QuerySpec.defaultQueryAtPath(querySpec.getPath()) : querySpec;
    }

    private void resetPreviouslyActiveTrackedQueries() {
        try {
            this.storageLayer.beginTransaction();
            this.storageLayer.resetPreviouslyActiveTrackedQueries(this.clock.millis());
            this.storageLayer.setTransactionSuccessful();
        } finally {
            this.storageLayer.endTransaction();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveTrackedQuery(TrackedQuery trackedQuery) {
        cacheTrackedQuery(trackedQuery);
        this.storageLayer.saveTrackedQuery(trackedQuery);
    }

    private void setQueryActiveFlag(QuerySpec querySpec, boolean z) {
        TrackedQuery trackedQuery;
        QuerySpec normalizeQuery = normalizeQuery(querySpec);
        TrackedQuery findTrackedQuery = findTrackedQuery(normalizeQuery);
        long millis = this.clock.millis();
        if (findTrackedQuery != null) {
            trackedQuery = findTrackedQuery.updateLastUse(millis).setActiveState(z);
        } else {
            Utilities.hardAssert(z, "If we're setting the query to inactive, we should already be tracking it!");
            long j = this.currentQueryId;
            this.currentQueryId = 1 + j;
            trackedQuery = new TrackedQuery(j, normalizeQuery, millis, false, z);
        }
        saveTrackedQuery(trackedQuery);
    }

    public long countOfPrunableQueries() {
        return (long) getQueriesMatching(IS_QUERY_PRUNABLE_PREDICATE).size();
    }

    public void ensureCompleteTrackedQuery(Path path) {
        TrackedQuery trackedQuery;
        if (!includedInDefaultCompleteQuery(path)) {
            QuerySpec defaultQueryAtPath = QuerySpec.defaultQueryAtPath(path);
            TrackedQuery findTrackedQuery = findTrackedQuery(defaultQueryAtPath);
            if (findTrackedQuery == null) {
                long j = this.currentQueryId;
                this.currentQueryId = 1 + j;
                trackedQuery = new TrackedQuery(j, defaultQueryAtPath, this.clock.millis(), true, false);
            } else {
                Utilities.hardAssert(!findTrackedQuery.complete, "This should have been handled above!");
                trackedQuery = findTrackedQuery.setComplete();
            }
            saveTrackedQuery(trackedQuery);
        }
    }

    public TrackedQuery findTrackedQuery(QuerySpec querySpec) {
        QuerySpec normalizeQuery = normalizeQuery(querySpec);
        Map<QueryParams, TrackedQuery> map = this.trackedQueryTree.get(normalizeQuery.getPath());
        if (map != null) {
            return map.get(normalizeQuery.getParams());
        }
        return null;
    }

    public Set<ChildKey> getKnownCompleteChildren(Path path) {
        Utilities.hardAssert(!isQueryComplete(QuerySpec.defaultQueryAtPath(path)), "Path is fully complete.");
        HashSet hashSet = new HashSet();
        Set<Long> filteredQueryIdsAtPath = filteredQueryIdsAtPath(path);
        if (!filteredQueryIdsAtPath.isEmpty()) {
            hashSet.addAll(this.storageLayer.loadTrackedQueryKeys(filteredQueryIdsAtPath));
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<Map<QueryParams, TrackedQuery>>>> it = this.trackedQueryTree.subtree(path).getChildren().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Map<QueryParams, TrackedQuery>>> next = it.next();
            ChildKey key = next.getKey();
            ImmutableTree<Map<QueryParams, TrackedQuery>> value = next.getValue();
            if (value.getValue() != null && HAS_DEFAULT_COMPLETE_PREDICATE.evaluate(value.getValue())) {
                hashSet.add(key);
            }
        }
        return hashSet;
    }

    public boolean hasActiveDefaultQuery(Path path) {
        return this.trackedQueryTree.rootMostValueMatching(path, HAS_ACTIVE_DEFAULT_PREDICATE) != null;
    }

    public boolean isQueryComplete(QuerySpec querySpec) {
        Map<QueryParams, TrackedQuery> map;
        if (includedInDefaultCompleteQuery(querySpec.getPath())) {
            return true;
        }
        if (!querySpec.loadsAllData() && (map = this.trackedQueryTree.get(querySpec.getPath())) != null && map.containsKey(querySpec.getParams()) && map.get(querySpec.getParams()).complete) {
            return true;
        }
        return false;
    }

    public PruneForest pruneOldQueries(CachePolicy cachePolicy) {
        List<TrackedQuery> queriesMatching = getQueriesMatching(IS_QUERY_PRUNABLE_PREDICATE);
        long calculateCountToPrune = calculateCountToPrune(cachePolicy, (long) queriesMatching.size());
        PruneForest pruneForest = new PruneForest();
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder i0 = hj1.i0("Pruning old queries.  Prunable: ");
            i0.append(queriesMatching.size());
            i0.append(" Count to prune: ");
            i0.append(calculateCountToPrune);
            logWrapper.debug(i0.toString(), new Object[0]);
        }
        Collections.sort(queriesMatching, new Object() {
            /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass6 */

            /* Return type fixed from 'java.util.Comparator' to match base method */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ Comparator<TrackedQuery> reversed() {
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
            public /* synthetic */ java.util.Comparator<TrackedQuery> thenComparing(java.util.Comparator<? super TrackedQuery> comparator) {
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

            public int compare(TrackedQuery trackedQuery, TrackedQuery trackedQuery2) {
                return Utilities.compareLongs(trackedQuery.lastUse, trackedQuery2.lastUse);
            }
        });
        for (int i = 0; ((long) i) < calculateCountToPrune; i++) {
            TrackedQuery trackedQuery = queriesMatching.get(i);
            pruneForest = pruneForest.prune(trackedQuery.querySpec.getPath());
            removeTrackedQuery(trackedQuery.querySpec);
        }
        for (int i2 = (int) calculateCountToPrune; i2 < queriesMatching.size(); i2++) {
            pruneForest = pruneForest.keep(queriesMatching.get(i2).querySpec.getPath());
        }
        List<TrackedQuery> queriesMatching2 = getQueriesMatching(IS_QUERY_UNPRUNABLE_PREDICATE);
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper2 = this.logger;
            StringBuilder i02 = hj1.i0("Unprunable queries: ");
            i02.append(queriesMatching2.size());
            logWrapper2.debug(i02.toString(), new Object[0]);
        }
        for (TrackedQuery trackedQuery2 : queriesMatching2) {
            pruneForest = pruneForest.keep(trackedQuery2.querySpec.getPath());
        }
        return pruneForest;
    }

    public void removeTrackedQuery(QuerySpec querySpec) {
        QuerySpec normalizeQuery = normalizeQuery(querySpec);
        TrackedQuery findTrackedQuery = findTrackedQuery(normalizeQuery);
        Utilities.hardAssert(findTrackedQuery != null, "Query must exist to be removed.");
        this.storageLayer.deleteTrackedQuery(findTrackedQuery.id);
        Map<QueryParams, TrackedQuery> map = this.trackedQueryTree.get(normalizeQuery.getPath());
        map.remove(normalizeQuery.getParams());
        if (map.isEmpty()) {
            this.trackedQueryTree = this.trackedQueryTree.remove(normalizeQuery.getPath());
        }
    }

    public void setQueriesComplete(Path path) {
        this.trackedQueryTree.subtree(path).foreach(new ImmutableTree.TreeVisitor<Map<QueryParams, TrackedQuery>, Void>() {
            /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass5 */

            public Void onNodeValue(Path path, Map<QueryParams, TrackedQuery> map, Void r3) {
                for (Map.Entry<QueryParams, TrackedQuery> entry : map.entrySet()) {
                    TrackedQuery value = entry.getValue();
                    if (!value.complete) {
                        TrackedQueryManager.this.saveTrackedQuery(value.setComplete());
                    }
                }
                return null;
            }
        });
    }

    public void setQueryActive(QuerySpec querySpec) {
        setQueryActiveFlag(querySpec, true);
    }

    public void setQueryCompleteIfExists(QuerySpec querySpec) {
        TrackedQuery findTrackedQuery = findTrackedQuery(normalizeQuery(querySpec));
        if (findTrackedQuery != null && !findTrackedQuery.complete) {
            saveTrackedQuery(findTrackedQuery.setComplete());
        }
    }

    public void setQueryInactive(QuerySpec querySpec) {
        setQueryActiveFlag(querySpec, false);
    }

    public void verifyCache() {
        List<TrackedQuery> loadTrackedQueries = this.storageLayer.loadTrackedQueries();
        final ArrayList arrayList = new ArrayList();
        this.trackedQueryTree.foreach(new ImmutableTree.TreeVisitor<Map<QueryParams, TrackedQuery>, Void>() {
            /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass7 */

            public Void onNodeValue(Path path, Map<QueryParams, TrackedQuery> map, Void r3) {
                for (TrackedQuery trackedQuery : map.values()) {
                    arrayList.add(trackedQuery);
                }
                return null;
            }
        });
        Collections.sort(arrayList, new Object() {
            /* class com.google.firebase.database.core.persistence.TrackedQueryManager.AnonymousClass8 */

            /* Return type fixed from 'java.util.Comparator' to match base method */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ java.util.Comparator<TrackedQuery> reversed() {
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
            public /* synthetic */ java.util.Comparator<TrackedQuery> thenComparing(java.util.Comparator<? super TrackedQuery> comparator) {
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

            public int compare(TrackedQuery trackedQuery, TrackedQuery trackedQuery2) {
                return Utilities.compareLongs(trackedQuery.id, trackedQuery2.id);
            }
        });
        boolean equals = loadTrackedQueries.equals(arrayList);
        Utilities.hardAssert(equals, "Tracked queries out of sync.  Tracked queries: " + arrayList + " Stored queries: " + loadTrackedQueries);
    }
}
