package app.zophop.utilities.models;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppMessageDetails implements Parcelable {
    public static final Parcelable.Creator<InAppMessageDetails> CREATOR = new a();
    public static String g;
    public static int h;
    public static int i;
    public static int j;
    public static int k;
    public static int l;
    public static String m;
    public static String n;
    public static int o;
    public static int p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public String f;

    public class a implements Parcelable.Creator<InAppMessageDetails> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public InAppMessageDetails createFromParcel(Parcel parcel) {
            return new InAppMessageDetails();
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public InAppMessageDetails[] newArray(int i) {
            return new InAppMessageDetails[i];
        }
    }

    public InAppMessageDetails(String str) {
        this.f = str;
        try {
            JSONObject jSONObject = new JSONObject(str.substring(str.indexOf("{"), str.lastIndexOf("}") + 1));
            jSONObject.optString("notification_type", "");
            h = jSONObject.optInt("alignment");
            g = jSONObject.optString("id", "");
            i = jSONObject.optInt("imageVisibility");
            s = jSONObject.optString("imageUrl");
            j = jSONObject.optInt("titleVisibility");
            q = jSONObject.optString("titleText");
            r = jSONObject.optString("subtitleText");
            k = jSONObject.optInt("subtitleVisibility");
            l = jSONObject.optInt("buttonVisibility");
            n = jSONObject.optString("buttonCta");
            m = jSONObject.optString("buttonText");
            o = jSONObject.optInt("positiveBtnVisibility");
            t = jSONObject.optString("positiveBtnText");
            u = jSONObject.optString("negativeBtnText");
            p = jSONObject.optInt("negativeBtnVisibility");
            v = jSONObject.optString("positiveBtnCta");
            w = jSONObject.optString("negativeBtnCta");
            p = jSONObject.optInt("negativeBtnVisibility");
            u = jSONObject.optString("negativeBtnText");
        } catch (JSONException e) {
            e.toString();
        }
    }

    public int a() {
        return l == 0 ? 8 : 1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }

    public InAppMessageDetails(Bundle bundle) {
        if (bundle != null) {
            String str = "inside jsonObject" + bundle;
            g = bundle.getString("id", "id");
            bundle.getString("notification_type", "");
            h = Integer.parseInt((String) bundle.get("alignment"));
            i = Integer.parseInt((String) bundle.get("imageVisibility"));
            s = bundle.getString("imageUrl");
            j = Integer.parseInt((String) bundle.get("titleVisibility"));
            q = bundle.getString("titleText");
            r = bundle.getString("subtitleText");
            k = Integer.parseInt((String) bundle.get("subtitleVisibility"));
            l = Integer.parseInt((String) bundle.get("buttonVisibility"));
            n = bundle.getString("buttonCta");
            m = bundle.getString("buttonText");
            o = Integer.parseInt((String) bundle.get("positiveBtnVisibility"));
            t = bundle.getString("positiveBtnText");
            u = bundle.getString("negativeBtnText");
            p = Integer.parseInt((String) bundle.get("negativeBtnVisibility"));
            v = bundle.getString("positiveBtnCta");
            w = bundle.getString("negativeBtnCta");
            p = Integer.parseInt((String) bundle.get("negativeBtnVisibility"));
            u = bundle.getString("negativeBtnText");
        }
    }

    public InAppMessageDetails() {
    }
}
