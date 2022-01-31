package server.zophop.queue;

import com.firebase.client.Firebase;
import com.firebase.client.ServerValue;
import java.util.Map;
import server.zophop.TaskCategory;

public class Queue implements IQueue<FirebaseTaskMeta> {
    private final Firebase _queue;

    public Queue(Firebase firebase2) {
        this._queue = firebase2;
    }

    private Task getTask(BasicTask basicTask) {
        if (basicTask instanceof Task) {
            return (Task) basicTask;
        }
        return new Task(basicTask.getUserId(), 0, 0, 0, basicTask.getType(), basicTask.getData());
    }

    @Override // server.zophop.queue.IQueue
    public String addTask(BasicTask basicTask) {
        Map snapshot = TaskConvertor.toSnapshot(getTask(basicTask));
        snapshot.put(TaskKeys.RECEIVED_AT, ServerValue.TIMESTAMP);
        snapshot.put(TaskKeys.LOCKED_AT, ServerValue.TIMESTAMP);
        snapshot.put("timeStamp", ServerValue.TIMESTAMP);
        Firebase push = this._queue.push();
        push.setValue(snapshot);
        return push.getKey();
    }

    public void removeTask(FirebaseTaskMeta firebaseTaskMeta) {
        this._queue.child(firebaseTaskMeta.getTaskId()).removeValue();
    }

    public void resetTask(FirebaseTaskMeta firebaseTaskMeta) {
        this._queue.child(firebaseTaskMeta.getTaskId()).child("timeStamp").setValue(ServerValue.TIMESTAMP);
    }

    public void updateTask(FirebaseTaskMeta firebaseTaskMeta, BasicTask basicTask) {
        this._queue.child(firebaseTaskMeta.getTaskId()).setValue(TaskConvertor.toSnapshot(getTask(basicTask)));
    }

    @Override // server.zophop.queue.IQueue
    public String addTask(TaskCategory taskCategory, BasicTask basicTask) {
        return addTask(basicTask);
    }
}
