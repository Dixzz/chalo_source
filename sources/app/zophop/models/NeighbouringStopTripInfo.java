package app.zophop.models;

public class NeighbouringStopTripInfo extends k20 {
    public final int arrTime;
    public String depPlatform;
    public final int depTime;
    public final int freqM;
    public final String routeId;
    public final String tripId;

    public NeighbouringStopTripInfo(int i, int i2, String str, String str2, int i3) {
        this.depTime = i;
        this.arrTime = i2;
        this.tripId = str;
        this.routeId = str2;
        this.freqM = i3;
    }

    @Override // defpackage.k20
    public int getEdgeDjikstraWeight() {
        return this.arrTime;
    }

    public int compareTo(k20 k20) {
        return this.depTime - ((NeighbouringStopTripInfo) k20).depTime;
    }

    public NeighbouringStopTripInfo(double d, double d2, String str, String str2, int i) {
        this((int) Math.round(d), (int) Math.round(d2), str, str2, i);
    }
}
