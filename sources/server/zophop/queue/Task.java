package server.zophop.queue;

import java.util.Map;
import server.zophop.TaskType;

public class Task extends BasicTask {
    private EventType _eventType = EventType.TASK_IN_USE;
    private long _lockedAt;
    private long _receivedAt;
    private long _retries = 0;
    private long _timeStamp;

    public Task(String str, long j, long j2, long j3, TaskType taskType, Map map) {
        super(str, taskType, map);
        this._userId = str;
        this._receivedAt = j;
        this._lockedAt = j2;
        this._timeStamp = j3;
    }

    public EventType getEventType() {
        return this._eventType;
    }

    public long getLockedAt() {
        return this._lockedAt;
    }

    public long getReceivedAt() {
        return this._receivedAt;
    }

    public long getRetries() {
        return this._retries;
    }

    public long getTimeStamp() {
        return this._timeStamp;
    }

    @Override // server.zophop.queue.BasicTask
    public String getUserId() {
        return this._userId;
    }

    public void setEventType(EventType eventType) {
        this._eventType = eventType;
    }

    public void setLockedAt(long j) {
        this._lockedAt = j;
    }

    public void setRetries(long j) {
        this._retries = j;
    }

    public void setTimeStamp(long j) {
        this._timeStamp = j;
    }
}
