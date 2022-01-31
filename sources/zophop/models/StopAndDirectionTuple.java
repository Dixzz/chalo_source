package zophop.models;

public class StopAndDirectionTuple {
    public String last_stop_id;
    public String stop_id;

    public boolean equals(Object obj) {
        if (!(obj instanceof StopAndDirectionTuple)) {
            return false;
        }
        StopAndDirectionTuple stopAndDirectionTuple = (StopAndDirectionTuple) obj;
        if (stopAndDirectionTuple.last_stop_id.equals(this.last_stop_id) && stopAndDirectionTuple.stop_id.equals(this.stop_id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.stop_id + this.last_stop_id).hashCode();
    }
}
