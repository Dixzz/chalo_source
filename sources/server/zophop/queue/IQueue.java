package server.zophop.queue;

import server.zophop.TaskCategory;
import server.zophop.queue.TaskMeta;

public interface IQueue<T extends TaskMeta> {
    String addTask(TaskCategory taskCategory, BasicTask basicTask);

    String addTask(BasicTask basicTask);

    void removeTask(T t);

    void resetTask(T t);

    void updateTask(T t, BasicTask basicTask);
}
