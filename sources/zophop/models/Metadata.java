package zophop.models;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metadata implements Cloneable {
    public Map agency_map = new HashMap();
    public boolean beta_mode;
    public Bound bound;
    public String bus_maps_url;
    public City city;
    public GpsPoint cityCentre;
    public String city_display_name;
    public String city_image_url;
    public Map city_info = new HashMap();
    public ArrayList<String> directions;
    public String firebase_live_url;
    public ArrayList<LineMap> line_maps = new ArrayList<>();
    public List modes_map = new ArrayList();
    public ArrayList<String> o;
    public ArrayList<String> special_features;
    public ArrayList<String> spf;
    public ArrayList<StationType> station_type = new ArrayList<>();

    public Metadata() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.directions = arrayList;
        arrayList.add("UP");
        this.directions.add("DN");
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.o = arrayList2;
        arrayList2.add(SettingsJsonConstants.APP_KEY);
        this.o.add("etim");
    }

    @Override // java.lang.Object
    public Metadata clone() {
        try {
            return (Metadata) super.clone();
        } catch (Exception unused) {
            return null;
        }
    }
}
