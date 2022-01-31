package app.zophop.pubsub;

public class Event<T> {
    private T _data;
    private String _failureReason;
    private final boolean _success;

    public Event(boolean z) {
        this._success = z;
    }

    public T getData() {
        return this._data;
    }

    public String getFailureReason() {
        return this._failureReason;
    }

    public boolean isSuccess() {
        return this._success;
    }

    public void setData(T t) {
        this._data = t;
    }

    public void setFailureReason(String str) {
        this._failureReason = str;
    }
}
