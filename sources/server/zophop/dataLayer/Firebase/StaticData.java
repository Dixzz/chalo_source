package server.zophop.dataLayer.Firebase;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;
import server.zophop.Constants;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stop;
import server.zophop.utils.DataObjectCreator;

public class StaticData {
    private static DataObjectCreator _dataObjectCreator = new DataObjectCreator();

    public static double getAvgSpeed(String str, String str2, int i) {
        return 13.0d;
    }

    public static double getHaltTime(String str, String str2, int i) {
        return 20.0d;
    }

    public static Route getRouteFromFirebase(String str, String str2, String str3) {
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").child(Constants.CITY_DATA).child(str.toLowerCase()).child(Constants.ROUTES).child(str2.toUpperCase()).child(str3));
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return null;
        }
        Route extractRoute = DataObjectCreator.extractRoute(synchronizedDataSnapshot, str2);
        extractRoute.setStationType(str2);
        return extractRoute;
    }

    public static List<Route> getRoutesByName(String str, final String str2, String str3) {
        Query equalTo = new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").child(Constants.CITY_DATA).child(str.toLowerCase()).child(Constants.ROUTES).child(str2.toUpperCase()).orderByChild("name").equalTo(str3);
        final SettableFuture create = SettableFuture.create();
        final ArrayList arrayList = new ArrayList();
        equalTo.addListenerForSingleValueEvent(new ValueEventListener() {
            /* class server.zophop.dataLayer.Firebase.StaticData.AnonymousClass2 */

            public void onCancelled(FirebaseError firebaseError) {
                create.set((Object) null);
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    DataObjectCreator unused = StaticData._dataObjectCreator;
                    arrayList.add(DataObjectCreator.extractRoute(dataSnapshot2, str2));
                }
                create.set(arrayList);
            }
        });
        try {
            create.get(5, TimeUnit.SECONDS);
            return arrayList;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static JSONObject getStaticEta(String str, String str2, String str3, String str4) {
        SettableFuture<DataSnapshot> querySnapshot = FirebaseUtils.getQuerySnapshot(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").child("staticEta").child(str).child(str2).child(str3).child("-1"));
        JSONObject jSONObject = new JSONObject();
        try {
            Iterable children = ((DataSnapshot) querySnapshot.get((long) Constants.THRESHOLD_TIMESTAMP, TimeUnit.SECONDS)).getChildren();
            while (children.iterator().hasNext()) {
                DataSnapshot dataSnapshot = (DataSnapshot) children.iterator().next();
                jSONObject.put(dataSnapshot.getKey(), dataSnapshot.getValue());
            }
        } catch (Exception unused) {
            SimpleLogger.warning("Eta ref does not exist " + str3 + "for city " + str);
        }
        return jSONObject;
    }

    public static Stop getStopFromFirebase(String str, String str2, String str3) {
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").child(Constants.CITY_DATA).child(str.toLowerCase()).child(Constants.STOPS).child(str2.toUpperCase()).child(str3));
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return null;
        }
        return DataObjectCreator.extractStop(synchronizedDataSnapshot);
    }

    public static Map<String, Stop> getStops(String str, String str2) {
        HashMap hashMap = new HashMap();
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").child(Constants.CITY_DATA).child(str.toLowerCase()).child(Constants.STOPS).child(str2.toUpperCase()));
        if (synchronizedDataSnapshot != null) {
            synchronizedDataSnapshot.getValue();
        }
        for (DataSnapshot dataSnapshot : synchronizedDataSnapshot.getChildren()) {
            hashMap.put(dataSnapshot.getKey(), DataObjectCreator.extractStop(synchronizedDataSnapshot.child(dataSnapshot.getKey())));
        }
        return hashMap;
    }

    public static void printErrorDetails(FirebaseError firebaseError) {
        if (firebaseError != null) {
            StringBuilder i0 = hj1.i0("firebase error ");
            i0.append(firebaseError.getMessage());
            i0.append(" details ");
            i0.append(firebaseError.getDetails());
            i0.append(" \nexception ");
            i0.append(firebaseError.toException());
            SimpleLogger.severe(i0.toString());
        }
    }

    public static void storeStaticData(Map<String, Object> map) {
        new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").updateChildren(map, new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.StaticData.AnonymousClass1 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                SimpleLogger.info("Live data update !");
                StaticData.printErrorDetails(firebaseError);
            }
        });
    }
}
