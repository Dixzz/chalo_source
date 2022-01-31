package defpackage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import j$.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

/* renamed from: af2  reason: default package */
public abstract class af2<T> {
    public static final Object g = new Object();
    @SuppressLint({"StaticFieldLeak"})
    public static Context h;
    public static volatile Boolean i;
    public static volatile Boolean j;

    /* renamed from: a  reason: collision with root package name */
    public final kf2 f158a;
    public final String b;
    public final String c;
    public final T d;
    public volatile xe2 e = null;
    public volatile SharedPreferences f = null;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public af2(kf2 kf2, String str, Object obj, ef2 ef2) {
        String str2 = kf2.f2051a;
        if (str2 == null && kf2.b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (str2 == null || kf2.b == null) {
            this.f158a = kf2;
            String valueOf = String.valueOf(kf2.c);
            String valueOf2 = String.valueOf(str);
            this.c = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(kf2.d);
            String valueOf4 = String.valueOf(str);
            this.b = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
            this.d = obj;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    public static <V> V c(if2<V> if2) {
        long clearCallingIdentity;
        try {
            return if2.f();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V f2 = if2.f();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return f2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public static boolean d(String str) {
        if (h()) {
            return ((Boolean) c(new df2(str))).booleanValue();
        }
        return false;
    }

    public static boolean h() {
        if (i == null) {
            Context context = h;
            boolean z = false;
            if (context == null) {
                return false;
            }
            if (h.p(context, "com.google.android.providers.gsf.permission.READ_GSERVICES", Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null) == 0) {
                z = true;
            }
            i = Boolean.valueOf(z);
        }
        return i.booleanValue();
    }

    public final T a() {
        if (h != null) {
            if (this.f158a.f) {
                T g2 = g();
                if (g2 != null) {
                    return g2;
                }
                T f2 = f();
                if (f2 != null) {
                    return f2;
                }
            } else {
                T f3 = f();
                if (f3 != null) {
                    return f3;
                }
                T g3 = g();
                if (g3 != null) {
                    return g3;
                }
            }
            return this.d;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    public abstract T b(SharedPreferences sharedPreferences);

    public abstract T e(String str);

    @Nullable
    @TargetApi(24)
    public final T f() {
        boolean z;
        if (!d("gms:phenotype:phenotype_flag:debug_bypass_phenotype")) {
            kf2 kf2 = this.f158a;
            if (kf2.b != null) {
                if (this.e == null) {
                    ContentResolver contentResolver = h.getContentResolver();
                    Uri uri = this.f158a.b;
                    ConcurrentHashMap<Uri, xe2> concurrentHashMap = xe2.h;
                    xe2 xe2 = (xe2) concurrentHashMap.get(uri);
                    if (xe2 == null) {
                        xe2 = new xe2(contentResolver, uri);
                        xe2 xe22 = (xe2) concurrentHashMap.putIfAbsent(uri, xe2);
                        if (xe22 == null) {
                            xe2.f3921a.registerContentObserver(xe2.b, false, xe2.c);
                        } else {
                            xe2 = xe22;
                        }
                    }
                    this.e = xe2;
                }
                String str = (String) c(new bf2(this, this.e));
                if (str != null) {
                    return e(str);
                }
            } else if (kf2.f2051a != null) {
                if (Build.VERSION.SDK_INT < 24 || h.isDeviceProtectedStorage()) {
                    z = true;
                } else {
                    if (j == null || !j.booleanValue()) {
                        j = Boolean.valueOf(((UserManager) h.getSystemService(UserManager.class)).isUserUnlocked());
                    }
                    z = j.booleanValue();
                }
                if (!z) {
                    return null;
                }
                if (this.f == null) {
                    this.f = h.getSharedPreferences(this.f158a.f2051a, 0);
                }
                SharedPreferences sharedPreferences = this.f;
                if (sharedPreferences.contains(this.b)) {
                    return b(sharedPreferences);
                }
            }
        } else {
            String valueOf = String.valueOf(this.b);
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            } else {
                new String("Bypass reading Phenotype values for flag: ");
            }
        }
        return null;
    }

    @Nullable
    public final T g() {
        String str;
        if (this.f158a.e || !h() || (str = (String) c(new cf2(this))) == null) {
            return null;
        }
        return e(str);
    }
}
