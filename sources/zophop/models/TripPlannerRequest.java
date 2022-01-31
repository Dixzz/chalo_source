package zophop.models;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class TripPlannerRequest {
    public boolean ac;
    public boolean allow_road_leg;
    public boolean allow_road_transfers;
    public double bus_cost_factor;
    public City city;
    public Data data;
    public String day_of_week;
    public HashMap<String, Double> destinationDistanceMap;
    public HashMap<String, String> destinationPolylineMap;
    public HashSet<Integer> dimensions;
    public double from_lat;
    public double from_lon;
    public ArrayList<Stop> from_stops;
    public boolean isEtaRequested;
    public boolean isRegular;
    public boolean is_stop_tripplanner;
    public double max_non_transit_radius;
    public double max_taxi_distance;
    public double max_transfer_distance;
    public int max_transfers;
    public double max_walk_distance;
    public TravelMode mode;
    public double mode_transfer_cost;
    public boolean nonac;
    public int num_itineraries;
    public HashMap<String, Double> originDistanceMap;
    public HashMap<String, String> originPolylineMap;
    public String owner;
    public String request_id = UUID.randomUUID().toString();
    public long request_start_time;
    public int road_transfer_time;
    public String sort_by;
    public int start_time;
    public StationType station_type;
    public double taxi_cost_factor;
    public double taxi_speed;
    public int time_limit;
    public double time_threshold_ratio;
    public double to_lat;
    public double to_lon;
    public ArrayList<Stop> to_stops;
    public double train_cost_factor;
    public double transfer_cost;
    public int transfer_time;
    public double walk_cost_factor;
    public double walk_speed;

    public String toString() {
        return new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            /* class zophop.models.TripPlannerRequest.AnonymousClass1 */

            @Override // com.google.gson.ExclusionStrategy
            public boolean shouldSkipClass(Class<?> cls) {
                return false;
            }

            @Override // com.google.gson.ExclusionStrategy
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return fieldAttributes.getDeclaringClass() == TripPlannerRequest.class && fieldAttributes.getName().equals("data");
            }
        }).create().toJson(this);
    }
}
