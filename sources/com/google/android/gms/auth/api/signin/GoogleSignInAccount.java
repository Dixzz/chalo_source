package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b12();
    public final int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public Uri k;
    public String l;
    public long m;
    public String n;
    public List<Scope> o;
    public String p;
    public String q;
    public Set<Scope> r = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f = i2;
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = uri;
        this.l = str5;
        this.m = j2;
        this.n = str6;
        this.o = list;
        this.p = str7;
        this.q = str8;
    }

    @RecentlyNullable
    public static GoogleSignInAccount m1(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String optString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String optString5 = jSONObject.has(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME) ? jSONObject.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME) : null;
        String optString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String optString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        long longValue = valueOf.longValue();
        gj1.j(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.l = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.n.equals(this.n) && googleSignInAccount.l1().equals(l1());
    }

    public int hashCode() {
        return l1().hashCode() + hj1.r0(this.n, 527, 31);
    }

    public Set<Scope> l1() {
        HashSet hashSet = new HashSet(this.o);
        hashSet.addAll(this.r);
        return hashSet;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.B0(parcel, 2, this.g, false);
        gj1.B0(parcel, 3, this.h, false);
        gj1.B0(parcel, 4, this.i, false);
        gj1.B0(parcel, 5, this.j, false);
        gj1.A0(parcel, 6, this.k, i2, false);
        gj1.B0(parcel, 7, this.l, false);
        long j2 = this.m;
        parcel.writeInt(524296);
        parcel.writeLong(j2);
        gj1.B0(parcel, 9, this.n, false);
        gj1.F0(parcel, 10, this.o, false);
        gj1.B0(parcel, 11, this.p, false);
        gj1.B0(parcel, 12, this.q, false);
        gj1.H1(parcel, o1);
    }
}
