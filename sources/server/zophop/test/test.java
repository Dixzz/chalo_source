package server.zophop.test;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import edu.emory.mathcs.backport.java.util.concurrent.CountDownLatch;
import java.util.HashMap;
import server.zophop.Constants;
import server.zophop.TaskType;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.Task;
import server.zophop.queue.TaskConvertor;

public class test {
    public static Firebase _firebase = new Firebase(Constants.FIREBASE_DUMMY).child("production").child("test");

    public static void main(String[] strArr) {
        for (int i = 0; i < 50; i++) {
            try {
                read();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    SimpleLogger.logException(e);
                }
                SimpleLogger.info(i + "th task pushed");
            } catch (Exception e2) {
                SimpleLogger.logException(e2);
            } catch (Throwable th) {
                SimpleLogger.info("done...");
                throw th;
            }
        }
        SimpleLogger.info("done...");
    }

    public static void read() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        HashMap m0 = hj1.m0("name", "xzy");
        m0.put("age", 13);
        m0.put("loc", Double.valueOf(34.4d));
        long currentTimeMillis = System.currentTimeMillis();
        _firebase.child(Constants.QUEUE).push().setValue(TaskConvertor.toSnapshot(new Task("abc", currentTimeMillis, currentTimeMillis, currentTimeMillis, TaskType.REMOVE_STREAM, m0)), new Firebase.CompletionListener() {
            /* class server.zophop.test.test.AnonymousClass1 */

            public void onComplete(FirebaseError firebaseError, Firebase firebase2) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }
}
