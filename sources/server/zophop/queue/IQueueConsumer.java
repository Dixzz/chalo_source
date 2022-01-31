package server.zophop.queue;

import com.google.common.eventbus.EventBus;
import server.zophop.queue.TaskMeta;

public interface IQueueConsumer<T extends TaskMeta> {
    void removeTask(T t);

    void removeTaskLocal(T t);

    void startListening(EventBus eventBus, ITaskHandler iTaskHandler);

    void taskFailure(T t, BasicTask basicTask);

    void taskSuccess(T t, BasicTask basicTask);
}
