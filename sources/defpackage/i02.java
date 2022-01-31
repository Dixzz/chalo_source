package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: i02  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class i02 {
    public static final Lock c = new ReentrantLock();
    @GuardedBy("sLk")
    public static i02 d;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f1456a = new ReentrantLock();
    @GuardedBy("mLk")
    public final SharedPreferences b;

    public i02(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @RecentlyNonNull
    public static i02 a(@RecentlyNonNull Context context) {
        Objects.requireNonNull(context, "null reference");
        Lock lock = c;
        lock.lock();
        try {
            if (d == null) {
                d = new i02(context.getApplicationContext());
            }
            i02 i02 = d;
            lock.unlock();
            return i02;
        } catch (Throwable th) {
            c.unlock();
            throw th;
        }
    }

    public static final String h(String str, String str2) {
        return hj1.b0(new StringBuilder(str.length() + 1 + String.valueOf(str2).length()), str, ProductDiscountsObject.KEY_DELIMITER, str2);
    }

    @RecentlyNullable
    public GoogleSignInAccount b() {
        String f;
        String f2 = f("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(f2) || (f = f(h("googleSignInAccount", f2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.m1(f);
        } catch (JSONException unused) {
            return null;
        }
    }

    @RecentlyNullable
    public GoogleSignInOptions c() {
        String f;
        String f2 = f("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(f2) || (f = f(h("googleSignInOptions", f2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.m1(f);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void d(@RecentlyNonNull GoogleSignInAccount googleSignInAccount, @RecentlyNonNull GoogleSignInOptions googleSignInOptions) {
        Objects.requireNonNull(googleSignInAccount, "null reference");
        Objects.requireNonNull(googleSignInOptions, "null reference");
        e("defaultGoogleSignInAccount", googleSignInAccount.n);
        String str = googleSignInAccount.n;
        String h = h("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.g;
            if (str2 != null) {
                jSONObject.put("id", str2);
            }
            String str3 = googleSignInAccount.h;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.i;
            if (str4 != null) {
                jSONObject.put("email", str4);
            }
            String str5 = googleSignInAccount.j;
            if (str5 != null) {
                jSONObject.put(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME, str5);
            }
            String str6 = googleSignInAccount.p;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.q;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.k;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.l;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.m);
            jSONObject.put("obfuscatedIdentifier", googleSignInAccount.n);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = googleSignInAccount.o;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, a12.f);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.g);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            e(h, jSONObject.toString());
            String h2 = h("googleSignInOptions", str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(googleSignInOptions.g, GoogleSignInOptions.u);
                Iterator<Scope> it = googleSignInOptions.g.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next().g);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.h;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.i);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.k);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.j);
                if (!TextUtils.isEmpty(googleSignInOptions.l)) {
                    jSONObject2.put("serverClientId", googleSignInOptions.l);
                }
                if (!TextUtils.isEmpty(googleSignInOptions.m)) {
                    jSONObject2.put("hostedDomain", googleSignInOptions.m);
                }
                e(h2, jSONObject2.toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void e(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        this.f1456a.lock();
        try {
            this.b.edit().putString(str, str2).apply();
        } finally {
            this.f1456a.unlock();
        }
    }

    @RecentlyNullable
    public final String f(@RecentlyNonNull String str) {
        this.f1456a.lock();
        try {
            return this.b.getString(str, null);
        } finally {
            this.f1456a.unlock();
        }
    }

    public final void g(@RecentlyNonNull String str) {
        this.f1456a.lock();
        try {
            this.b.edit().remove(str).apply();
        } finally {
            this.f1456a.unlock();
        }
    }
}
