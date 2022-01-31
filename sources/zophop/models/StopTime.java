package zophop.models;

public class StopTime {
    private String platform;
    private String stopId;
    private int time;

    public String getPlatform() {
        return this.platform;
    }

    public String getStopId() {
        return this.stopId;
    }

    public int getTime() {
        return this.time;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setStopId(String str) {
        this.stopId = str;
    }

    public void setTime(int i) {
        this.time = i;
    }
}
