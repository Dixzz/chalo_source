package server.zophop.queue;

public class FirebaseTaskMeta extends TaskMeta {
    private String _taskId;

    public FirebaseTaskMeta(String str) {
        this._taskId = str;
    }

    public String getTaskId() {
        return this._taskId;
    }
}
