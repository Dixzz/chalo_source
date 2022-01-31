package server.zophop.queue;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.Query;
import com.firebase.client.ServerValue;
import com.firebase.client.Transaction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import server.zophop.Constants;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.exceptions.TaskMalformedException;

public class UnfinishedTasks {
    private Firebase _base;
    private ExecutorService _executorService = Executors.newSingleThreadExecutor();
    private Firebase _queue;

    public UnfinishedTasks(Firebase firebase2) {
        this._base = firebase2;
        this._queue = firebase2.child(Constants.QUEUE);
    }

    private void checkStatus(DataSnapshot dataSnapshot) {
        if (dataSnapshot.getValue() != null) {
            dataSnapshot.getRef().runTransaction(getTransactionHandler(), false);
        }
    }

    private Transaction.Handler getTransactionHandler() {
        return new Transaction.Handler() {
            /* class server.zophop.queue.UnfinishedTasks.AnonymousClass1 */

            public Transaction.Result doTransaction(MutableData mutableData) {
                SimpleLogger.debug("try transaction Unfinished :");
                if (mutableData.child("timeStamp").getValue() != null) {
                    ((Long) mutableData.child("timeStamp").getValue()).longValue();
                }
                if (mutableData.getValue() == null) {
                    return Transaction.abort();
                }
                mutableData.child(TaskKeys.RECEIVED_AT).setValue(ServerValue.TIMESTAMP);
                mutableData.child(TaskKeys.OWNER).setValue((Object) null);
                return Transaction.success(mutableData);
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                SimpleLogger.info("transaction complete " + firebaseError + " boolean " + z);
                if (firebaseError == null && z) {
                    try {
                        final FirebaseTaskMeta firebaseTaskMeta = new FirebaseTaskMeta(dataSnapshot.getKey());
                        final Task fromSnapshot = TaskConvertor.fromSnapshot(dataSnapshot);
                        UnfinishedTasks.this._executorService.submit(new Runnable() {
                            /* class server.zophop.queue.UnfinishedTasks.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                UnfinishedTasks.this.runTask(firebaseTaskMeta, fromSnapshot);
                            }
                        });
                    } catch (TaskMalformedException e) {
                        SimpleLogger.logException(e);
                    }
                }
            }
        };
    }

    private void procesQuery(Query query) {
        try {
            for (DataSnapshot dataSnapshot : ((DataSnapshot) FirebaseUtils.getQuerySnapshot(query).get((long) Constants.THRESHOLD_TIMESTAMP, TimeUnit.SECONDS)).getChildren()) {
                checkStatus(dataSnapshot);
            }
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runTask(FirebaseTaskMeta firebaseTaskMeta, Task task) {
        if (task.getReceivedAt() > task.getLockedAt() + Constants.THRESHOLD_TIMESTAMP) {
            task.setTimeStamp(task.getReceivedAt());
        }
        task.setRetries(task.getRetries() + 1);
        if (task.getRetries() > 5) {
            new Queue(this._queue).removeTask((TaskMeta) firebaseTaskMeta);
        } else {
            new Queue(this._queue).updateTask((TaskMeta) firebaseTaskMeta, (BasicTask) task);
        }
        SimpleLogger.info("unFinished task recognised");
    }

    public void execute() {
        SimpleLogger.info("Zophop unfinished tasks");
        procesQuery(this._queue.orderByChild(TaskKeys.TASK_TYPE).equalTo(EventType.TASK_IN_USE.name()));
    }
}
