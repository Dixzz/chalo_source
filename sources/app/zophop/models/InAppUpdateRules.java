package app.zophop.models;

public class InAppUpdateRules {
    private final String city;
    private final int endVersionCode;
    private final int startVersionCode;
    private final int updateType;

    public InAppUpdateRules(int i, int i2, int i3, String str) {
        this.updateType = i;
        this.startVersionCode = i2;
        this.endVersionCode = i3;
        this.city = str;
    }

    public String getCity() {
        return this.city;
    }

    public int getEndVersionCode() {
        return this.endVersionCode;
    }

    public int getStartVersionCode() {
        return this.startVersionCode;
    }

    public int getUpdateType() {
        return this.updateType;
    }
}
