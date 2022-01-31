package defpackage;

import android.content.Context;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ku5  reason: default package */
/* compiled from: LocaleManager */
public class ku5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2123a;
    public volatile Locale b;
    public final List<ju5> c = new CopyOnWriteArrayList();
    public final hk5 d;

    public ku5(Context context, hk5 hk5) {
        this.d = hk5;
        this.f2123a = context.getApplicationContext();
    }

    public Locale a() {
        if (b() != null) {
            return b();
        }
        if (this.b == null) {
            this.b = h.N(this.f2123a.getResources().getConfiguration()).c(0);
        }
        return this.b;
    }

    public final Locale b() {
        String g = this.d.g("com.urbanairship.LOCALE_OVERRIDE_LANGUAGE", null);
        String g2 = this.d.g("com.urbanairship.LOCALE_OVERRIDE_COUNTRY", null);
        String g3 = this.d.g("com.urbanairship.LOCALE_OVERRIDE_VARIANT", null);
        if (g == null || g2 == null || g3 == null) {
            return null;
        }
        return new Locale(g, g2, g3);
    }
}
