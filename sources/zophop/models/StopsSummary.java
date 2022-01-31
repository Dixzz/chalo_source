package zophop.models;

import java.util.ArrayList;

public class StopsSummary {
    public City city;
    public String stop_id;
    public ArrayList<String> trips;

    public String getUUID() {
        StringBuilder i0 = hj1.i0("STOPS_SUMMARY_");
        i0.append(this.city);
        i0.append("_");
        i0.append(this.stop_id);
        return i0.toString();
    }
}
