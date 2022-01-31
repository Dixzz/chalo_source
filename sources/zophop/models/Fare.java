package zophop.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Fare implements Serializable {
    private static final long serialVersionUID = 1;
    public double default_fare;
    public ArrayList<FareTuple> fare_tuples = new ArrayList<>();
    public ArrayList<Integer> leg_index;
}
