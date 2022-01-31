package defpackage;

import com.google.firebase.auth.ActionCodeSettings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: l73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class l73 implements o53 {
    public final String f;
    public String g;
    public String h;
    public String i;
    public ActionCodeSettings j;
    public String k;

    public l73(int i2) {
        this.f = i2 != 1 ? i2 != 4 ? i2 != 6 ? i2 != 7 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_BEFORE_UPDATE_EMAIL" : "EMAIL_SIGNIN" : "VERIFY_EMAIL" : "PASSWORD_RESET";
    }

    public l73(ActionCodeSettings actionCodeSettings, String str, String str2) {
        this.f = "VERIFY_BEFORE_UPDATE_EMAIL";
        this.j = actionCodeSettings;
        this.g = null;
        this.h = str;
        this.i = str2;
        this.k = null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // defpackage.o53
    public final String zza() throws JSONException {
        char c;
        JSONObject jSONObject = new JSONObject();
        String str = this.f;
        int i2 = 0;
        switch (str.hashCode()) {
            case -1452371317:
                if (str.equals("PASSWORD_RESET")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1341836234:
                if (str.equals("VERIFY_EMAIL")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1288726400:
                if (str.equals("VERIFY_BEFORE_UPDATE_EMAIL")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 870738373:
                if (str.equals("EMAIL_SIGNIN")) {
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
            i2 = 1;
        } else if (c == 1) {
            i2 = 4;
        } else if (c == 2) {
            i2 = 6;
        } else if (c == 3) {
            i2 = 7;
        }
        jSONObject.put("requestType", i2);
        String str2 = this.g;
        if (str2 != null) {
            jSONObject.put("email", str2);
        }
        String str3 = this.h;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.i;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        ActionCodeSettings actionCodeSettings = this.j;
        if (actionCodeSettings != null) {
            jSONObject.put("androidInstallApp", actionCodeSettings.getAndroidInstallApp());
            jSONObject.put("canHandleCodeInApp", this.j.canHandleCodeInApp());
            if (this.j.getUrl() != null) {
                jSONObject.put("continueUrl", this.j.getUrl());
            }
            if (this.j.getIOSBundle() != null) {
                jSONObject.put("iosBundleId", this.j.getIOSBundle());
            }
            if (this.j.zzb() != null) {
                jSONObject.put("iosAppStoreId", this.j.zzb());
            }
            if (this.j.getAndroidPackageName() != null) {
                jSONObject.put("androidPackageName", this.j.getAndroidPackageName());
            }
            if (this.j.getAndroidMinimumVersion() != null) {
                jSONObject.put("androidMinimumVersion", this.j.getAndroidMinimumVersion());
            }
            if (this.j.zzg() != null) {
                jSONObject.put("dynamicLinkDomain", this.j.zzg());
            }
        }
        String str5 = this.k;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        return jSONObject.toString();
    }
}
