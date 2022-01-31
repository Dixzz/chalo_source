package com.urbanairship.push;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.ConnectionFactory;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PushMessage implements Parcelable, cu5 {
    public static final Parcelable.Creator<PushMessage> CREATOR = new a();
    public Bundle f;
    public final Map<String, String> g;
    public Uri h = null;

    public static class a implements Parcelable.Creator<PushMessage> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public PushMessage createFromParcel(Parcel parcel) {
            Bundle readBundle = parcel.readBundle(PushMessage.class.getClassLoader());
            if (readBundle == null) {
                readBundle = new Bundle();
            }
            return new PushMessage(readBundle);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public PushMessage[] newArray(int i) {
            return new PushMessage[i];
        }
    }

    public PushMessage(Bundle bundle) {
        this.f = bundle;
        this.g = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                this.g.put(str, String.valueOf(obj));
            }
        }
    }

    public Map<String, ActionValue> a() {
        String str = this.g.get("com.urbanairship.actions");
        HashMap hashMap = new HashMap();
        try {
            zt5 h2 = JsonValue.p(str).h();
            if (h2 != null) {
                Iterator<Map.Entry<String, JsonValue>> it = h2.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, JsonValue> next = it.next();
                    hashMap.put(next.getKey(), new ActionValue(next.getValue()));
                }
            }
            if (!hd3.G1(h())) {
                hashMap.put("^mc", new ActionValue(JsonValue.x(h())));
            }
            return hashMap;
        } catch (xt5 unused) {
            yj5.c("Unable to parse action payload: %s", str);
            return hashMap;
        }
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(this.g);
    }

    public String c() {
        return this.g.get("com.urbanairship.push.ALERT");
    }

    public String d(String str, String str2) {
        String str3 = this.g.get(str);
        return str3 == null ? str2 : str3;
    }

    public int describeContents() {
        return 0;
    }

    public int e(Context context, int i) {
        String str = this.g.get("com.urbanairship.icon");
        if (str != null) {
            int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            yj5.i("PushMessage - unable to find icon drawable with name: %s. Using default icon: %s", str, Integer.valueOf(i));
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.g.equals(((PushMessage) obj).g);
    }

    public String f() {
        return this.g.get("com.urbanairship.metadata");
    }

    public Bundle g() {
        if (this.f == null) {
            this.f = new Bundle();
            for (Map.Entry<String, String> entry : this.g.entrySet()) {
                this.f.putString(entry.getKey(), entry.getValue());
            }
        }
        return this.f;
    }

    public String h() {
        return this.g.get("_uamid");
    }

    public int hashCode() {
        return this.g.hashCode();
    }

    public String i() {
        return this.g.get("com.urbanairship.push.PUSH_ID");
    }

    @Deprecated
    public Uri j(Context context) {
        if (this.h == null && this.g.get("com.urbanairship.sound") != null) {
            String str = this.g.get("com.urbanairship.sound");
            int identifier = context.getResources().getIdentifier(str, "raw", context.getPackageName());
            if (identifier != 0) {
                StringBuilder i0 = hj1.i0("android.resource://");
                i0.append(context.getPackageName());
                i0.append(ConnectionFactory.DEFAULT_VHOST);
                i0.append(identifier);
                this.h = Uri.parse(i0.toString());
            } else if (!ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT.equals(str)) {
                yj5.i("PushMessage - unable to find notification sound with name: %s", str);
            }
        }
        return this.h;
    }

    public boolean l() {
        return this.g.containsKey("com.urbanairship.push.PUSH_ID") || this.g.containsKey("com.urbanairship.push.CANONICAL_PUSH_ID") || this.g.containsKey("com.urbanairship.metadata");
    }

    public boolean m() {
        return this.g.containsKey("com.urbanairship.remote-data.update");
    }

    public String toString() {
        return this.g.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(g());
    }

    public PushMessage(Map<String, String> map) {
        this.g = new HashMap(map);
    }
}
