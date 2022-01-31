package server.zophop.dataLayer.Firebase;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import server.zophop.Constants;
import server.zophop.models.SimpleLogger;

public class FirebaseUtils {
    public static SettableFuture<DataSnapshot> getQuerySnapshot(Query query) {
        final SettableFuture<DataSnapshot> create = SettableFuture.create();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            /* class server.zophop.dataLayer.Firebase.FirebaseUtils.AnonymousClass2 */

            public void onCancelled(FirebaseError firebaseError) {
                SimpleLogger.info(firebaseError.toString());
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                create.set(dataSnapshot);
            }
        });
        return create;
    }

    public static SettableFuture<DataSnapshot> getSnapshotFromFireBase(Firebase firebase2) {
        final SettableFuture<DataSnapshot> create = SettableFuture.create();
        firebase2.addListenerForSingleValueEvent(new ValueEventListener() {
            /* class server.zophop.dataLayer.Firebase.FirebaseUtils.AnonymousClass1 */

            public void onCancelled(FirebaseError firebaseError) {
                create.set((Object) null);
                SimpleLogger.info(firebaseError.toString());
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                create.set(dataSnapshot);
            }
        });
        return create;
    }

    public static DataSnapshot getSynchronizedDataSnapshot(Firebase firebase2) {
        try {
            return (DataSnapshot) getSnapshotFromFireBase(firebase2).get((long) Constants.THRESHOLD_TIMESTAMP, TimeUnit.SECONDS);
        } catch (Exception e) {
            SimpleLogger.logException(e);
            return null;
        }
    }

    public static boolean moveFirebaseRecord(Firebase firebase2, Firebase firebase3) {
        DataSnapshot synchronizedDataSnapshot = getSynchronizedDataSnapshot(firebase2);
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return false;
        }
        Map map = (Map) synchronizedDataSnapshot.getValue();
        System.out.println(map.toString());
        storeInFirebase(firebase3, map);
        return true;
    }

    public static boolean removeRecord(final Firebase firebase2) {
        firebase2.removeValue(new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.FirebaseUtils.AnonymousClass4 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                StringBuilder i0 = hj1.i0("Session remove");
                i0.append(firebase2.toString());
                SimpleLogger.info(i0.toString());
            }
        });
        return true;
    }

    private static SettableFuture<String> store(Firebase firebase2, Map map) {
        final SettableFuture<String> create = SettableFuture.create();
        firebase2.updateChildren(map, new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.FirebaseUtils.AnonymousClass3 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                create.set("success");
            }
        });
        return create;
    }

    public static void storeInFirebase(Firebase firebase2, Map map) {
        try {
            String str = (String) store(firebase2, map).get((long) Constants.THRESHOLD_TIMESTAMP, TimeUnit.SECONDS);
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }
}
