package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Base64;
import com.rabbitmq.client.StringRpcServer;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzaz {
    private static final wa2 zza = new wa2("JSONParser", new String[0]);

    public static Map<String, Object> zza(String str) {
        byte[] bArr;
        String str2;
        gj1.j(str);
        List<String> b = new un2(new q93(new ky2())).b(str);
        if (b.size() < 2) {
            wa2 wa2 = zza;
            if (str.length() != 0) {
                str2 = "Invalid idToken ".concat(str);
            } else {
                str2 = new String("Invalid idToken ");
            }
            wa2.b(str2, new Object[0]);
            return new HashMap();
        }
        String str3 = b.get(1);
        try {
            if (str3 == null) {
                bArr = null;
            } else {
                bArr = Base64.decode(str3, 11);
            }
            Map<String, Object> zzb = zzb(new String(bArr, StringRpcServer.STRING_ENCODING));
            return zzb == null ? new HashMap() : zzb;
        } catch (UnsupportedEncodingException unused) {
            zza.b("Unable to decode token", new Object[0]);
            return new HashMap();
        }
    }

    public static Map<String, Object> zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zzc(jSONObject);
            }
            return null;
        } catch (Exception e) {
            throw new xx2(e);
        }
    }

    public static Map<String, Object> zzc(JSONObject jSONObject) throws JSONException {
        n2 n2Var = new n2();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = zzd((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzc((JSONObject) obj);
            }
            n2Var.put(next, obj);
        }
        return n2Var;
    }

    public static List<Object> zzd(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = zzd((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzc((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
