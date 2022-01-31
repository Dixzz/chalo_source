package server.zophop.dataLayer.Firebase;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.ServerValue;
import com.firebase.client.Transaction;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import server.zophop.Constants;
import server.zophop.gpsIntegration.models.VehicleDisapatchTypeInfo;
import server.zophop.logging.LoggingConstants;
import server.zophop.models.CheckOutType;
import server.zophop.models.FirebaseRef;
import server.zophop.models.SimpleLogger;

public class VehicleData {
    private static FirebaseRef _firebaseRef;

    public enum ENVIRONMENT {
        production,
        development
    }

    public VehicleData() {
        _firebaseRef = FirebaseRef.getInstance();
    }

    public static void AddStatusToDisaptch(String str, String str2, String str3, String str4, String str5) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        Firebase child = vehiclesRef.child(str.toLowerCase()).child(str3.toLowerCase()).child(hackForBhopalVehiclesRef(str, str2)).child("dispatch").child(str4);
        PrintStream printStream = System.out;
        StringBuilder i0 = hj1.i0("ref : ");
        i0.append(child.toString());
        printStream.println(i0.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("status", str5);
        child.updateChildren(hashMap);
    }

    /* access modifiers changed from: private */
    public static boolean checkForManualCheckout(CheckOutType checkOutType) {
        return checkOutType.equals(CheckOutType.etim) || checkOutType.equals(CheckOutType.androidDefault) || checkOutType.equals(CheckOutType.dispatchAndroid) || checkOutType.equals(CheckOutType.dispatchWeb) || checkOutType.equals(CheckOutType.defaultCheckOut);
    }

