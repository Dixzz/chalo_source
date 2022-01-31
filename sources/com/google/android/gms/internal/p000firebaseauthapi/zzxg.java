package com.google.android.gms.internal.p000firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.beta.CheckForUpdatesResponseTransform;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.internal.zzi;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzxg extends AbstractSafeParcelable implements o53 {
    public static final Parcelable.Creator<zzxg> CREATOR = new h83();
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public String s;
    public boolean t;
    public String u;

    public zzxg() {
        this.n = true;
        this.o = true;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.f, false);
        gj1.B0(parcel, 3, this.g, false);
        gj1.B0(parcel, 4, this.h, false);
        gj1.B0(parcel, 5, this.i, false);
        gj1.B0(parcel, 6, this.j, false);
        gj1.B0(parcel, 7, this.k, false);
        gj1.B0(parcel, 8, this.l, false);
        gj1.B0(parcel, 9, this.m, false);
        boolean z = this.n;
        parcel.writeInt(262154);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.o;
        parcel.writeInt(262155);
        parcel.writeInt(z2 ? 1 : 0);
        gj1.B0(parcel, 12, this.p, false);
        gj1.B0(parcel, 13, this.q, false);
        gj1.B0(parcel, 14, this.r, false);
        gj1.B0(parcel, 15, this.s, false);
        boolean z3 = this.t;
        parcel.writeInt(262160);
        parcel.writeInt(z3 ? 1 : 0);
        gj1.B0(parcel, 17, this.u, false);
        gj1.H1(parcel, o1);
    }

    @Override // defpackage.o53
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.o);
        jSONObject.put("returnSecureToken", this.n);
        String str = this.g;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.l;
        if (str2 != null) {
            jSONObject.put("postBody", str2);
        }
        String str3 = this.s;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.u;
        if (str4 != null) {
            jSONObject.put("pendingToken", str4);
        }
        if (!TextUtils.isEmpty(this.q)) {
            jSONObject.put(SessionEvent.SESSION_ID_KEY, this.q);
        }
        if (!TextUtils.isEmpty(this.r)) {
            jSONObject.put("requestUri", this.r);
        } else {
            String str5 = this.f;
            if (str5 != null) {
                jSONObject.put("requestUri", str5);
            }
        }
        jSONObject.put("returnIdpCredential", this.t);
        return jSONObject.toString();
    }

    public zzxg(zzi zzi, String str) {
        Objects.requireNonNull(zzi, "null reference");
        String zza = zzi.zza();
        gj1.j(zza);
        this.q = zza;
        gj1.j(str);
        this.r = str;
        String zzc = zzi.zzc();
        gj1.j(zzc);
        this.j = zzc;
        this.n = true;
        StringBuilder k0 = hj1.k0("providerId", "=");
        k0.append(this.j);
        this.l = k0.toString();
    }

    public zzxg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f = "http://localhost";
        this.h = str;
        this.i = str2;
        this.m = str4;
        this.p = str5;
        this.s = str6;
        this.u = str7;
        this.n = true;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.i) || !TextUtils.isEmpty(this.p)) {
            gj1.j(str3);
            this.j = str3;
            this.k = null;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.h)) {
                sb.append("id_token");
                sb.append("=");
                sb.append(this.h);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.i)) {
                sb.append("access_token");
                sb.append("=");
                sb.append(this.i);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.k)) {
                sb.append(CheckForUpdatesResponseTransform.IDENTIFIER);
                sb.append("=");
                sb.append(this.k);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.m)) {
                sb.append("oauth_token_secret");
                sb.append("=");
                sb.append(this.m);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.p)) {
                sb.append("code");
                sb.append("=");
                sb.append(this.p);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(str8)) {
                hj1.V0(sb, "nonce", "=", str8, "&");
            }
            sb.append("providerId");
            sb.append("=");
            sb.append(this.j);
            this.l = sb.toString();
            this.o = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    public zzxg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, String str11, String str12, boolean z3, String str13) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = str7;
        this.m = str8;
        this.n = z;
        this.o = z2;
        this.p = str9;
        this.q = str10;
        this.r = str11;
        this.s = str12;
        this.t = z3;
        this.u = str13;
    }
}
