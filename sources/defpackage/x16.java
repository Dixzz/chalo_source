package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: x16  reason: default package */
/* compiled from: PreferenceStoreImpl */
public class x16 implements w16 {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f3871a;
    public final Context b;

    public x16(Context context, String str) {
        if (context != null) {
            this.b = context;
            this.f3871a = context.getSharedPreferences(str, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public SharedPreferences.Editor a() {
        return this.f3871a.edit();
    }
}
