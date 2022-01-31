package app.zophop.models;

public class CityAvailability {
    private final String data;
    private final long expiryTime;
    private final boolean isSticky;
    private final boolean isVisible;
    private final String priority;

    public CityAvailability(String str, boolean z, boolean z2, String str2, long j) {
        this.priority = str;
        this.isSticky = z;
        this.isVisible = z2;
        this.data = str2;
        this.expiryTime = j;
    }

    public String getData() {
        return this.data;
    }

    public long getExpiryTime() {
        return this.expiryTime;
    }

    public String getPriority() {
        return this.priority;
    }

    public boolean isSticky() {
        return this.isSticky;
    }

    public boolean isVisible() {
        return this.isVisible;
    }
}
