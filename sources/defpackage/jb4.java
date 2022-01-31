package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: jb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class jb4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1901a;
    public final Bundle b = new Bundle();
    public boolean c;
    public Bundle d;
    public final /* synthetic */ eb4 e;

    public jb4(eb4 eb4, String str) {
        this.e = eb4;
        gj1.j(str);
        this.f1901a = str;
    }

    public final Bundle a() {
        if (!this.c) {
            this.c = true;
            String string = this.e.v().getString(this.f1901a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string2 = jSONObject.getString("n");
                        String string3 = jSONObject.getString("t");
                        char c2 = 65535;
                        int hashCode = string3.hashCode();
                        if (hashCode != 100) {
                            if (hashCode != 108) {
                                if (hashCode == 115 && string3.equals("s")) {
                                    c2 = 0;
                                }
                            } else if (string3.equals("l")) {
                                c2 = 2;
                            }
                        } else if (string3.equals("d")) {
                            c2 = 1;
                        }
                        if (c2 == 0) {
                            bundle.putString(string2, jSONObject.getString("v"));
                        } else if (c2 == 1) {
                            bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                        } else if (c2 != 2) {
                            try {
                                this.e.g().f.b("Unrecognized persisted bundle type. Type", string3);
                            } catch (NumberFormatException | JSONException unused) {
                                this.e.g().f.a("Error reading value from SharedPreferences. Value dropped");
                            }
                        } else {
                            bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                        }
                    }
                    this.d = bundle;
                } catch (JSONException unused2) {
                    this.e.g().f.a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.d == null) {
                this.d = this.b;
            }
        }
        return this.d;
    }

    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.e.v().edit();
        if (bundle.size() == 0) {
            edit.remove(this.f1901a);
        } else {
            String str = this.f1901a;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.e.g().f.b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        this.e.g().f.b("Cannot serialize bundle value to SharedPreferences", e2);
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.d = bundle;
    }
}
