package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class InAppNotification implements Parcelable {
    public static final Pattern p = Pattern.compile("(\\.[^./]+$)");
    public final JSONObject f;
    public final JSONObject g;
    public final int h;
    public final int i;
    public final int j;
    public final String k;
    public final int l;
    public final String m;
    public final List<DisplayTrigger> n;
    public Bitmap o;

    public enum b {
        UNKNOWN {
            public String toString() {
                return "*unknown_type*";
            }
        },
        MINI {
            public String toString() {
                return "mini";
            }
        },
        TAKEOVER {
            public String toString() {
                return "takeover";
            }
        };
    }

    public InAppNotification() {
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
    }

    public static String e(String str, String str2) {
        Matcher matcher = p.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        return matcher.replaceFirst(str2 + "$1");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaign_id", this.h);
            jSONObject.put(Constants.MessagePayloadKeys.MSGID_SERVER, this.i);
            jSONObject.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, "inapp");
            jSONObject.put("message_subtype", b().toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public abstract b b();

    public boolean c() {
        List<DisplayTrigger> list = this.n;
        return list != null && !list.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(defpackage.ac5.a r7) {
        /*
            r6 = this;
            boolean r0 = r6.c()
            r1 = 0
            if (r0 == 0) goto L_0x004e
            java.util.List<com.mixpanel.android.mpmetrics.DisplayTrigger> r0 = r6.n
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            com.mixpanel.android.mpmetrics.DisplayTrigger r2 = (com.mixpanel.android.mpmetrics.DisplayTrigger) r2
            java.util.Objects.requireNonNull(r2)
            r3 = 1
            if (r7 == 0) goto L_0x004a
            java.lang.String r4 = r2.f
            java.lang.String r5 = "$any_event"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = r7.c
            java.lang.String r5 = r2.f
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x004a
        L_0x0033:
            ad5 r2 = r2.h
            if (r2 == 0) goto L_0x0048
            org.json.JSONObject r4 = r7.b     // Catch:{ Exception -> 0x004a }
            org.json.JSONObject r2 = r2.f153a     // Catch:{ Exception -> 0x004a }
            java.lang.Object r2 = defpackage.ad5.c(r2, r4)     // Catch:{ Exception -> 0x004a }
            java.lang.Boolean r2 = defpackage.ad5.e(r2)     // Catch:{ Exception -> 0x004a }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x004a }
            goto L_0x004b
        L_0x0048:
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            if (r2 == 0) goto L_0x000d
            return r3
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.InAppNotification.d(ac5$a):boolean");
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f.toString());
        parcel.writeString(this.g.toString());
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeParcelable(this.o, i2);
        parcel.writeList(this.n);
    }

    public InAppNotification(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
            try {
                jSONObject3 = new JSONObject(parcel.readString());
            } catch (JSONException unused) {
                jSONObject2 = jSONObject;
                jSONObject = jSONObject2;
                this.f = jSONObject;
                this.g = jSONObject3;
                this.h = parcel.readInt();
                this.i = parcel.readInt();
                this.j = parcel.readInt();
                this.k = parcel.readString();
                this.l = parcel.readInt();
                this.m = parcel.readString();
                this.o = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
                ArrayList arrayList = new ArrayList();
                this.n = arrayList;
                parcel.readList(arrayList, null);
            }
        } catch (JSONException unused2) {
            jSONObject = jSONObject2;
            this.f = jSONObject;
            this.g = jSONObject3;
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readString();
            this.l = parcel.readInt();
            this.m = parcel.readString();
            this.o = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            ArrayList arrayList2 = new ArrayList();
            this.n = arrayList2;
            parcel.readList(arrayList2, null);
        }
        this.f = jSONObject;
        this.g = jSONObject3;
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.o = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        ArrayList arrayList22 = new ArrayList();
        this.n = arrayList22;
        parcel.readList(arrayList22, null);
    }

    public InAppNotification(JSONObject jSONObject) throws bc5 {
        this.n = new ArrayList();
        try {
            this.f = jSONObject;
            this.g = jSONObject.getJSONObject("extras");
            this.h = jSONObject.getInt("id");
            this.i = jSONObject.getInt(Constants.MessagePayloadKeys.MSGID_SERVER);
            this.j = jSONObject.getInt("bg_color");
            this.k = hd3.n2(jSONObject, ProductPromotionsObject.KEY_BODY);
            this.l = jSONObject.optInt("body_color");
            this.m = jSONObject.getString("image_url");
            this.o = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
            JSONArray optJSONArray = jSONObject.optJSONArray("display_triggers");
            int i2 = 0;
            while (optJSONArray != null && i2 < optJSONArray.length()) {
                this.n.add(new DisplayTrigger(optJSONArray.getJSONObject(i2)));
                i2++;
            }
        } catch (JSONException e) {
            throw new bc5("Notification JSON was unexpected or bad", e);
        }
    }
}
