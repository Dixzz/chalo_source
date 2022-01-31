package defpackage;

import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithExtras;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.FavType;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.RouteSubscriptionInfo;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.StopFavourite;
import app.zophop.models.Favourites.TripFavourite;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: mv  reason: default package */
/* compiled from: FavoriteConverter */
public class mv {
    public BusFavourite a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("_routeId");
        String string2 = jSONObject.getString("_routeName");
        String string3 = jSONObject.getString("_startStopName");
        boolean z = jSONObject.getBoolean("isFreeRide");
        String string4 = jSONObject.getString("_endStopName");
        String string5 = jSONObject.getString("_id");
        long optLong = jSONObject.optLong("access_time", 0);
        String optString = jSONObject.optString("agency", null);
        String optString2 = jSONObject.optString("routeStoreType", RouteStoreType.FAVORITE.toString());
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("spfArray")) {
            JSONArray jSONArray = jSONObject.getJSONArray("spfArray");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        BusFavourite busFavourite = new BusFavourite(string, string2, string3, string4, string5, optLong, RouteStoreType.valueOf(optString2), optString, arrayList, z);
        int i2 = jSONObject.getInt("_accessCount");
        for (int i3 = 0; i3 < i2; i3++) {
            busFavourite.increaseAccessCount();
        }
        return busFavourite;
    }

    public BusFavouriteWithExtras b(String str) throws JSONException {
        BusFavourite a2 = a(str);
        JSONObject jSONObject = new JSONObject(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        if (jSONObject.has("_specialFeatureArray")) {
            JSONArray jSONArray = jSONObject.getJSONArray("_specialFeatureArray");
            int i2 = 0;
            while (jSONArray != null && i2 < jSONArray.length()) {
                arrayList.add(SPECIAL_FEATURE.valueOf(jSONArray.getString(i2)));
                i2++;
            }
        }
        if (jSONObject.has("spfArray")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("spfArray");
            while (jSONArray2 != null && i < jSONArray2.length()) {
                arrayList2.add(jSONArray2.getString(i));
                i++;
            }
        }
        return new BusFavouriteWithExtras(a2.getRouteId(), a2.getRouteName(), a2.getStartStopName(), a2.getEndStopName(), a2.getId(), a2.getTime(), a2.getRouteStoreType(), a2.getAgency(), arrayList, arrayList2, a2.is_isFreeRideAvailable());
    }

    public JSONObject c(BusFavourite busFavourite) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", busFavourite.getId());
        jSONObject.put("_routeId", busFavourite.getRouteId());
        jSONObject.put("_routeName", busFavourite.getRouteName());
        jSONObject.put("_startStopName", busFavourite.getStartStopName());
        jSONObject.put("isFreeRide", busFavourite.is_isFreeRideAvailable());
        jSONObject.put("_endStopName", busFavourite.getEndStopName());
        jSONObject.put("_accessCount", busFavourite.getAccessCount());
        jSONObject.put("routeStoreType", busFavourite.getRouteStoreType().toString());
        jSONObject.put("access_time", String.valueOf(busFavourite.getTime()));
        if (busFavourite.getAgency() != null) {
            jSONObject.put("agency", busFavourite.getAgency());
        }
        if (busFavourite.get_spfList() != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : busFavourite.get_spfList()) {
                jSONArray.put(str);
            }
            jSONObject.put("spfArray", jSONArray);
        }
        return jSONObject;
    }

    public JSONObject d(BusFavouriteWithSubscription busFavouriteWithSubscription) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", busFavouriteWithSubscription.getId());
        jSONObject.put("_routeId", busFavouriteWithSubscription.getRouteId());
        jSONObject.put("_routeName", busFavouriteWithSubscription.getRouteName());
        jSONObject.put("_startStopName", busFavouriteWithSubscription.getStartStopName());
        jSONObject.put("_endStopName", busFavouriteWithSubscription.getEndStopName());
        jSONObject.put("_accessCount", busFavouriteWithSubscription.getAccessCount());
        jSONObject.put("routeStoreType", busFavouriteWithSubscription.getRouteStoreType().toString());
        jSONObject.put("access_time", String.valueOf(busFavouriteWithSubscription.getTime()));
        jSONObject.put("subscribed_stop", j(busFavouriteWithSubscription.getSubscribedStop()));
        jSONObject.put("subscribed_time", busFavouriteWithSubscription.getSubscriptionTime());
        jSONObject.put("alarm_code", busFavouriteWithSubscription.getAlarmCode());
        if (busFavouriteWithSubscription.getAgency() != null) {
            jSONObject.put("agency", busFavouriteWithSubscription.getAgency());
        }
        return jSONObject;
    }

    public JSONObject e(RailFavourite railFavourite) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", railFavourite.getId());
        jSONObject.put("_mode", railFavourite.getMode().toString());
        jSONObject.put("_accessCount", railFavourite.getAccessCount());
        jSONObject.put("_fromStop", j(railFavourite.getFromStop()));
        jSONObject.put("_toStop", j(railFavourite.getToStop()));
        jSONObject.put("routeStoreType", railFavourite.getRouteStoreType().toString());
        jSONObject.put("access_time", railFavourite.getTime());
        return jSONObject;
    }

    public JSONObject f(StopFavourite stopFavourite) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", stopFavourite.getId());
        jSONObject.put("access_time", stopFavourite.getTime());
        jSONObject.put("_accessCount", stopFavourite.getAccessCount());
        jSONObject.put("routeStoreType", stopFavourite.getRouteStoreType().toString());
        jSONObject.put("stop", j(stopFavourite.getStop()));
        return jSONObject;
    }

    public JSONObject g(RouteSubscriptionInfo routeSubscriptionInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_routeId", routeSubscriptionInfo.getRouteId());
        jSONObject.put("_routeDetailsViewCount", routeSubscriptionInfo.getRouteDetailsViewCount());
        jSONObject.put("_routeDetailsLastSeen", routeSubscriptionInfo.getRouteDetailsLastSeen());
        jSONObject.put("_isAutoSubscriptionDialogShown", routeSubscriptionInfo.isIsAutoSubscriptionDialogShown());
        return jSONObject;
    }

    public JSONObject h(StopBasedTripFavourite stopBasedTripFavourite) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", stopBasedTripFavourite.getId());
        jSONObject.put("_mode", stopBasedTripFavourite.getMode().toString());
        jSONObject.put("access_time", stopBasedTripFavourite.getTime());
        jSONObject.put("routeStoreType", stopBasedTripFavourite.getRouteStoreType().name());
        jSONObject.put("favoriteType", stopBasedTripFavourite.getType().name());
        jSONObject.put("originStop", stopBasedTripFavourite.getOriginStop().toJSON());
        jSONObject.put("destinationStop", stopBasedTripFavourite.getDestinationStop().toJSON());
        return jSONObject;
    }

    public JSONObject i(TripFavourite tripFavourite) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", tripFavourite.getId());
        jSONObject.put("_mode", tripFavourite.getMode().toString());
        jSONObject.put("access_time", tripFavourite.getTime());
        jSONObject.put("routeStoreType", tripFavourite.getRouteStoreType().name());
        jSONObject.put("favoriteType", tripFavourite.getType().name());
        jSONObject.put("fromDescriptiveLocation", tripFavourite.getFrom().b());
        jSONObject.put("toDescriptiveLocation", tripFavourite.getTo().b());
        return jSONObject;
    }

    public final String j(Stop stop) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", stop.getId());
        jSONObject.put("_name", stop.getName());
        jSONObject.put("_stopLat", stop.getLatLong().latitude);
        jSONObject.put("_stopLon", stop.getLatLong().longitude);
        jSONObject.put("_mode", stop.getMode().toString());
        return jSONObject.toString();
    }

    public RailFavourite k(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        TransitMode transitMode = TransitMode.getTransitMode(jSONObject.getString("_mode"));
        RailFavourite railFavourite = new RailFavourite(o(jSONObject.getString("_fromStop")), o(jSONObject.getString("_toStop")), jSONObject.getString("_id"), transitMode, jSONObject.optLong("access_time", 0), RouteStoreType.valueOf(jSONObject.optString("routeStoreType", RouteStoreType.FAVORITE.toString())));
        int i = jSONObject.getInt("_accessCount");
        for (int i2 = 0; i2 < i; i2++) {
            railFavourite.increaseAccessCount();
        }
        return railFavourite;
    }

    public RouteSubscriptionInfo l(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        RouteSubscriptionInfo routeSubscriptionInfo = new RouteSubscriptionInfo();
        routeSubscriptionInfo.setRouteId(jSONObject.getString("_routeId"));
        routeSubscriptionInfo.setRouteDetailsViewCount(jSONObject.getInt("_routeDetailsViewCount"));
        routeSubscriptionInfo.setRouteDetailsLastSeen(jSONObject.getLong("_routeDetailsLastSeen"));
        routeSubscriptionInfo.setIsAutoSubscriptionDialogShown(jSONObject.getBoolean("_isAutoSubscriptionDialogShown"));
        return routeSubscriptionInfo;
    }

    public StopBasedTripFavourite m(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new StopBasedTripFavourite(FavType.valueOf(jSONObject.getString("favoriteType")), jSONObject.getString("_id"), TransitMode.getTransitMode(jSONObject.getString("_mode")), jSONObject.getLong("access_time"), RouteStoreType.valueOf(jSONObject.getString("routeStoreType")), Stop.fromJson(jSONObject.getString("originStop")), Stop.fromJson(jSONObject.getString("destinationStop")));
    }

    public StopFavourite n(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("_id");
        long optLong = jSONObject.optLong("access_time", 0);
        int i = jSONObject.getInt("_accessCount");
        StopFavourite stopFavourite = new StopFavourite(o(jSONObject.getString("stop")), string, optLong, RouteStoreType.valueOf(jSONObject.optString("routeStoreType", RouteStoreType.RECENT.toString())));
        for (int i2 = 0; i2 < i; i2++) {
            stopFavourite.increaseAccessCount();
        }
        return stopFavourite;
    }

    public final Stop o(String str) throws JSONException {
        LatLng latLng;
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("_id");
        String string2 = jSONObject.getString("_name");
        String string3 = jSONObject.getString("_mode");
        if (r(str)) {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("_latLong"));
            if (jSONObject2.has("a")) {
                latLng = new LatLng(jSONObject2.getDouble("a"), jSONObject2.getDouble("b"));
            } else {
                latLng = new LatLng(jSONObject2.getDouble("b"), jSONObject2.getDouble("c"));
            }
        } else {
            latLng = new LatLng(Double.parseDouble(jSONObject.getString("_stopLat")), Double.parseDouble(jSONObject.getString("_stopLon")));
        }
        return new Stop(string, string2, latLng, TransitMode.getTransitMode(string3));
    }

    public BusFavouriteWithSubscription p(String str) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject(str);
        String string = jSONObject2.getString("_routeId");
        String string2 = jSONObject2.getString("_routeName");
        String string3 = jSONObject2.getString("_startStopName");
        String string4 = jSONObject2.getString("_endStopName");
        String string5 = jSONObject2.getString("_id");
        long optLong = jSONObject2.optLong("access_time", 0);
        int i = jSONObject2.getInt("alarm_code");
        Stop o = o(jSONObject2.getString("subscribed_stop"));
        int i2 = jSONObject2.getInt("subscribed_time");
        RouteStoreType valueOf = RouteStoreType.valueOf(jSONObject2.optString("routeStoreType", RouteStoreType.SUBSCRIBED.toString()));
        String optString = jSONObject2.optString("agency");
        ArrayList arrayList = new ArrayList();
        if (jSONObject2.has("_specialFeatureArray")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("spfArray");
            jSONObject = jSONObject2;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
        } else {
            jSONObject = jSONObject2;
        }
        BusFavouriteWithSubscription busFavouriteWithSubscription = new BusFavouriteWithSubscription(string, string2, string3, string4, string5, optLong, valueOf, o, i2, i, optString, arrayList, false);
        int i4 = jSONObject.getInt("_accessCount");
        for (int i5 = 0; i5 < i4; i5++) {
            busFavouriteWithSubscription.increaseAccessCount();
        }
        return busFavouriteWithSubscription;
    }

    public TripFavourite q(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new TripFavourite(FavType.valueOf(jSONObject.getString("favoriteType")), mf1.a(jSONObject.getString("fromDescriptiveLocation")), mf1.a(jSONObject.getString("toDescriptiveLocation")), jSONObject.getString("_id"), TransitMode.getTransitMode(jSONObject.getString("_mode")), jSONObject.getLong("access_time"), RouteStoreType.valueOf(jSONObject.getString("routeStoreType")));
    }

    public boolean r(String str) throws JSONException {
        return new JSONObject(str).has("_latLong");
    }
}
