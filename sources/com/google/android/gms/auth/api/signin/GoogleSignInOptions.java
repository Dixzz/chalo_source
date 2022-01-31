package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.x22;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class GoogleSignInOptions extends AbstractSafeParcelable implements x22.d, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new d12();
    @RecentlyNonNull
    public static final GoogleSignInOptions p;
    @RecentlyNonNull
    public static final Scope q;
    @RecentlyNonNull
    public static final Scope r;
    @RecentlyNonNull
    public static final Scope s;
    @RecentlyNonNull
    public static final Scope t;
    public static Comparator<Scope> u = new c12();
    public final int f;
    public final ArrayList<Scope> g;
    public Account h;
    public boolean i;
    public final boolean j;
    public final boolean k;
    public String l;
    public String m;
    public ArrayList<GoogleSignInOptionsExtensionParcelable> n;
    public String o;

    static {
        Scope scope = new Scope("profile");
        q = scope;
        new Scope("email");
        Scope scope2 = new Scope("openid");
        r = scope2;
        Scope scope3 = new Scope("https://www.googleapis.com/auth/games_lite");
        s = scope3;
        Scope scope4 = new Scope("https://www.googleapis.com/auth/games");
        t = scope4;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        p = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, hashMap, null);
        HashSet hashSet2 = new HashSet();
        HashMap hashMap2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, hashMap2, null);
    }

    public GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String str3) {
        this.f = i2;
        this.g = arrayList;
        this.h = account;
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = str;
        this.m = str2;
        this.n = new ArrayList<>(map.values());
        this.o = str3;
    }

    @RecentlyNullable
    public static GoogleSignInOptions m1(String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        Account account = !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null;
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        String optString2 = jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null;
        if (jSONObject.has("hostedDomain")) {
            str2 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z, z2, z3, optString2, str2, new HashMap(), null);
    }

    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> n1(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.g), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r1.equals(r4.h) != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i2;
        int i3;
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.g;
        int size = arrayList2.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(arrayList2.get(i5).g);
        }
        Collections.sort(arrayList);
        Account account = this.h;
        int hashCode = (arrayList.hashCode() + 31) * 31;
        if (account == null) {
            i2 = 0;
        } else {
            i2 = account.hashCode();
        }
        int i6 = hashCode + i2;
        String str = this.l;
        int i7 = i6 * 31;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = str.hashCode();
        }
        int i8 = ((((((i7 + i3) * 31) + (this.k ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0);
        String str2 = this.o;
        int i9 = i8 * 31;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return i9 + i4;
    }

    @RecentlyNonNull
    public ArrayList<Scope> l1() {
        return new ArrayList<>(this.g);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.F0(parcel, 2, l1(), false);
        gj1.A0(parcel, 3, this.h, i2, false);
        boolean z = this.i;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.j;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.k;
        parcel.writeInt(262150);
        parcel.writeInt(z3 ? 1 : 0);
        gj1.B0(parcel, 7, this.l, false);
        gj1.B0(parcel, 8, this.m, false);
        gj1.F0(parcel, 9, this.n, false);
        gj1.B0(parcel, 10, this.o, false);
        gj1.H1(parcel, o1);
    }
}
