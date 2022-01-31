package server.zophop.queue;

import java.util.Map;
import server.zophop.TaskType;

public class BasicTask {
    public Map _data;
    public TaskType _type;
    public String _userId;

    public BasicTask(String str, TaskType taskType, Map map) {
        this._userId = str;
        this._type = taskType;
        this._data = map;
    }

    public Map getData() {
        return this._data;
    }

    public TaskType getType() {
        return this._type;
    }

    public String getUserId() {
        return this._userId;
    }
}
