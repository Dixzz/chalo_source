package defpackage;

import android.content.Context;
import app.zophop.ZophopApplication;
import com.razorpay.AnalyticsConstants;
import java.util.Objects;

/* renamed from: tz  reason: default package */
/* compiled from: LocalDataStore.kt */
public final class tz {
    public static final /* synthetic */ s96<Object>[] d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3422a;
    public final j56 b = hd3.a2(new a(this));
    public final d96 c;

    /* renamed from: tz$a */
    /* compiled from: LocalDataStore.kt */
    public static final class a extends o86 implements h76<ZophopApplication> {
        public final /* synthetic */ tz f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(tz tzVar) {
            super(0);
            this.f = tzVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ZophopApplication invoke() {
            Context applicationContext = this.f.f3422a.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type app.zophop.ZophopApplication");
            return (ZophopApplication) applicationContext;
        }
    }

    static {
        t86 t86 = new t86(tz.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        Objects.requireNonNull(z86.f4146a);
        d = new s96[]{t86};
    }

    public tz(Context context, String str) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(str, "preferenceKey");
        this.f3422a = context;
        ab abVar = ab.f;
        xb6 xb6 = xb6.f3911a;
        mb6 a2 = hd3.a(xb6.c.plus(ec6.b(null, 1)));
        n86.e(str, "name");
        n86.e(abVar, "produceMigrations");
        n86.e(a2, "scope");
        this.c = new cb(str, abVar, a2);
    }
}
