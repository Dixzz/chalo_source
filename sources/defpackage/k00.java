package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import com.razorpay.AnalyticsConstants;
import defpackage.a32;
import defpackage.xt;
import java.util.Objects;

/* renamed from: k00  reason: default package */
/* compiled from: AppIndexFeature */
public class k00 {

    /* renamed from: a  reason: collision with root package name */
    public a32 f2005a;
    public final Context b;
    public final e80 c;
    public final String d;

    /* renamed from: k00$a */
    /* compiled from: AppIndexFeature */
    public class a implements Runnable {
        public final /* synthetic */ Handler f;

        public a(Handler handler) {
            this.f = handler;
        }

        public void run() {
            k00 k00 = k00.this;
            a32.a aVar = new a32.a(k00.b);
            aVar.a(qz1.f3013a);
            k00.f2005a = aVar.d();
            k00.this.f2005a.f();
            k00 k002 = k00.this;
            Objects.requireNonNull(k002);
            StringBuilder sb = new StringBuilder();
            sb.append("android-app://");
            hj1.V0(sb, k002.d, "/zophop/autocab?", "source", "=");
            hj1.V0(sb, "appIndex", "&", "tag", "=");
            pz1 m = hj1.m(sb, "Nearby Cabs", "http://schema.org/ViewAction", "Nearby Cabs");
            rz1 rz1 = qz1.b;
            gf3 gf3 = (gf3) rz1;
            StringBuilder h0 = hj1.h0(gf3, k002.f2005a, m, "android-app://");
            hj1.V0(h0, k002.d, "/zophop/autocab?", "source", "=");
            hj1.V0(h0, "appIndex", "&", "tag", "=");
            StringBuilder h02 = hj1.h0(gf3, k002.f2005a, hj1.m(h0, "Taxi & Auto", "http://schema.org/ViewAction", "Taxi & Auto"), "android-app://");
            hj1.V0(h02, k002.d, "/zophop/autocab?", "source", "=");
            hj1.V0(h02, "appIndex", "&", "tag", "=");
            gf3.a(k002.f2005a, hj1.m(h02, "Uber Ola Jugnoo", "http://schema.org/ViewAction", "Uber Ola Jugnoo"));
            k00 k003 = k00.this;
            Objects.requireNonNull(k003);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("android-app://");
            hj1.V0(sb2, k003.d, "/zophop/nearby/stops?mode=bus&", "source", "=");
            hj1.V0(sb2, "appIndex", "&", "tag", "=");
            gf3 gf32 = (gf3) rz1;
            StringBuilder h03 = hj1.h0(gf32, k003.f2005a, hj1.m(sb2, "Nearest Bus Stops", "http://schema.org/ViewAction", "Nearest Bus Stops"), "android-app://");
            hj1.V0(h03, k003.d, "/zophop/nearby/stops?mode=train&", "source", "=");
            hj1.V0(h03, "appIndex", "&", "tag", "=");
            StringBuilder h04 = hj1.h0(gf32, k003.f2005a, hj1.m(h03, "Nearest Train Stations", "http://schema.org/ViewAction", "Nearest Train Stations"), "android-app://");
            hj1.V0(h04, k003.d, "/zophop/nearby/stops?mode=metro&", "source", "=");
            hj1.V0(h04, "appIndex", "&", "tag", "=");
            StringBuilder h05 = hj1.h0(gf32, k003.f2005a, hj1.m(h04, "Nearest Metro Stations", "http://schema.org/ViewAction", "Nearest Metro Stations"), "android-app://");
            hj1.V0(h05, k003.d, "/zophop/nearby/trips?", "source", "=");
            hj1.V0(h05, "appIndex", "&", "tag", "=");
            gf32.a(k003.f2005a, hj1.m(h05, "Live Bus Timings", "http://schema.org/ViewAction", "Live Bus Timings"));
            k00 k004 = k00.this;
            Objects.requireNonNull(k004);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("android-app://");
            hj1.V0(sb3, k004.d, "/zophop/plan?", "source", "=");
            hj1.V0(sb3, "appIndex", "&", "tag", "=");
            gf3 gf33 = (gf3) rz1;
            StringBuilder h06 = hj1.h0(gf33, k004.f2005a, hj1.m(sb3, "Best route from A to B", "http://schema.org/ViewAction", "Best route from A to B"), "android-app://");
            hj1.V0(h06, k004.d, "/zophop/plan?", "source", "=");
            hj1.V0(h06, "appIndex", "&", "tag", "=");
            gf33.a(k004.f2005a, hj1.m(h06, "How to go from A to B", "http://schema.org/ViewAction", "How to go from A to B"));
            k00 k005 = k00.this;
            Objects.requireNonNull(k005);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("android-app://");
            hj1.V0(sb4, k005.d, "/zophop/scheduler?", "source", "=");
            hj1.V0(sb4, "appIndex", "&", "tag", "=");
            gf3 gf34 = (gf3) rz1;
            StringBuilder h07 = hj1.h0(gf34, k005.f2005a, hj1.m(sb4, "Bus Routes, Timings & Fares", "http://schema.org/ViewAction", "Bus Routes, Timings & Fares"), "android-app://");
            hj1.V0(h07, k005.d, "/zophop/scheduler?", "source", "=");
            hj1.V0(h07, "appIndex", "&", "tag", "=");
            StringBuilder h08 = hj1.h0(gf34, k005.f2005a, hj1.m(h07, "Train Timings & Fares", "http://schema.org/ViewAction", "Train Timings & Fares"), "android-app://");
            hj1.V0(h08, k005.d, "/zophop/scheduler?", "source", "=");
            hj1.V0(h08, "appIndex", "&", "tag", "=");
            gf34.a(k005.f2005a, hj1.m(h08, "Metro Timings & Fares", "http://schema.org/ViewAction", "Metro Timings & Fares"));
            k00 k006 = k00.this;
            Objects.requireNonNull(k006);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("android-app://");
            hj1.V0(sb5, k006.d, "/zophop/blog?name=Blog&", "source", "=");
            hj1.V0(sb5, "appIndex", "&", "tag", "=");
            gf3 gf35 = (gf3) rz1;
            gf35.a(k006.f2005a, hj1.m(sb5, "Blog Travel Stories News", "http://schema.org/ViewAction", "Blog Travel Stories News"));
            this.f.getLooper().quit();
        }
    }

    public k00(Context context, e80 e80) {
        this.b = context;
        this.c = e80;
        this.d = context.getPackageName();
        jz5 b2 = jz5.b();
        boolean z = false;
        b2.k(this, b2.e, false, 0);
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.l().h.has("first_app_index")) {
            if (e80.d() != null ? true : z) {
                b();
                t1Var.l().put("first_app_index", "true");
            }
        }
    }

    public void a(String str, String str2, String str3) {
        ed1 l = hj1.l("inbound traffic", Long.MIN_VALUE, "source", str2);
        hj1.p(l, "tag", str3, AnalyticsConstants.SCREEN, str).g(l);
    }

    public final void b() {
        HandlerThread handlerThread = new HandlerThread("app indexing");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new a(handler));
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.l().h.has("first_app_index")) {
            b();
            t1Var.l().put("first_app_index", "true");
        }
    }
}
