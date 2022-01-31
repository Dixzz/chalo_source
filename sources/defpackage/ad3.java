package defpackage;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: ad3  reason: default package */
public final class ad3 {

    /* renamed from: a  reason: collision with root package name */
    public final ac3 f152a;
    public volatile Boolean b;
    public String c;
    public Set<Integer> d;

    public ad3(ac3 ac3) {
        this.f152a = ac3;
    }

    public static long b() {
        return id3.f.f1906a.longValue();
    }

    public static int c() {
        return id3.h.f1906a.intValue();
    }

    public static String d() {
        return id3.k.f1906a;
    }

    public static String e() {
        return id3.j.f1906a;
    }

    public static String f() {
        return id3.l.f1906a;
    }

    public final boolean a() {
        Boolean bool = Boolean.TRUE;
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = this.f152a.f146a.getApplicationInfo();
                    String a2 = gb2.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.b = Boolean.valueOf(str != null && str.equals(a2));
                    }
                    if ((this.b == null || !this.b.booleanValue()) && "com.google.android.gms.analytics".equals(a2)) {
                        this.b = bool;
                    }
                    if (this.b == null) {
                        this.b = bool;
                        this.f152a.c().V("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public final Set<Integer> g() {
        String str;
        V v = id3.t.f1906a;
        if (this.d == null || (str = this.c) == null || !str.equals(v)) {
            String[] split = TextUtils.split(v, ",");
            HashSet hashSet = new HashSet();
            for (String str2 : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (NumberFormatException unused) {
                }
            }
            this.c = v;
            this.d = hashSet;
        }
        return this.d;
    }
}
