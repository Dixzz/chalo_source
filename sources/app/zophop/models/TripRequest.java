package app.zophop.models;

import com.google.gson.Gson;

public abstract class TripRequest<T> {
    private final T _from;
    private final int _time;
    private final T _to;

    public TripRequest(T t, T t2, int i) {
        this._from = t;
        this._to = t2;
        this._time = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TripRequest tripRequest = (TripRequest) obj;
        if (this._time != tripRequest._time) {
            return false;
        }
        T t = this._from;
        if (t == null ? tripRequest._from != null : !t.equals(tripRequest._from)) {
            return false;
        }
        T t2 = this._to;
        T t3 = tripRequest._to;
        if (t2 != null) {
            return t2.equals(t3);
        }
        if (t3 == null) {
            return true;
        }
        return false;
    }

    public abstract String getDescription(T t);

    public T getFrom() {
        return this._from;
    }

    public int getTime() {
        return this._time;
    }

    public T getTo() {
        return this._to;
    }

    public int hashCode() {
        T t = this._from;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this._to;
        if (t2 != null) {
            i = t2.hashCode();
        }
        int i2 = this._time;
        return ((hashCode + i) * 31) + (i2 ^ (i2 >>> 32));
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
