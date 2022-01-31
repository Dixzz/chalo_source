package server.zophop.queue;

public interface ITaskHandler {
    void taskReceived(IQueueConsumer iQueueConsumer, BasicTask basicTask, TaskMeta taskMeta);
}
