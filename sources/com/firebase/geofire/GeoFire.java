package com.firebase.geofire;

import com.firebase.geofire.core.GeoHash;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GeoFire {
    private final DatabaseReference databaseReference;
    private final EventRaiser eventRaiser;

    public interface CompletionListener {
        void onComplete(String str, DatabaseError databaseError);
    }

    public static class LocationValueEventListener implements ValueEventListener {
        private final LocationCallback callback;

        public LocationValueEventListener(LocationCallback locationCallback) {
            this.callback = locationCallback;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            this.callback.onCancelled(databaseError);
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue() == null) {
                this.callback.onLocationResult(dataSnapshot.getKey(), null);
                return;
            }
            GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
            if (locationValue != null) {
                this.callback.onLocationResult(dataSnapshot.getKey(), locationValue);
                return;
            }
            StringBuilder i0 = hj1.i0("GeoFire data has invalid format: ");
            i0.append(dataSnapshot.getValue());
            this.callback.onCancelled(DatabaseError.fromException(new Throwable(i0.toString())));
        }
    }

    public GeoFire(DatabaseReference databaseReference2) {
        EventRaiser eventRaiser2;
        this.databaseReference = databaseReference2;
        try {
            eventRaiser2 = new AndroidEventRaiser();
        } catch (Throwable unused) {
            eventRaiser2 = new ThreadEventRaiser();
        }
        this.eventRaiser = eventRaiser2;
    }

    public static GeoLocation getLocationValue(DataSnapshot dataSnapshot) {
        try {
            Map map = (Map) dataSnapshot.getValue(new GenericTypeIndicator<Map<String, Object>>() {
                /* class com.firebase.geofire.GeoFire.AnonymousClass1 */
            });
            List list = (List) map.get("l");
            double doubleValue = ((Number) list.get(0)).doubleValue();
            double doubleValue2 = ((Number) list.get(1)).doubleValue();
            Map map2 = (Map) map.get("data");
            if (list.size() == 2 && GeoLocation.coordinatesValid(doubleValue, doubleValue2)) {
                return new GeoLocation(doubleValue, doubleValue2, map2);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return null;
    }

    public DatabaseReference getDatabaseRefForKey(String str) {
        return this.databaseReference.child(str);
    }

    public DatabaseReference getDatabaseReference() {
        return this.databaseReference;
    }

    public void getLocation(String str, LocationCallback locationCallback) {
        getDatabaseRefForKey(str).addListenerForSingleValueEvent(new LocationValueEventListener(locationCallback));
    }

    public GeoQuery queryAtLocation(GeoLocation geoLocation, double d) {
        return new GeoQuery(this, geoLocation, d);
    }

    public void raiseEvent(Runnable runnable) {
        this.eventRaiser.raiseEvent(runnable);
    }

    public void removeLocation(String str) {
        removeLocation(str, null);
    }

    public void setLocation(String str, GeoLocation geoLocation) {
        setLocation(str, geoLocation, null);
    }

    public void removeLocation(final String str, final CompletionListener completionListener) {
        Objects.requireNonNull(str);
        DatabaseReference databaseRefForKey = getDatabaseRefForKey(str);
        if (completionListener != null) {
            databaseRefForKey.setValue((Object) null, (DatabaseReference.CompletionListener) new DatabaseReference.CompletionListener() {
                /* class com.firebase.geofire.GeoFire.AnonymousClass3 */

                @Override // com.google.firebase.database.DatabaseReference.CompletionListener
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    completionListener.onComplete(str, databaseError);
                }
            });
        } else {
            databaseRefForKey.setValue((Object) null);
        }
    }

    public void setLocation(final String str, GeoLocation geoLocation, final CompletionListener completionListener) {
        Objects.requireNonNull(str);
        DatabaseReference databaseRefForKey = getDatabaseRefForKey(str);
        GeoHash geoHash = new GeoHash(geoLocation);
        HashMap hashMap = new HashMap();
        hashMap.put("g", geoHash.getGeoHashString());
        hashMap.put("l", Arrays.asList(Double.valueOf(geoLocation.latitude), Double.valueOf(geoLocation.longitude)));
        if (completionListener != null) {
            databaseRefForKey.setValue(hashMap, geoHash.getGeoHashString(), new DatabaseReference.CompletionListener() {
                /* class com.firebase.geofire.GeoFire.AnonymousClass2 */

                @Override // com.google.firebase.database.DatabaseReference.CompletionListener
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    completionListener.onComplete(str, databaseError);
                }
            });
        } else {
            databaseRefForKey.setValue((Object) hashMap, (Object) geoHash.getGeoHashString());
        }
    }
}
