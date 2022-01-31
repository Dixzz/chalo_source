package defpackage;

import android.content.Context;
import android.net.Uri;
import app.zophop.models.City;
import app.zophop.pubsub.eventbus.events.UniversalPassInfoFetchedEvent;
import defpackage.n00;
import defpackage.ut;
import defpackage.xt;
import java.util.Map;

/* renamed from: z60  reason: default package */
/* compiled from: UniversalPassApiHelper.kt */
public final class z60 {

    /* renamed from: a  reason: collision with root package name */
    public static final z60 f4134a = new z60();

    /* renamed from: z60$a */
    /* compiled from: UniversalPassApiHelper.kt */
    public static final class a implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f4135a;

        public a(Context context) {
            this.f4135a = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            Map g2 = hd3.g2(new m56("attribute error reason", str));
            n86.e("universal pass error response", "lEventName");
            n86.e("UniversalPassApiHelper", "lSource");
            ed1 l = hj1.l("universal pass error response", Long.MIN_VALUE, "source", "UniversalPassApiHelper");
            for (Map.Entry entry : g2.entrySet()) {
                l.a((String) entry.getKey(), entry.getValue());
            }
            ui1.m0(l);
            jz5.b().i(new UniversalPassInfoFetchedEvent(false, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            z60 z60 = z60.f4134a;
            hj1.R0("universal pass retry api called", "lName", "UniversalPassApiHelper", "lSource", "universal pass retry api called", Long.MIN_VALUE, "source", "UniversalPassApiHelper");
            z60.a(this.f4135a);
        }
    }

    public final void a(Context context) {
        n86.e(context, "lContext");
        Uri.Builder appendEncodedPath = new Uri.Builder().encodedPath(ut.i.toString()).appendEncodedPath("v2").appendEncodedPath("users").appendEncodedPath("getUniversalPass");
        xt.t1 t1Var = xt.f3961a;
        Uri.Builder appendQueryParameter = appendEncodedPath.appendQueryParameter("userId", t1Var.L().getUserId());
        City d = t1Var.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
        String lowerCase = name.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("city", lowerCase);
        ut.a aVar = ut.f3552a;
        String builder = appendQueryParameter2.appendQueryParameter("appVer", String.valueOf(764)).toString();
        n86.d(builder, "lUri.toString()");
        xj1 S = t1Var.S();
        e70 e70 = new e70(context, true, 0, builder, s60.f3191a, new a(context), "");
        e70.q = new nj1(12000, 5, 1.0f);
        e70.n = false;
        S.a(e70);
    }
}
