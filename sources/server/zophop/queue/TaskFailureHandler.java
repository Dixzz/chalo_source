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
import server.zophop.Constants;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.exceptions.TaskMalformedException;

public class TaskFailureHandler {
    private Firebase _base;
    private ExecutorService _executorService = Executors.newSingleThreadExecutor();
    private Firebase _queue;

    public TaskFailureHandler(Firebase firebase2) {
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
            /* class server.zophop.queue.TaskFailureHandler.AnonymousClass1 */

            public Transaction.Result doTransaction(MutableData mutableData) {
                StringBuilder i0 = hj1.i0("try transaction for task failure: ");
                i0.append(mutableData.getValue());
                SimpleLogger.severe(i0.toString());
                if (mutableData.getValue() == null) {
                    return Transaction.abort();
                }
                SimpleLogger.info(String.valueOf(mutableData));
                long longValue = ((Long) mutableData.child(TaskKeys.LOCKED_AT).getValue()).longValue();
                mutableData.child(TaskKeys.LOCKED_AT).setValue(ServerValue.TIMESTAMP);
                mutableData.child("timeStamp").setValue(Long.valueOf(longValue));
                return Transaction.success(mutableData);
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                SimpleLogger.severe("transaction complete " + firebaseError);
                if (firebaseError == null && z) {
                    try {
                        final FirebaseTaskMeta firebaseTaskMeta = new FirebaseTaskMeta(dataSnapshot.getKey());
                        final Task fromSnapshot = TaskConvertor.fromSnapshot(dataSnapshot);
                        SimpleLogger.info(String.valueOf(dataSnapshot));
                        TaskFailureHandler.this._executorService.submit(new Runnable() {
                            /* class server.zophop.queue.TaskFailureHandler.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                TaskFailureHandler.this.runTask(firebaseTaskMeta, fromSnapshot);
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
            for (DataSnapshot dataSnapshot : ((DataSnapshot) FirebaseUtils.getQuerySnapshot(query).get()).getChildren()) {
                checkStatus(dataSnapshot);
            }
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runTask(FirebaseTaskMeta firebaseTaskMeta, Task task) {
        SimpleLogger.info("task fetched");
        long retries = task.getRetries() + 1;
        if ((500 * retries) + task.getTimeStamp() < task.getLockedAt()) {
            task.setTimeStamp(task.getLockedAt());
            task.setRetries(retries);
            if (task.getRetries() > 5) {
                new Queue(this._queue).removeTask((TaskMeta) firebaseTaskMeta);
            } else {
                new Queue(this._queue).updateTask((TaskMeta) firebaseTaskMeta, (BasicTask) task);
            }
        }
    }

    public void execute() {
        StringBuilder i0 = hj1.i0("Zophop job executed :");
        i0.append(System.currentTimeMillis());
        SimpleLogger.info(i0.toString());
        procesQuery(this._queue.orderByChild(TaskKeys.TASK_TYPE).equalTo(EventType.TASK_FAILED.name()));
    }
}
