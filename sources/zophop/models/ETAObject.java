package zophop.models;

public class ETAObject {
    public long time;
    public Stop to_stop;

    public ETAObject(long j, Stop stop) {
        this.time = j;
        this.to_stop = stop;
    }
}
