package com.firebase.geofire;

import com.firebase.geofire.core.GeoHash;
import com.firebase.geofire.core.GeoHashQuery;
import com.firebase.geofire.util.GeoUtils;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GeoQuery {
    private GeoLocation center;
    private final ChildEventListener childEventLister = new ChildEventListener() {
        /* class com.firebase.geofire.GeoQuery.AnonymousClass1 */

        @Override // com.google.firebase.database.ChildEventListener
        public synchronized void onCancelled(DatabaseError databaseError) {
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildAdded(DataSnapshot dataSnapshot, String str) {
            synchronized (GeoQuery.this) {
                GeoQuery.this.childAdded(dataSnapshot);
            }
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildChanged(DataSnapshot dataSnapshot, String str) {
            synchronized (GeoQuery.this) {
                GeoQuery.this.childChanged(dataSnapshot);
            }
        }

        @Override // com.google.firebase.database.ChildEventListener
        public synchronized void onChildMoved(DataSnapshot dataSnapshot, String str) {
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            synchronized (GeoQuery.this) {
                GeoQuery.this.childRemoved(dataSnapshot);
            }
        }
    };
    private final Set<GeoQueryEventListener> eventListeners = new HashSet();
    private final Map<GeoHashQuery, Query> firebaseQueries = new HashMap();
    private final GeoFire geoFire;
    private final Map<String, LocationInfo> locationInfos = new HashMap();
    private final Set<GeoHashQuery> outstandingQueries = new HashSet();
    private Set<GeoHashQuery> queries;
    private double radius;

    public static class LocationInfo {
        public final GeoHash geoHash;
        public final boolean inGeoQuery;
        public final GeoLocation location;

        public LocationInfo(GeoLocation geoLocation, boolean z) {
            this.location = geoLocation;
            this.inGeoQuery = z;
            this.geoHash = new GeoHash(geoLocation);
        }
    }

    public GeoQuery(GeoFire geoFire2, GeoLocation geoLocation, double d) {
        this.geoFire = geoFire2;
        this.center = geoLocation;
        this.radius = d * 1000.0d;
    }

    private void addValueToReadyListener(Query query, final GeoHashQuery geoHashQuery) {
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            /* class com.firebase.geofire.GeoQuery.AnonymousClass6 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(final DatabaseError databaseError) {
                synchronized (GeoQuery.this) {
                    for (final GeoQueryEventListener geoQueryEventListener : GeoQuery.this.eventListeners) {
                        GeoQuery.this.geoFire.raiseEvent(new Runnable() {
                            /* class com.firebase.geofire.GeoQuery.AnonymousClass6.AnonymousClass1 */

                            public void run() {
                                geoQueryEventListener.onGeoQueryError(databaseError);
                            }
                        });
                    }
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                synchronized (GeoQuery.this) {
                    GeoQuery.this.outstandingQueries.remove(geoHashQuery);
                    GeoQuery.this.checkAndFireReady();
                }
            }
        });
    }

    private boolean canFireReady() {
        return this.outstandingQueries.isEmpty();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkAndFireReady() {
        if (canFireReady()) {
            for (final GeoQueryEventListener geoQueryEventListener : this.eventListeners) {
                this.geoFire.raiseEvent(new Runnable() {
                    /* class com.firebase.geofire.GeoQuery.AnonymousClass5 */

                    public void run() {
                        geoQueryEventListener.onGeoQueryReady();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void childAdded(DataSnapshot dataSnapshot) {
        GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
        if (locationValue != null) {
            updateLocationInfo(dataSnapshot.getKey(), locationValue);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void childChanged(DataSnapshot dataSnapshot) {
        GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
        if (locationValue != null) {
            updateLocationInfo(dataSnapshot.getKey(), locationValue);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void childRemoved(DataSnapshot dataSnapshot) {
        final String key = dataSnapshot.getKey();
        if (this.locationInfos.get(key) != null) {
            this.geoFire.getDatabaseRefForKey(key).addListenerForSingleValueEvent(new ValueEventListener() {
                /* class com.firebase.geofire.GeoQuery.AnonymousClass7 */

                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    synchronized (GeoQuery.this) {
                        GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
                        GeoHash geoHash = locationValue != null ? new GeoHash(locationValue) : null;
                        if (geoHash == null || !GeoQuery.this.geoHashQueriesContainGeoHash(geoHash)) {
                            LocationInfo locationInfo = (LocationInfo) GeoQuery.this.locationInfos.get(key);
                            GeoQuery.this.locationInfos.remove(key);
                            if (locationInfo != null && locationInfo.inGeoQuery) {
                                for (final GeoQueryEventListener geoQueryEventListener : GeoQuery.this.eventListeners) {
                                    GeoQuery.this.geoFire.raiseEvent(new Runnable() {
                                        /* class com.firebase.geofire.GeoQuery.AnonymousClass7.AnonymousClass1 */

                                        public void run() {
                                            geoQueryEventListener.onKeyExited(key);
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean geoHashQueriesContainGeoHash(GeoHash geoHash) {
        Set<GeoHashQuery> set = this.queries;
        if (set == null) {
            return false;
        }
        for (GeoHashQuery geoHashQuery : set) {
            if (geoHashQuery.containsGeoHash(geoHash)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasListeners() {
        return !this.eventListeners.isEmpty();
    }

    private boolean locationIsInQuery(GeoLocation geoLocation) {
        return GeoUtils.distance(geoLocation, this.center) <= this.radius;
    }

    private void reset() {
        for (Map.Entry<GeoHashQuery, Query> entry : this.firebaseQueries.entrySet()) {
            entry.getValue().removeEventListener(this.childEventLister);
        }
        this.outstandingQueries.clear();
        this.firebaseQueries.clear();
        this.queries = null;
        this.locationInfos.clear();
    }

    private void setupQueries() {
        Set<GeoHashQuery> set = this.queries;
        if (set == null) {
            set = new HashSet();
        }
        Set<GeoHashQuery> queriesAtLocation = GeoHashQuery.queriesAtLocation(this.center, this.radius);
        this.queries = queriesAtLocation;
        for (GeoHashQuery geoHashQuery : set) {
            if (!queriesAtLocation.contains(geoHashQuery)) {
                this.firebaseQueries.get(geoHashQuery).removeEventListener(this.childEventLister);
                this.firebaseQueries.remove(geoHashQuery);
                this.outstandingQueries.remove(geoHashQuery);
            }
        }
        for (GeoHashQuery geoHashQuery2 : queriesAtLocation) {
            if (!set.contains(geoHashQuery2)) {
                this.outstandingQueries.add(geoHashQuery2);
                Query endAt = this.geoFire.getDatabaseReference().orderByChild("g").startAt(geoHashQuery2.getStartValue()).endAt(geoHashQuery2.getEndValue());
                endAt.addChildEventListener(this.childEventLister);
                addValueToReadyListener(endAt, geoHashQuery2);
                this.firebaseQueries.put(geoHashQuery2, endAt);
            }
        }
        for (Map.Entry<String, LocationInfo> entry : this.locationInfos.entrySet()) {
            updateLocationInfo(entry.getKey(), entry.getValue().location);
        }
        Iterator<Map.Entry<String, LocationInfo>> it = this.locationInfos.entrySet().iterator();
        while (it.hasNext()) {
            if (!geoHashQueriesContainGeoHash(it.next().getValue().geoHash)) {
                it.remove();
            }
        }
        checkAndFireReady();
    }

    private void updateLocationInfo(final String str, final GeoLocation geoLocation) {
        LocationInfo locationInfo = this.locationInfos.get(str);
        boolean z = true;
        boolean z2 = locationInfo == null;
        boolean z3 = locationInfo != null && !locationInfo.location.equals(geoLocation);
        if (locationInfo == null || !locationInfo.inGeoQuery) {
            z = false;
        }
        boolean locationIsInQuery = locationIsInQuery(geoLocation);
        if ((z2 || !z) && locationIsInQuery) {
            for (final GeoQueryEventListener geoQueryEventListener : this.eventListeners) {
                this.geoFire.raiseEvent(new Runnable() {
                    /* class com.firebase.geofire.GeoQuery.AnonymousClass2 */

                    public void run() {
                        geoQueryEventListener.onKeyEntered(str, geoLocation);
                    }
                });
            }
        } else if (!z2 && z3 && locationIsInQuery) {
            for (final GeoQueryEventListener geoQueryEventListener2 : this.eventListeners) {
                this.geoFire.raiseEvent(new Runnable() {
                    /* class com.firebase.geofire.GeoQuery.AnonymousClass3 */

                    public void run() {
                        geoQueryEventListener2.onKeyMoved(str, geoLocation);
                    }
                });
            }
        } else if (z && !locationIsInQuery) {
            for (final GeoQueryEventListener geoQueryEventListener3 : this.eventListeners) {
                this.geoFire.raiseEvent(new Runnable() {
                    /* class com.firebase.geofire.GeoQuery.AnonymousClass4 */

                    public void run() {
                        geoQueryEventListener3.onKeyExited(str);
                    }
                });
            }
        }
        this.locationInfos.put(str, new LocationInfo(geoLocation, locationIsInQuery(geoLocation)));
    }

    public synchronized void addGeoQueryEventListener(final GeoQueryEventListener geoQueryEventListener) {
        if (!this.eventListeners.contains(geoQueryEventListener)) {
            this.eventListeners.add(geoQueryEventListener);
            if (this.queries == null) {
                setupQueries();
            } else {
                for (Map.Entry<String, LocationInfo> entry : this.locationInfos.entrySet()) {
                    final String key = entry.getKey();
                    final LocationInfo value = entry.getValue();
                    if (value.inGeoQuery) {
                        this.geoFire.raiseEvent(new Runnable() {
                            /* class com.firebase.geofire.GeoQuery.AnonymousClass8 */

                            public void run() {
                                geoQueryEventListener.onKeyEntered(key, value.location);
                            }
                        });
                    }
                }
                if (canFireReady()) {
                    this.geoFire.raiseEvent(new Runnable() {
                        /* class com.firebase.geofire.GeoQuery.AnonymousClass9 */

                        public void run() {
                            geoQueryEventListener.onGeoQueryReady();
                        }
                    });
                }
            }
        } else {
            throw new IllegalArgumentException("Added the same listener twice to a GeoQuery!");
        }
    }

    public synchronized GeoLocation getCenter() {
        return this.center;
    }

    public synchronized double getRadius() {
        return this.radius / 1000.0d;
    }

    public synchronized void removeAllListeners() {
        this.eventListeners.clear();
        reset();
    }

    public synchronized void removeGeoQueryEventListener(GeoQueryEventListener geoQueryEventListener) {
        if (this.eventListeners.contains(geoQueryEventListener)) {
            this.eventListeners.remove(geoQueryEventListener);
            if (!hasListeners()) {
                reset();
            }
        } else {
            throw new IllegalArgumentException("Trying to remove listener that was removed or not added!");
        }
    }

    public synchronized void setCenter(GeoLocation geoLocation) {
        this.center = geoLocation;
        if (hasListeners()) {
            setupQueries();
        }
    }

    public synchronized void setRadius(double d) {
        this.radius = d * 1000.0d;
        if (hasListeners()) {
            setupQueries();
        }
    }
}
