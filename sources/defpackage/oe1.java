package defpackage;

import com.google.android.gms.maps.model.LatLng;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: oe1  reason: default package */
/* compiled from: LocationsProvider */
public class oe1 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LatLng f2680a;
    public final /* synthetic */ String b;
    public final /* synthetic */ le1 c;

    public oe1(le1 le1, LatLng latLng, String str) {
        this.c = le1;
        this.f2680a = latLng;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            this.c.k(jSONObject2.getJSONArray("results").getJSONObject(0).getString("formatted_address"), this.f2680a, ad1.SUCCESS, false, this.b);
        } catch (JSONException e) {
            e.toString();
            jSONObject2.toString();
            this.c.k(null, this.f2680a, ad1.FAILED, false, this.b);
        }
    }
}
