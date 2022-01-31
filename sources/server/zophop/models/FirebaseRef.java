package server.zophop.models;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.firebase.client.Firebase;
import java.util.HashMap;
import java.util.Map;
import server.zophop.CS;
import server.zophop.Constants;
import server.zophop.logging.LoggingConstants;

public class FirebaseRef {
    private static final CS.ENVIRONMENT _environment = CS.ENVIRONMENT.valueOf("production");
    private static FirebaseRef _firebaseRef = null;
    private static Map<String, Firebase> firebaseRefMap = new HashMap();

    public static Firebase getBaseFirebaseRef(String str) {
        if (str.toLowerCase().equals("kolkata")) {
            return new Firebase(Constants.LIVE_FIREBASE_SHARD2).child(_environment.name());
        }
        if (str.toLowerCase().equals("kochi")) {
            return new Firebase(Constants.LIVE_FIREBASE_SHARD1).child(_environment.name());
        }
        if (str.toLowerCase().equals("bangalore")) {
            return new Firebase(Constants.LIVE_FIREBASE_BANGALORE).child(_environment.name());
        }
        if (str.toLowerCase().equals("ujjain") || str.toLowerCase().equalsIgnoreCase("jabalpur")) {
            return new Firebase(Constants.LIVE_FIREBASE_SHARD3).child(_environment.name());
        }
        if (str.toLowerCase().equals("lucknow") || str.toLowerCase().equals("prayagraj") || str.toLowerCase().equals("agra") || str.toLowerCase().equals("meerut") || str.toLowerCase().equals("mathura") || str.toLowerCase().equals("kanpur")) {
            return new Firebase(Constants.LIVE_FIREBASE_UP).child(_environment.name());
        }
        if (str.toLowerCase().equals("patna")) {
            return new Firebase(Constants.LIVE_FIREBASE_BIHAR).child(_environment.name());
        }
        if (str.toLowerCase().equals("delhi")) {
            return new Firebase(Constants.LIVE_FIREBASE_DELHI).child(_environment.name());
        }
        if (str.toLowerCase().equals("guwahati")) {
            return new Firebase(Constants.LIVE_FIREBASE_ASSAM).child(_environment.name());
        }
        if (str.toLowerCase().equals("hyderabad")) {
            return new Firebase(Constants.LIVE_FIREBASE_TELANGANA).child(_environment.name());
        }
        if (str.toLowerCase().equals("vijayawada")) {
            return new Firebase(Constants.LIVE_FIREBASE_VIJAYWADA).child(_environment.name());
        }
        if (str.toLowerCase().equals("mangaluru")) {
            return new Firebase(Constants.LIVE_FIREBASE_MANGALORE).child(_environment.name());
        }
        if (str.toLowerCase().equals("jaipur")) {
            return new Firebase(Constants.LIVE_FIREBASE_JAIPUR).child(_environment.name());
        }
        if (str.toLowerCase().equals("bhubaneswar")) {
            return new Firebase(Constants.LIVE_FIREBASE_BHUBANESHWAR).child(_environment.name());
        }
        if (str.toLowerCase().equalsIgnoreCase("chennai")) {
            return new Firebase(Constants.LIVE_FIREBASE_CHENNAI).child(_environment.name());
        }
        if (str.toLowerCase().equalsIgnoreCase("hubli")) {
            return new Firebase(Constants.LIVE_FIREBASE_HUBLI).child(_environment.name());
        }
        if (str.toLowerCase().equalsIgnoreCase("udupi")) {
            return new Firebase(Constants.LIVE_FIREBASE_UDUPI).child(_environment.name());
        }
        if (str.toLowerCase().equalsIgnoreCase("belgaum")) {
            return new Firebase(Constants.LIVE_FIREBASE_BELGAUM).child(_environment.name());
        }
        return new Firebase("https://dazzling-fire-3689.firebaseio.com/").child(_environment.name());
    }

    public static Firebase getBaseUrl(String str) {
        if (firebaseRefMap.containsKey(str)) {
            return firebaseRefMap.get(str);
        }
        Firebase baseFirebaseRef = getBaseFirebaseRef(str);
        firebaseRefMap.put(str, baseFirebaseRef);
        return baseFirebaseRef;
    }

    public static FirebaseRef getInstance() {
        if (_firebaseRef == null) {
            _firebaseRef = new FirebaseRef();
        }
        return _firebaseRef;
    }

    public static Firebase getPointsRef(String str) {
        return getBaseUrl(str).child("points");
    }

    public Firebase getCheckinsRef(String str) {
        return getBaseUrl(str).child("checkins");
    }

    public Firebase getConductorsRef(String str) {
        return getBaseUrl(str).child("conductors");
    }

    public Firebase getDispatchRef(String str, String str2, String str3) {
        return getBaseUrl(str).child(Constants.GPS_DISPATCH).child(str.toString()).child(str3).child(str2.toString()).child("dispatch");
    }

    public Firebase getDispatchTypeRef(String str, String str2, String str3) {
        return getBaseUrl(str).child(Constants.GPS_DISPATCH).child(str.toString()).child(str3).child(str2.toString()).child("dispatchType");
    }

    public Firebase getEtaRef(String str) {
        return getBaseUrl(str).child("eta");
    }

    public Firebase getGeofireRef(String str) {
        return getBaseUrl(str).child("geofire");
    }

    public Firebase getLocationsRef(String str, String str2, String str3) {
        return getBaseUrl(str).child(Constants.GPS_DISPATCH).child(str.toString()).child(str3).child(str2.toString()).child("locations");
    }

    public Firebase getRoutesRef(String str) {
        return getBaseUrl(str).child(ProductDiscountsObject.KEY_ROUTES);
    }

    public Firebase getSessionsRef(String str) {
        if (str.equalsIgnoreCase("kolkata")) {
            return new Firebase("https://dazzling-fire-kolkata2.firebaseio.com/production").child(LoggingConstants.SESSION);
        }
        return getBaseUrl(str).child(LoggingConstants.SESSION);
    }

    public Firebase getVehicleDispatchTypeRef(String str, String str2, String str3, String str4) {
        return getBaseUrl(str).child(Constants.GPS_DISPATCH).child(str.toString()).child(str3).child(str2.toString()).child("dispatchType").child(str4);
    }

    public Firebase getVehiclesRef(String str) {
        if (str.equalsIgnoreCase("bhopal")) {
            System.out.println();
        }
        if (str.equalsIgnoreCase("kolkata")) {
            return new Firebase("https://dazzling-fire-kolkata2.firebaseio.com/production").child(Constants.GPS_DISPATCH);
        }
        return getBaseUrl(str).child(Constants.GPS_DISPATCH);
    }
}
