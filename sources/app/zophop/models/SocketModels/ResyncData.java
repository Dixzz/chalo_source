package app.zophop.models.SocketModels;

public class ResyncData {
    private final double randomizationFactor;
    private final int resyncTime;

    public ResyncData(int i, double d) {
        this.resyncTime = i;
        this.randomizationFactor = d;
    }

    public double getRandomizationFactor() {
        return this.randomizationFactor;
    }

    public int getResyncTime() {
        return this.resyncTime;
    }
}
