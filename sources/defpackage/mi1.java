package defpackage;

import android.net.Uri;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mi1  reason: default package */
/* compiled from: StopsAutoCompleteHelper */
public class mi1 extends ld1<Stop> {

    /* renamed from: a  reason: collision with root package name */
    public final TransitMode f2381a;

    public mi1(TransitMode transitMode) {
        this.f2381a = transitMode;
    }

    public List<Stop> b(String str) throws Exception {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new Stop(jSONObject.getString("stop_id"), jSONObject.getString("stop_name"), new LatLng(jSONObject.getDouble("stop_lat"), jSONObject.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject.getString("station_type"))));
        }
        return arrayList;
    }

    public String c(String str) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.d).appendPath(xt.f3961a.k().d().getName()).appendPath("autocomplete").appendPath("stop");
        builder.appendQueryParameter("str", str).appendQueryParameter("station_type", this.f2381a.toString());
        builder.appendQueryParameter("meta", ui1.K0().toString());
        builder.build().toString();
        return builder.build().toString();
    }

    public String d(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.d).appendPath(xt.f3961a.k().d().getName()).appendPath("autocompleteAgencyWise").appendPath("stop");
        builder.appendQueryParameter("str", str);
        builder.appendQueryParameter("station_type", this.f2381a.toString());
        builder.appendQueryParameter("agency", str2);
        builder.appendQueryParameter("meta", ui1.K0().toString());
        builder.build().toString();
        return builder.build().toString();
    }
}
