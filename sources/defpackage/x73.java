package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.internal.p000firebaseauthapi.zzxe;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: x73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class x73 implements o53 {
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public final zzxe l = new zzxe(null);
    public final zzxe m = new zzxe(null);
    public String n;

    public final boolean a(String str) {
        gj1.j(str);
        return this.l.g.contains(str);
    }

    public final x73 b(String str) {
        if (str == null) {
            this.l.g.add("EMAIL");
        } else {
            this.h = str;
        }
        return this;
    }

    public final x73 c(String str) {
        if (str == null) {
            this.l.g.add("PASSWORD");
        } else {
            this.i = str;
        }
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // defpackage.o53
    public final String zza() throws JSONException {
        char c;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("returnSecureToken", true);
        if (!this.m.g.isEmpty()) {
            List<String> list = this.m.g;
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                jSONArray.put(list.get(i2));
            }
            jSONObject.put("deleteProvider", jSONArray);
        }
        List<String> list2 = this.l.g;
        int size = list2.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < list2.size(); i3++) {
            String str = list2.get(i3);
            int i4 = 2;
            switch (str.hashCode()) {
                case -333046776:
                    if (str.equals("DISPLAY_NAME")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1939891618:
                    if (str.equals("PHOTO_URL")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1999612571:
                    if (str.equals("PASSWORD")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                i4 = 1;
            } else if (c != 1) {
                i4 = c != 2 ? c != 3 ? 0 : 4 : 5;
            }
            iArr[i3] = i4;
        }
        if (size > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i5 = 0; i5 < size; i5++) {
                jSONArray2.put(iArr[i5]);
            }
            jSONObject.put("deleteAttribute", jSONArray2);
        }
        String str2 = this.f;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        String str3 = this.h;
        if (str3 != null) {
            jSONObject.put("email", str3);
        }
        String str4 = this.i;
        if (str4 != null) {
            jSONObject.put("password", str4);
        }
        String str5 = this.g;
        if (str5 != null) {
            jSONObject.put(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, str5);
        }
        String str6 = this.k;
        if (str6 != null) {
            jSONObject.put("photoUrl", str6);
        }
        String str7 = this.j;
        if (str7 != null) {
            jSONObject.put("oobCode", str7);
        }
        String str8 = this.n;
        if (str8 != null) {
            jSONObject.put("tenantId", str8);
        }
        return jSONObject.toString();
    }
}