    public static void checkOutIfOpen(String str, String str2, String str3, String str4, String str5, CheckOutType checkOutType, Runnable runnable, long j, String str6, boolean z) {
        VehicleDisapatchTypeInfo vehicleDisapatchTypeInfo;
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        String hackForBhopalVehiclesRef = hackForBhopalVehiclesRef(str, str3);
        Firebase child = vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef).child("dispatch").child(str4);
        if (isVehicleValidForRouteDeviationCheckIn(str4)) {
            if (checkOutType.equals(CheckOutType.autoRouteDeviation)) {
                vehicleDisapatchTypeInfo = getVehicleDispatchTypeInfo(str, str2, hackForBhopalVehiclesRef, str4);
                child.runTransaction(getTransactionHandler(str5, checkOutType, runnable, j, str6, str4, str, hackForBhopalVehiclesRef, str2, vehicleDisapatchTypeInfo, z));
            }
        }
        vehicleDisapatchTypeInfo = null;
        child.runTransaction(getTransactionHandler(str5, checkOutType, runnable, j, str6, str4, str, hackForBhopalVehiclesRef, str2, vehicleDisapatchTypeInfo, z));
    }

    /* access modifiers changed from: private */
    public static boolean checkout(DataSnapshot dataSnapshot, long j) {
        return !dataSnapshot.hasChild("streamId") && j == (dataSnapshot.hasChild("lockId") ? ((Long) dataSnapshot.child("lockId").getValue()).longValue() : 0);
    }

    /* access modifiers changed from: private */
    public static MutableData clearSessionInfo(MutableData mutableData, long j) {
        mutableData.child("streamId").setValue((Object) null);
        mutableData.child(LoggingConstants.SESSION_START_TIME).setValue((Object) null);
        mutableData.child("timeStamp").setValue(Long.valueOf(System.currentTimeMillis()));
        mutableData.child("lockId").setValue(Long.valueOf(j));
        return mutableData;
    }

    public static VehicleDisapatchTypeInfo createVehicleDispatchTypeInfo(Map map) {
        String str = null;
        String str2 = ((String) map.get("category")) == null ? null : (String) map.get("category");
        String str3 = ((String) map.get("endTime")) == null ? null : (String) map.get("endTime");
        boolean booleanValue = map.containsKey("isActive") ? false : ((Boolean) map.get("isActive")).booleanValue();
        String str4 = ((String) map.get(SuperPassJsonKeys.START_TIME)) == null ? null : (String) map.get(SuperPassJsonKeys.START_TIME);
        String str5 = ((String) map.get(LoggingConstants.ROUTE_ID)) == null ? null : (String) map.get(LoggingConstants.ROUTE_ID);
        if (((String) map.get(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO)) != null) {
            str = (String) map.get(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO);
        }
        return new VehicleDisapatchTypeInfo(str2, str3, booleanValue, str4, str, str5);
    }

    public static void cronCheckOutIfOpen(String str, String str2, String str3, String str4, String str5, CheckOutType checkOutType, Runnable runnable) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("dispatch").child(str4).runTransaction(getCronTransactionHandler(str5, checkOutType, runnable));
    }

    public static void endTripIfStarted(String str, String str2, String str3, String str4, String str5, CheckOutType checkOutType, Runnable runnable, long j, String str6, boolean z) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("dispatch").child(str4).runTransaction(tripEndTransactionHandler(str5, checkOutType, runnable, z));
    }

    private static Transaction.Handler getCheckinCheckoutHandler(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final Runnable runnable) {
        final long random = (long) (Math.random() * 1000000.0d);
        return new Transaction.Handler() {
            /* class server.zophop.dataLayer.Firebase.VehicleData.AnonymousClass6 */
            public MutableData previousMutableData;

            public Transaction.Result doTransaction(MutableData mutableData) {
                this.previousMutableData = mutableData;
                String str = (String) mutableData.child("streamId").getValue();
                if (str == null || !str.equals(str)) {
                    SimpleLogger.severe("RouteReverse  Transaction abort  :(");
                    return Transaction.success(mutableData);
                }
                mutableData.child("streamId").setValue((Object) null);
                mutableData.child(LoggingConstants.SESSION_START_TIME).setValue((Object) null);
                mutableData.child(LoggingConstants.ROUTE_ID).setValue(str2);
                mutableData.child("checkedIn").setValue(Boolean.TRUE);
                mutableData.child("routeName").setValue(str3);
                mutableData.child(Constants.START_STOP_NAME).setValue(str4);
                mutableData.child(Constants.END_STOP_STOP_NAME).setValue(str5);
                mutableData.child("timeStamp").setValue(Long.valueOf(System.currentTimeMillis()));
                mutableData.child("lockId").setValue(Long.valueOf(random));
                mutableData.child("source").setValue(str6);
                return Transaction.success(mutableData);
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                if (firebaseError == null && z && VehicleData.checkout(dataSnapshot, random)) {
                    runnable.run();
                }
            }
        };
    }

    private static Transaction.Handler getCronTransactionHandler(final String str, final CheckOutType checkOutType, final Runnable runnable) {
        return new Transaction.Handler() {
            /* class server.zophop.dataLayer.Firebase.VehicleData.AnonymousClass5 */
            public String oldStream;

            public Transaction.Result doTransaction(MutableData mutableData) {
                String str = (String) mutableData.child("streamId").getValue();
                String str2 = (String) mutableData.child(LoggingConstants.ROUTE_ID).getValue();
                VehicleData.updateStatus(mutableData, checkOutType, true);
                this.oldStream = str;
                if (str != null && !str.equals(str)) {
                    return Transaction.success(mutableData);
                }
                if (str == null || !str.equals(str)) {
                    return Transaction.success(mutableData);
                }
                return Transaction.abort();
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                if (firebaseError == null && z) {
                    runnable.run();
                }
            }
        };
    }

    private static Transaction.Handler getStreamStartedTransactionHandler(final String str, final long j, final Runnable runnable) {
        return new Transaction.Handler() {
            /* class server.zophop.dataLayer.Firebase.VehicleData.AnonymousClass1 */
            public MutableData previousMutableData;

            public Transaction.Result doTransaction(MutableData mutableData) {
                this.previousMutableData = mutableData;
                if (((String) mutableData.child("streamId").getValue()) != null) {
                    return Transaction.success(mutableData);
                }
                mutableData.child("streamId").setValue(str);
                mutableData.child(LoggingConstants.SESSION_START_TIME).setValue(Long.valueOf(j));
                return Transaction.success(mutableData);
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                if (firebaseError == null && z && VehicleData.isStreamAdded(dataSnapshot, str)) {
                    runnable.run();
                }
            }
        };
    }

    private static Transaction.Handler getTransactionHandler(final String str, final CheckOutType checkOutType, final Runnable runnable, final long j, String str2, final String str3, final String str4, final String str5, final String str6, final VehicleDisapatchTypeInfo vehicleDisapatchTypeInfo, final boolean z) {
        return new Transaction.Handler() {
            /* class server.zophop.dataLayer.Firebase.VehicleData.AnonymousClass3 */
            public String oldStream;

            public Transaction.Result doTransaction(MutableData mutableData) {
                String str = (String) mutableData.child("streamId").getValue();
                String str2 = (String) mutableData.child(LoggingConstants.ROUTE_ID).getValue();
                this.oldStream = str;
                if (str != null && str.equals(str)) {
                    VehicleData.updateStatus(mutableData, checkOutType, z);
                    return Transaction.success(VehicleData.processCheckout(mutableData, j, checkOutType, str2, str3, str4, str5, str6, vehicleDisapatchTypeInfo, str));
                } else if (str != null && !str.equals(str)) {
                    return Transaction.abort();
                } else {
                    if (str2 == null || !VehicleData.checkForManualCheckout(checkOutType)) {
                        return Transaction.success(mutableData);
                    }
                    VehicleData.updateStatus(mutableData, checkOutType, z);
                    return Transaction.success(VehicleData.processCheckout(mutableData, j, checkOutType, str2, str3, str4, str5, str6, vehicleDisapatchTypeInfo, str));
                }
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                if (firebaseError == null && z && VehicleData.isCheckedOut(dataSnapshot, this.oldStream)) {
                    runnable.run();
                }
            }
        };
    }

    public static Map getVehicleCheckinInfo(String str, String str2, String str3, String str4) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("dispatch").child(str4));
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return null;
        }
        return (Map) synchronizedDataSnapshot.getValue();
    }

    public static Map getVehicleDispatchInfo(String str, String str2, String str3, String str4) {
        Firebase vehicleDispatchTypeRef = _firebaseRef.getVehicleDispatchTypeRef(str, str3, str2, str4);
        hackForBhopalVehiclesRef(str, str3);
        PrintStream printStream = System.out;
        StringBuilder i0 = hj1.i0("ref ");
        i0.append(vehicleDispatchTypeRef.toString());
        printStream.println(i0.toString());
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(vehicleDispatchTypeRef);
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return null;
        }
        return (Map) synchronizedDataSnapshot.getValue();
    }

    public static VehicleDisapatchTypeInfo getVehicleDispatchTypeInfo(String str, String str2, String str3, String str4) {
        Map vehicleDispatchInfo = getVehicleDispatchInfo(str, str2, str3, str4);
        if (vehicleDispatchInfo == null) {
            return null;
        }
        return createVehicleDispatchTypeInfo(vehicleDispatchInfo);
    }

    public static Map getVehicleGPSInfo(String str, String str2, String str3, String str4) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        Firebase child = vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("locations").child(str4);
        PrintStream printStream = System.out;
        StringBuilder i0 = hj1.i0("ref ");
        i0.append(child.toString());
        printStream.println(i0.toString());
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(child);
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return null;
        }
        return (Map) synchronizedDataSnapshot.getValue();
    }

    private static String hackForBhopalVehiclesRef(String str, String str2) {
        if (str.equalsIgnoreCase("bhopal")) {
            return str2.toUpperCase();
        }
        return str2.toLowerCase();
    }

    /* access modifiers changed from: private */
    public static boolean isCheckedOut(DataSnapshot dataSnapshot, String str) {
        return (dataSnapshot.hasChild("streamId") ? (String) dataSnapshot.child("streamId").getValue() : null) == null && str != null;
    }

    /* access modifiers changed from: private */
    public static boolean isStreamAdded(DataSnapshot dataSnapshot, String str) {
        return (dataSnapshot.hasChild("streamId") ? (String) dataSnapshot.child("streamId").getValue() : "").equals(str);
    }

    private static boolean isVehicleValidForRouteDeviationCheckIn(String str) {
        PrintStream printStream = System.out;
        printStream.println("vehicle No  : " + str);
        if (str != null) {
            return str.equalsIgnoreCase("RJ14PC5985");
        }
        return false;
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

    /* access modifiers changed from: private */
    public static MutableData processCheckout(MutableData mutableData, long j, CheckOutType checkOutType, String str, String str2, String str3, String str4, String str5, VehicleDisapatchTypeInfo vehicleDisapatchTypeInfo, String str6) {
        mutableData.child("streamId").setValue((Object) null);
        mutableData.child(LoggingConstants.SESSION_START_TIME).setValue((Object) null);
        mutableData.child(LoggingConstants.ROUTE_ID).setValue((Object) null);
        mutableData.child("checkedIn").setValue(Boolean.FALSE);
        mutableData.child("timeStamp").setValue(Long.valueOf(j));
        return mutableData;
    }

    private static boolean toOverriteStatus(String str) {
        return str != null && !str.equalsIgnoreCase("") && !str.equalsIgnoreCase("Not Receiving Gps Data") && !str.equalsIgnoreCase("Not Running") && !str.equalsIgnoreCase("Not dispatched today");
    }

    private static Transaction.Handler tripEndTransactionHandler(final String str, final CheckOutType checkOutType, final Runnable runnable, final boolean z) {
        final long random = (long) (Math.random() * 1000000.0d);
        return new Transaction.Handler() {
            /* class server.zophop.dataLayer.Firebase.VehicleData.AnonymousClass4 */

            public Transaction.Result doTransaction(MutableData mutableData) {
                String str = (String) mutableData.child("streamId").getValue();
                if (str != null && str.equals(str)) {
                    VehicleData.updateStatus(mutableData, checkOutType, z);
                    return Transaction.success(VehicleData.clearSessionInfo(mutableData, random));
                } else if (str == null || str.equals(str)) {
                    return Transaction.success(mutableData);
                } else {
                    return Transaction.abort();
                }
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                if (firebaseError == null && z && VehicleData.checkout(dataSnapshot, random)) {
                    runnable.run();
                }
            }
        };
    }

    public static void updateCheckinCheckout(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Runnable runnable) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("dispatch").child(str4).runTransaction(getCheckinCheckoutHandler(str7, str5, str6, str8, str9, str10, runnable));
    }

    public static void updateCheckinInVehicleCheckinInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        Firebase child = vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("dispatch").child(str4);
        HashMap hashMap = new HashMap();
        hashMap.put("checkedIn", Boolean.TRUE);
        hashMap.put(LoggingConstants.ROUTE_ID, str5);
        hashMap.put("routeName", str6);
        hashMap.put(Constants.START_STOP_NAME, str7);
        hashMap.put(Constants.END_STOP_STOP_NAME, str8);
        hashMap.put("streamId", null);
        hashMap.put(LoggingConstants.SESSION_START_TIME, null);
        if (z) {
            hashMap.put("status", null);
        }
        hashMap.put("timeStamp", ServerValue.TIMESTAMP);
        hashMap.put("source", str9);
        SimpleLogger.warning("checkein status " + hashMap);
        child.updateChildren(hashMap);
    }

    /* access modifiers changed from: private */
    public static void updateStatus(MutableData mutableData, CheckOutType checkOutType, boolean z) {
        if (z && checkOutType != null) {
            if (checkOutType.equals(CheckOutType.autoRouteDeviation)) {
                mutableData.child("status").setValue(Constants.STATUS_DEVIATED);
            } else if (checkOutType.equals(CheckOutType.timeout)) {
                mutableData.child("status").setValue(Constants.STATUS_GPS_TIMEOUT);
            } else if (checkOutType.equals(CheckOutType.outOfServiceTime)) {
                mutableData.child("status").setValue(Constants.STATUS_OUT_OF_SERVICE_TIME);
            } else if (checkOutType.equals(CheckOutType.halt)) {
                mutableData.child("status").setValue(Constants.HALTED);
            } else {
                CheckOutType checkOutType2 = CheckOutType.dispatchAndroid;
                if (checkOutType.equals(checkOutType2)) {
                    mutableData.child("status").setValue(Constants.DISPATCH_ANDROID_REASON);
                } else if (checkOutType.equals(checkOutType2)) {
                    mutableData.child("status").setValue(Constants.MANUAL_CHECKOUT_REASON);
                } else if (checkOutType.equals(CheckOutType.dispatchWeb)) {
                    mutableData.child("status").setValue(Constants.MANUAL_CHECKOUT_REASON);
                } else {
                    mutableData.child("status").setValue(checkOutType.toString());
                }
            }
        }
    }

    public static void updateStreamIdInVehicleCheckinInfo(String str, String str2, String str3, String str4, String str5, long j, Runnable runnable) {
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("dispatch").child(str4).runTransaction(getStreamStartedTransactionHandler(str5, j, runnable));
    }

    public static void updateVehicleInformation(String str, String str2, String str3, String str4, Map map) {
        SimpleLogger.debug("vehicleInfo updated for vehicle no: " + str4);
        Firebase vehiclesRef = _firebaseRef.getVehiclesRef(str);
        vehiclesRef.child(str.toLowerCase()).child(str2.toLowerCase()).child(hackForBhopalVehiclesRef(str, str3)).child("locations").child(str4).updateChildren(map, new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.VehicleData.AnonymousClass2 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                VehicleData.printErrorDetails(firebaseError);
            }
        });
    }
}
