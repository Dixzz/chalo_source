package server.zophop.queue;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.ServerValue;
import com.firebase.client.Transaction;
import com.google.common.eventbus.EventBus;
import com.google.firebase.database.core.ServerValues;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import server.zophop.Constants;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.exceptions.TaskMalformedException;

public class QueueConsumer implements IQueueConsumer<FirebaseTaskMeta> {
    public static final long THRESHOLD_TIME = 500;
    private Firebase _base;
    private int _count;
    private Firebase _errorSet;
    private EventBus _eventBus;
    private ExecutorService _executorService;
    private final int _maxCount;
    private final String _ownerId;
    private IQueue _queue = new Queue(this._base);
    private Map<String, Boolean> _taskMap;

    public QueueConsumer(Firebase firebase2, int i) {
        this._base = firebase2.child(Constants.QUEUE);
        this._errorSet = firebase2.child("error");
        this._maxCount = i;
        this._count = 0;
        this._taskMap = new ConcurrentHashMap();
        this._ownerId = UUID.randomUUID().toString();
    }

    private synchronized boolean decrement() {
        this._count--;
        Utils.print("decrement" + this._count);
        return true;
    }

    private ChildEventListener getListener() {
        return new ChildEventListener() {
            /* class server.zophop.queue.QueueConsumer.AnonymousClass1 */

            public void onCancelled(FirebaseError firebaseError) {
            }

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                if (!QueueConsumer.this.isUnderProgress(dataSnapshot)) {
                    dataSnapshot.getRef().runTransaction(QueueConsumer.this.getTransactionHandler(dataSnapshot.getKey()), false);
                }
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                if (!QueueConsumer.this.isUnderProgress(dataSnapshot)) {
                    dataSnapshot.getRef().runTransaction(QueueConsumer.this.getTransactionHandler(dataSnapshot.getKey()), false);
                }
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Transaction.Handler getTransactionHandler(final String str) {
        return new Transaction.Handler() {
            /* class server.zophop.queue.QueueConsumer.AnonymousClass2 */

            public Transaction.Result doTransaction(MutableData mutableData) {
                StringBuilder i0 = hj1.i0("task tried ");
                i0.append(str);
                Utils.print(i0.toString());
                if ((mutableData.child("timeStamp").getValue() == null ? -1 : ((Long) mutableData.child("timeStamp").getValue()).longValue()) == -1) {
                    StringBuilder i02 = hj1.i0("task already picked: ");
                    i02.append(str);
                    Utils.print(i02.toString());
                    return Transaction.abort();
                }
                StringBuilder i03 = hj1.i0("task picked transaction: ");
                i03.append(str);
                Utils.print(i03.toString());
                mutableData.child("timeStamp").setValue(-1L);
                mutableData.child(TaskKeys.LOCKED_AT).setValue(ServerValue.TIMESTAMP);
                mutableData.child(TaskKeys.OWNER).setValue(QueueConsumer.this._ownerId);
                mutableData.child(TaskKeys.TASK_TYPE).setValue(EventType.TASK_IN_USE.name());
                return Transaction.success(mutableData);
            }

            public void onComplete(FirebaseError firebaseError, boolean z, DataSnapshot dataSnapshot) {
                if (firebaseError == null && z) {
                    StringBuilder i0 = hj1.i0("task no error: ");
                    i0.append(dataSnapshot.getKey());
                    Utils.print(i0.toString());
                    if (QueueConsumer.this.isLocked(dataSnapshot) && QueueConsumer.this.isOwned(dataSnapshot)) {
                        FirebaseTaskMeta firebaseTaskMeta = new FirebaseTaskMeta(dataSnapshot.getKey());
                        if (QueueConsumer.this.increment(dataSnapshot.getKey())) {
                            StringBuilder i02 = hj1.i0("task picked: ");
                            i02.append(dataSnapshot.getKey());
                            Utils.print(i02.toString());
                            try {
                                Utils.print("try task1 : " + dataSnapshot.getKey());
                                Task fromSnapshot = TaskConvertor.fromSnapshot(dataSnapshot);
                                Utils.print("submitting 1 : " + dataSnapshot.getKey());
                                SimpleLogger.debug("submitting");
                                Utils.print("submitting 2 : " + dataSnapshot.getKey());
                                QueueConsumer.this.submitTask(firebaseTaskMeta, fromSnapshot);
                            } catch (TaskMalformedException unused) {
                                QueueConsumer.this._errorSet.child(dataSnapshot.getKey()).setValue(dataSnapshot.getValue());
                                QueueConsumer.this.removeTask(firebaseTaskMeta);
                            }
                        } else {
                            StringBuilder i03 = hj1.i0("task dropped: ");
                            i03.append(str);
                            Utils.print(i03.toString());
                            QueueConsumer.this._queue.resetTask(firebaseTaskMeta);
                        }
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized boolean increment(String str) {
        Utils.print("check" + this._count);
        if (this._count >= this._maxCount || this._taskMap.containsKey(str)) {
            return false;
        }
        this._count++;
        this._taskMap.put(str, Boolean.TRUE);
        Utils.print(ServerValues.NAME_OP_INCREMENT + this._count);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isLocked(DataSnapshot dataSnapshot) {
        return (dataSnapshot.child("timeStamp").getValue() == null ? -1 : ((Long) dataSnapshot.child("timeStamp").getValue()).longValue()) == -1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isOwned(DataSnapshot dataSnapshot) {
        if (!dataSnapshot.child(TaskKeys.OWNER).exists()) {
            return false;
        }
        return this._ownerId.equals((String) dataSnapshot.child(TaskKeys.OWNER).getValue());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isUnderProgress(DataSnapshot dataSnapshot) {
        return (dataSnapshot.child("timeStamp").getValue() == null ? -1 : ((Long) dataSnapshot.child("timeStamp").getValue()).longValue()) == -1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runTask(FirebaseTaskMeta firebaseTaskMeta, Task task) {
        this._eventBus.post(new TaskEvent(this, firebaseTaskMeta, task));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void submitTask(final FirebaseTaskMeta firebaseTaskMeta, final Task task) {
        SimpleLogger.debug("submitted");
        Utils.print("task processing " + firebaseTaskMeta.getTaskId());
        this._executorService.submit(new Runnable() {
            /* class server.zophop.queue.QueueConsumer.AnonymousClass3 */

            public void run() {
                QueueConsumer.this.runTask(firebaseTaskMeta, task);
            }
        });
    }

    @Override // server.zophop.queue.IQueueConsumer
    public void startListening(EventBus eventBus, ITaskHandler iTaskHandler) {
        this._executorService = Executors.newFixedThreadPool(5);
        this._eventBus = eventBus;
        this._base.orderByChild("timeStamp").startAt((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE).limitToFirst(1).addChildEventListener(getListener());
    }

    public void removeTask(FirebaseTaskMeta firebaseTaskMeta) {
        removeTaskLocal(firebaseTaskMeta);
        this._queue.removeTask(firebaseTaskMeta);
    }

    public void removeTaskLocal(FirebaseTaskMeta firebaseTaskMeta) {
        decrement();
        this._taskMap.remove(firebaseTaskMeta);
    }

    public void taskFailure(FirebaseTaskMeta firebaseTaskMeta, BasicTask basicTask) {
        Task task = (Task) basicTask;
        StringBuilder i0 = hj1.i0("task: ");
        i0.append(task.getType().name());
        i0.append(" failed");
        Utils.print(i0.toString());
        if (task.getRetries() > 5) {
            StringBuilder i02 = hj1.i0("task: ");
            i02.append(task.getType().name());
            i02.append(" limit crosed.");
            SimpleLogger.severe(i02.toString());
            removeTask(firebaseTaskMeta);
            return;
        }
        task.setTimeStamp(-2);
        task.setEventType(EventType.TASK_FAILED);
        task.setRetries(task.getRetries() + 1);
        this._queue.updateTask(firebaseTaskMeta, task);
        removeTaskLocal(firebaseTaskMeta);
    }

    public void taskSuccess(FirebaseTaskMeta firebaseTaskMeta, BasicTask basicTask) {
        StringBuilder i0 = hj1.i0("task: ");
        i0.append(basicTask.getType().name());
        i0.append(" ended successfully");
        Utils.print(i0.toString());
        removeTask(firebaseTaskMeta);
    }
}
