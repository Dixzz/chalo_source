package server.zophop.queue;

public class TaskEvent {
    private IQueueConsumer _queueConsumer;
    private BasicTask _task;
    private TaskMeta _taskMeta;

    public TaskEvent(IQueueConsumer iQueueConsumer, TaskMeta taskMeta, BasicTask basicTask) {
        this._queueConsumer = iQueueConsumer;
        this._taskMeta = taskMeta;
        this._task = basicTask;
    }

    public IQueueConsumer getQueueConsumer() {
        return this._queueConsumer;
    }

    public BasicTask getTask() {
        return this._task;
    }

    public TaskMeta getTaskMeta() {
        return this._taskMeta;
    }
}
