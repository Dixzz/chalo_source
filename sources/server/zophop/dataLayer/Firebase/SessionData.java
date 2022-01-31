package server.zophop.dataLayer.Firebase;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import java.util.Map;
import server.zophop.CS;
import server.zophop.models.FirebaseRef;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stream;
import server.zophop.models.StreamStatus;
import server.zophop.utils.DataMapCreator;
import server.zophop.utils.DataObjectCreator;

public class SessionData {
    private static DataMapCreator _dataMapCreator = new DataMapCreator();
    private static CS.ENVIRONMENT _environment;
    private static FirebaseRef _firebaseRef;

    public SessionData() {
        _firebaseRef = FirebaseRef.getInstance();
    }

    public static void changeStreamDestinationStop(String str, String str2, long j, String str3) {
        Firebase sessionsRef = _firebaseRef.getSessionsRef(str3);
        sessionsRef.child(str).child("destinationStopId").setValue(str2);
        sessionsRef.child(str).updateChildren(DataMapCreator.getStreamDestinationChangeMap(str2, j), new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.SessionData.AnonymousClass2 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                SessionData.printErrorDetails(firebaseError);
            }
        });
    }

    public static Stream getStream(String str, String str2) {
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(_firebaseRef.getSessionsRef(str2).child(str));
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return null;
        }
        return DataObjectCreator.extractStream(synchronizedDataSnapshot);
    }

    public static String getUniqueStreamId(String str) {
        return _firebaseRef.getSessionsRef(str).push().getKey();
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

    public static void storeStream(Stream stream, Route route) {
        Firebase sessionsRef = _firebaseRef.getSessionsRef(stream.getCity());
        Map streamMap = _dataMapCreator.getStreamMap(stream, stream.isVerified());
        if (!validateStream(stream, route)) {
            streamMap.put("status", StreamStatus.CLOSED.name());
        }
        StringBuilder i0 = hj1.i0("store stream: ");
        i0.append(stream.getStreamId());
        SimpleLogger.debug(i0.toString());
        sessionsRef.child(stream.getStreamId()).updateChildren(streamMap, new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.SessionData.AnonymousClass1 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                SessionData.printErrorDetails(firebaseError);
            }
        });
    }

    public static void storeStreamStatus(String str, String str2, String str3, String str4) {
        Firebase sessionsRef = _firebaseRef.getSessionsRef(str3);
        sessionsRef.child(str).updateChildren(DataMapCreator.getStoreStreamMap(str2, str4), new Firebase.CompletionListener() {
            /* class server.zophop.dataLayer.Firebase.SessionData.AnonymousClass3 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                SessionData.printErrorDetails(firebaseError);
            }
        });
    }

    public static boolean validateStream(Stream stream, Route route) {
        Integer index = route.getIndex(stream.getSourceStopId());
        if (index != null && index.intValue() != route.getStopSequence().size() - 1) {
            return true;
        }
        StringBuilder i0 = hj1.i0("Stream with id ");
        i0.append(stream.getUserId());
        i0.append(" not valid");
        SimpleLogger.severe(i0.toString());
        return false;
    }
}
