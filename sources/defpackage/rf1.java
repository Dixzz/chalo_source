package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* renamed from: rf1  reason: default package */
/* compiled from: KeyValueStore */
public class rf1 {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences.Editor f3075a;
    public final SharedPreferences b;

    public rf1(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.b = sharedPreferences;
        this.f3075a = sharedPreferences.edit();
    }

    public boolean a(String str) {
        return this.b.contains(str);
    }

    public Map<String, ?> b() {
        return this.b.getAll();
    }

    public boolean c(String str, boolean z) {
        return this.b.getBoolean(str, z);
    }

    public int d(String str, int i) {
        return this.b.getInt(str, i);
    }

    public long e(String str, long j) {
        return this.b.getLong(str, j);
    }

    public String f(String str, String str2) {
        return this.b.getString(str, null);
    }

    public void g(String str, boolean z) {
        this.f3075a.putBoolean(str, z);
        this.f3075a.commit();
    }

    public void h(String str, int i) {
        this.f3075a.putInt(str, i);
        this.f3075a.commit();
    }

    public void i(String str, long j) {
        this.f3075a.putLong(str, j);
        this.f3075a.commit();
    }

    public void j(String str, String str2) {
        this.f3075a.putString(str, str2);
        this.f3075a.commit();
    }

    public void k(String str) {
        this.f3075a.remove(str);
        this.f3075a.commit();
    }

    public void l() {
        this.f3075a.clear();
        this.f3075a.commit();
    }
}
