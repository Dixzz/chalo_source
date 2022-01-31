package com.firebase.geofire.example;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQueryEventListener;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import java.io.PrintStream;

public class Example {
    public static void main(String[] strArr) throws InterruptedException {
        new GeoFire(FirebaseDatabase.getInstance().getReferenceFromUrl("https://geofire-v3.firebaseio.com/geofire")).queryAtLocation(new GeoLocation(37.7d, -122.4d, null), 10.0d).addGeoQueryEventListener(new GeoQueryEventListener() {
            /* class com.firebase.geofire.example.Example.AnonymousClass1 */

            @Override // com.firebase.geofire.GeoQueryEventListener
            public void onGeoQueryError(DatabaseError databaseError) {
                PrintStream printStream = System.err;
                StringBuilder i0 = hj1.i0("There was an error querying locations: ");
                i0.append(databaseError.getMessage());
                printStream.println(i0.toString());
            }

            @Override // com.firebase.geofire.GeoQueryEventListener
            public void onGeoQueryReady() {
                System.out.println("All initial key entered events have been fired!");
            }

            @Override // com.firebase.geofire.GeoQueryEventListener
            public void onKeyEntered(String str, GeoLocation geoLocation) {
                System.out.println(String.format("%s entered at [%f, %f]", str, Double.valueOf(geoLocation.latitude), Double.valueOf(geoLocation.longitude)));
            }

            @Override // com.firebase.geofire.GeoQueryEventListener
            public void onKeyExited(String str) {
                System.out.println(String.format("%s exited", str));
            }

            @Override // com.firebase.geofire.GeoQueryEventListener
            public void onKeyMoved(String str, GeoLocation geoLocation) {
                System.out.println(String.format("%s moved to [%f, %f]", str, Double.valueOf(geoLocation.latitude), Double.valueOf(geoLocation.longitude)));
            }
        });
        Thread.sleep(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
    }
}
