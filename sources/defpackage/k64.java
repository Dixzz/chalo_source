package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: k64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class k64 extends sc4 {
    public long c;
    public String d;
    public Boolean e;
    public AccountManager f;
    public Boolean g;
    public long h;

    public k64(vb4 vb4) {
        super(vb4);
    }

    @Override // defpackage.sc4
    public final boolean p() {
        Calendar instance = Calendar.getInstance();
        this.c = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.d = hj1.y(hj1.g0(lowerCase2, hj1.g0(lowerCase, 1)), lowerCase, "-", lowerCase2);
        return false;
    }

    public final boolean q(Context context) {
        if (this.e == null) {
            this.e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.e.booleanValue();
    }

    public final long s() {
        l();
        return this.c;
    }

    public final String t() {
        l();
        return this.d;
    }

    public final long u() {
        b();
        return this.h;
    }

    public final boolean v() {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        b();
        Objects.requireNonNull((db2) this.f3331a.n);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.h > 86400000) {
            this.g = null;
        }
        Boolean bool3 = this.g;
        if (bool3 != null) {
            return bool3.booleanValue();
        }
        if (q5.a(this.f3331a.f3627a, "android.permission.GET_ACCOUNTS") != 0) {
            g().j.a("Permission error checking for dasher/unicorn accounts");
            this.h = currentTimeMillis;
            this.g = bool2;
            return false;
        }
        if (this.f == null) {
            this.f = AccountManager.get(this.f3331a.f3627a);
        }
        try {
            Account[] result = this.f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.g = bool;
                    this.h = currentTimeMillis;
                    return true;
                }
                this.h = currentTimeMillis;
                this.g = bool2;
                return false;
            }
            this.g = bool;
            this.h = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
            g().g.b("Exception checking account types", e2);
        }
    }
}
