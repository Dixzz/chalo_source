package zophop.models;

import java.util.ArrayList;

public class PassDetails {
    public String endStopId;
    public int fare;
    public String fromStopId;
    public boolean isMultiple;
    public ArrayList<RouteDetails> routes;
    public ArrayList<PassDetails> subPasses;
}
