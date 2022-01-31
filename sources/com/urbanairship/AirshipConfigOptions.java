package com.urbanairship;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.perf.util.Constants;
import com.urbanairship.push.PushProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class AirshipConfigOptions {
    public static final Pattern D = Pattern.compile("^[a-zA-Z0-9\\-_]{22}$");
    public final String A;
    public final boolean B;
    public final boolean C;

    /* renamed from: a  reason: collision with root package name */
    public final String f711a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Uri i;
    @Deprecated
    public final String j;
    public final List<String> k;
    public final PushProvider l;
    public final List<String> m;
    public final List<String> n;
    public final List<String> o;
    public final boolean p;
    public final long q;
    public final int r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final int v;
    public final boolean w;
    public final int x;
    public final int y;
    public final int z;

    public static final class b {
        public boolean A = true;
        public int B;
        public int C;
        public int D = 0;
        public String E;
        public String F;
        public PushProvider G;
        public Uri H;
        public boolean I;
        public boolean J;
        public String K = "US";
        public int L = Constants.MAX_HOST_LENGTH;
        public boolean M = false;
        public boolean N = false;

        /* renamed from: a  reason: collision with root package name */
        public String f712a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public List<String> o = new ArrayList(Arrays.asList("ADM", FirebaseMessaging.INSTANCE_ID_SCOPE, "HMS"));
        public List<String> p = new ArrayList();
        public List<String> q = new ArrayList();
        public List<String> r = new ArrayList();
        public Boolean s = null;
        public boolean t = true;
        public long u = 86400000;
        public Integer v;
        public Integer w;
        public Integer x;
        public boolean y = true;
        public boolean z = false;

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void a(Context context, iy5 iy5) {
            char c2;
            int i2;
            char c3;
            int i3 = 0;
            while (true) {
                az5 az5 = (az5) iy5;
                boolean z2 = true;
                if (i3 < az5.e()) {
                    try {
                        String i4 = az5.i(i3);
                        if (i4 != null) {
                            switch (i4.hashCode()) {
                                case -2131444128:
                                    if (i4.equals("channelCreationDelayEnabled")) {
                                        c2 = 27;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1829910004:
                                    if (i4.equals("appStoreUri")) {
                                        c2 = '\'';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1776171144:
                                    if (i4.equals("productionAppSecret")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1720015653:
                                    if (i4.equals("analyticsEnabled")) {
                                        c2 = 21;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1653850041:
                                    if (i4.equals("whitelist")) {
                                        c2 = 16;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1597596356:
                                    if (i4.equals("customPushProvider")) {
                                        c2 = '&';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1565695247:
                                    if (i4.equals("dataCollectionOptInEnabled")) {
                                        c2 = ')';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1565320553:
                                    if (i4.equals("productionAppKey")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1554123216:
                                    if (i4.equals("urlAllowListScopeJavaScriptInterface")) {
                                        c2 = 18;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1411093378:
                                    if (i4.equals("appKey")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1387253559:
                                    if (i4.equals("urlAllowListScopeOpenUrl")) {
                                        c2 = 19;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1285301710:
                                    if (i4.equals("allowedTransports")) {
                                        c2 = 15;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1266098791:
                                    if (i4.equals("developmentAppKey")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1249058386:
                                    if (i4.equals("autoLaunchApplication")) {
                                        c2 = 26;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1106202922:
                                    if (i4.equals("extendedBroadcastsEnabled")) {
                                        c2 = '*';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -956504956:
                                    if (i4.equals("chatSocketUrl")) {
                                        c2 = '\r';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -874660855:
                                    if (i4.equals("analyticsUrl")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -516160866:
                                    if (i4.equals("enabledFeatures")) {
                                        c2 = '-';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -398391045:
                                    if (i4.equals("developmentLogLevel")) {
                                        c2 = 23;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -361592578:
                                    if (i4.equals("channelCaptureEnabled")) {
                                        c2 = 28;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -318159706:
                                    if (i4.equals("gcmSender")) {
                                        c2 = 14;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -187695495:
                                    if (i4.equals("productionLogLevel")) {
                                        c2 = 24;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -116200981:
                                    if (i4.equals("backgroundReportingIntervalMS")) {
                                        c2 = 22;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -93122203:
                                    if (i4.equals("developmentFcmSenderId")) {
                                        c2 = '#';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3530567:
                                    if (i4.equals("site")) {
                                        c2 = '(';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 24145854:
                                    if (i4.equals("inProduction")) {
                                        c2 = 20;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 25200441:
                                    if (i4.equals("deviceUrl")) {
                                        c2 = 7;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 233293225:
                                    if (i4.equals("notificationLargeIcon")) {
                                        c2 = 30;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 282201398:
                                    if (i4.equals("developmentAppSecret")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 290002134:
                                    if (i4.equals("suppressAllowListError")) {
                                        c2 = '+';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 476084841:
                                    if (i4.equals("analyticsServer")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 739105527:
                                    if (i4.equals("chatUrl")) {
                                        c2 = '\f';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 770975322:
                                    if (i4.equals("requireInitialRemoteConfigEnabled")) {
                                        c2 = ',';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 988154272:
                                    if (i4.equals("fcmSenderId")) {
                                        c2 = '\"';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1065256263:
                                    if (i4.equals("enableUrlWhitelisting")) {
                                        c2 = '%';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1098683047:
                                    if (i4.equals("hostURL")) {
                                        c2 = 6;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1465076406:
                                    if (i4.equals("walletUrl")) {
                                        c2 = ' ';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1485559857:
                                    if (i4.equals("appSecret")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1505552078:
                                    if (i4.equals("notificationAccentColor")) {
                                        c2 = 31;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1611189252:
                                    if (i4.equals("notificationIcon")) {
                                        c2 = 29;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1779744152:
                                    if (i4.equals("notificationChannel")) {
                                        c2 = '!';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1790788391:
                                    if (i4.equals("productionFcmSenderId")) {
                                        c2 = '$';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1855914712:
                                    if (i4.equals("urlAllowList")) {
                                        c2 = 17;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1958618687:
                                    if (i4.equals("remoteDataURL")) {
                                        c2 = '\n';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1958619711:
                                    if (i4.equals("remoteDataUrl")) {
                                        c2 = 11;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1995731616:
                                    if (i4.equals("logLevel")) {
                                        c2 = 25;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    this.f712a = ((az5) iy5).b.get(i4);
                                    continue;
                                case 1:
                                    this.b = ((az5) iy5).b.get(i4);
                                    continue;
                                case 2:
                                    this.c = ((az5) iy5).b.get(i4);
                                    continue;
                                case 3:
                                    this.d = ((az5) iy5).b.get(i4);
                                    continue;
                                case 4:
                                    this.e = ((az5) iy5).b.get(i4);
                                    continue;
                                case 5:
                                    this.f = ((az5) iy5).b.get(i4);
                                    continue;
                                case 6:
                                case 7:
                                    this.g = az5.j(i4, this.g);
                                    continue;
                                case '\b':
                                case '\t':
                                    this.h = az5.j(i4, this.h);
                                    continue;
                                case '\n':
                                case 11:
                                    this.i = az5.j(i4, this.i);
                                    continue;
                                case '\f':
                                    this.k = az5.j(i4, this.k);
                                    continue;
                                case '\r':
                                    this.j = az5.j(i4, this.j);
                                    continue;
                                case 14:
                                    throw new IllegalArgumentException("gcmSender no longer supported. Please use fcmSender or remove it to allow the Airship SDK to pull from the google-services.json.");
                                case 15:
                                    String[] k2 = az5.k(i4);
                                    this.o.clear();
                                    if (k2 != null) {
                                        this.o.addAll(Arrays.asList(k2));
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 16:
                                    yj5.c("Parameter whitelist is deprecated and will be removed in a future version of the SDK. Use urlAllowList instead.", new Object[0]);
                                    String[] k3 = az5.k(i4);
                                    this.p.clear();
                                    if (k3 != null) {
                                        this.p.addAll(Arrays.asList(k3));
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 17:
                                    String[] k4 = az5.k(i4);
                                    this.p.clear();
                                    if (k4 != null) {
                                        this.p.addAll(Arrays.asList(k4));
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 18:
                                    String[] k5 = az5.k(i4);
                                    this.q.clear();
                                    if (k5 != null) {
                                        this.q.addAll(Arrays.asList(k5));
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 19:
                                    String[] k6 = az5.k(i4);
                                    this.r.clear();
                                    if (k6 != null) {
                                        this.r.addAll(Arrays.asList(k6));
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 20:
                                    Boolean bool = this.s;
                                    this.s = Boolean.valueOf(az5.c(i4, bool != null && bool.booleanValue()));
                                    continue;
                                case 21:
                                    this.t = az5.c(i4, this.t);
                                    continue;
                                case 22:
                                    this.u = az5.h(i4, this.u);
                                    continue;
                                case 23:
                                    this.v = Integer.valueOf(yj5.g(((az5) iy5).b.get(i4), 3));
                                    continue;
                                case 24:
                                    this.w = Integer.valueOf(yj5.g(((az5) iy5).b.get(i4), 6));
                                    continue;
                                case 25:
                                    this.x = Integer.valueOf(yj5.g(((az5) iy5).b.get(i4), 6));
                                    continue;
                                case 26:
                                    this.y = az5.c(i4, this.y);
                                    continue;
                                case 27:
                                    this.z = az5.c(i4, this.z);
                                    continue;
                                case 28:
                                    this.A = az5.c(i4, this.A);
                                    continue;
                                case 29:
                                    this.B = az5.f(i4);
                                    continue;
                                case 30:
                                    this.C = az5.f(i4);
                                    continue;
                                case 31:
                                    this.D = az5.d(i4, this.D);
                                    continue;
                                case ' ':
                                    this.E = az5.j(i4, this.E);
                                    continue;
                                case '!':
                                    this.F = ((az5) iy5).b.get(i4);
                                    continue;
                                case '\"':
                                    this.l = ((az5) iy5).b.get(i4);
                                    continue;
                                case '#':
                                    this.n = ((az5) iy5).b.get(i4);
                                    continue;
                                case '$':
                                    this.m = ((az5) iy5).b.get(i4);
                                    continue;
                                case '%':
                                    yj5.c("Parameter enableUrlWhitelisting has been removed. See urlAllowListScopeJavaScriptBridge and urlAllowListScopeOpen instead.", new Object[0]);
                                    continue;
                                case '&':
                                    String str = ((az5) iy5).b.get(i4);
                                    hd3.E(str, "Missing custom push provider class name");
                                    this.G = (PushProvider) Class.forName(str).asSubclass(PushProvider.class).newInstance();
                                    continue;
                                case '\'':
                                    this.H = Uri.parse(((az5) iy5).b.get(i4));
                                    continue;
                                case '(':
                                    String str2 = ((az5) iy5).b.get(i4);
                                    Pattern pattern = AirshipConfigOptions.D;
                                    String str3 = "EU";
                                    if (!str3.equalsIgnoreCase(str2)) {
                                        str3 = "US";
                                        if (!str3.equalsIgnoreCase(str2)) {
                                            throw new IllegalArgumentException("Invalid site: " + str2);
                                        }
                                    }
                                    this.K = str3;
                                    continue;
                                case ')':
                                    this.I = az5.c(i4, false);
                                    continue;
                                case '*':
                                    this.J = az5.c(i4, false);
                                    continue;
                                case '+':
                                    this.M = az5.c(i4, false);
                                    continue;
                                case ',':
                                    this.N = az5.c(i4, false);
                                    continue;
                                case '-':
                                    try {
                                        i2 = az5.g(i4, -1);
                                    } catch (Exception unused) {
                                        i2 = -1;
                                    }
                                    if (i2 != -1) {
                                        this.L = ik5.a(i2);
                                        continue;
                                    } else {
                                        String[] k7 = az5.k(i4);
                                        if (k7 != null) {
                                            int i5 = 0;
                                            for (String str4 : k7) {
                                                if (str4 != null && !str4.isEmpty()) {
                                                    switch (str4.hashCode()) {
                                                        case -1693017210:
                                                            if (str4.equals(server.zophop.Constants.PRODUCTION_ANALYTICS)) {
                                                                c3 = 0;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case -567451565:
                                                            if (str4.equals("contacts")) {
                                                                c3 = 1;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case -63122353:
                                                            if (str4.equals("in_app_automation")) {
                                                                c3 = 2;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case 96673:
                                                            if (str4.equals("all")) {
                                                                c3 = 3;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case 3052376:
                                                            if (str4.equals("chat")) {
                                                                c3 = 4;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case 3452698:
                                                            if (str4.equals("push")) {
                                                                c3 = 5;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case 536871821:
                                                            if (str4.equals("message_center")) {
                                                                c3 = 6;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case 965553573:
                                                            if (str4.equals("tags_and_attributes")) {
                                                                c3 = 7;
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        case 1901043637:
                                                            if (str4.equals(FirebaseAnalytics.Param.LOCATION)) {
                                                                c3 = '\b';
                                                                break;
                                                            }
                                                            c3 = 65535;
                                                            break;
                                                        default:
                                                            c3 = 65535;
                                                            break;
                                                    }
                                                    switch (c3) {
                                                        case 0:
                                                            i5 |= 16;
                                                            break;
                                                        case 1:
                                                            i5 |= 64;
                                                            break;
                                                        case 2:
                                                            i5 |= 1;
                                                            break;
                                                        case 3:
                                                            i5 |= Constants.MAX_HOST_LENGTH;
                                                            break;
                                                        case 4:
                                                            i5 |= 8;
                                                            break;
                                                        case 5:
                                                            i5 |= 4;
                                                            break;
                                                        case 6:
                                                            i5 |= 2;
                                                            break;
                                                        case 7:
                                                            i5 |= 32;
                                                            break;
                                                        case '\b':
                                                            i5 |= 128;
                                                            break;
                                                    }
                                                }
                                            }
                                            this.L = ik5.a(i5);
                                            break;
                                        } else {
                                            throw new IllegalArgumentException("Unable to parse enableFeatures: " + ((az5) iy5).b.get(i4));
                                        }
                                    }
                            }
                        }
                    } catch (Exception e2) {
                        yj5.e(e2, "Unable to set config field '%s' due to invalid configuration value.", az5.i(i3));
                    }
                    i3++;
                } else if (this.s == null) {
                    try {
                        if (((Boolean) Class.forName(context.getPackageName() + ".BuildConfig").getField("DEBUG").get(null)).booleanValue()) {
                            z2 = false;
                        }
                        this.s = Boolean.valueOf(z2);
                        return;
                    } catch (Exception unused2) {
                        yj5.i("AirshipConfigOptions - Unable to determine the build mode. Defaulting to debug.", new Object[0]);
                        this.s = Boolean.FALSE;
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public AirshipConfigOptions b() {
            if (this.p.isEmpty() && this.r.isEmpty() && !this.M) {
                yj5.c("The airship config options is missing URL allow list rules for SCOPE_OPEN. By default only Airship, YouTube, mailto, sms, and tel URLs will be allowed.To suppress this error, specify allow list rules by providing rules for urlAllowListScopeOpenUrl or urlAllowList. Alternatively you can suppress this error and keep the default rules by using the flag suppressAllowListError. For more information, see https://docs.airship.com/platform/android/getting-started/#url-allow-list.", new Object[0]);
            }
            if (this.s == null) {
                this.s = Boolean.FALSE;
            }
            String str = this.c;
            if (str != null && str.equals(this.e)) {
                yj5.i("Production App Key matches Development App Key", new Object[0]);
            }
            String str2 = this.d;
            if (str2 != null && str2.equals(this.f)) {
                yj5.i("Production App Secret matches Development App Secret", new Object[0]);
            }
            if (this.I) {
                yj5.i("dataCollectionOptInEnabled is deprecated. Use enabledFeatures instead.", new Object[0]);
                if (this.L == 255) {
                    this.L = 0;
                }
            }
            return new AirshipConfigOptions(this, null);
        }
    }

    public AirshipConfigOptions(b bVar, a aVar) {
        if (bVar.s.booleanValue()) {
            this.f711a = b(bVar.c, bVar.f712a);
            this.b = b(bVar.d, bVar.b);
            this.j = c(bVar.m, bVar.l);
            this.r = a(bVar.w, bVar.x, 6);
        } else {
            this.f711a = b(bVar.e, bVar.f712a);
            this.b = b(bVar.f, bVar.b);
            this.j = c(bVar.n, bVar.l);
            this.r = a(bVar.v, bVar.x, 3);
        }
        String str = bVar.K;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2224) {
            if (hashCode == 2718 && str.equals("US")) {
                c2 = 1;
            }
        } else if (str.equals("EU")) {
            c2 = 0;
        }
        if (c2 != 0) {
            this.c = b(bVar.g, "https://device-api.urbanairship.com/");
            this.d = b(bVar.h, "https://combine.urbanairship.com/");
            this.e = b(bVar.i, "https://remote-data.urbanairship.com/");
            this.f = b(bVar.E, "https://wallet-api.urbanairship.com");
            this.g = b(bVar.k);
            this.h = b(bVar.j);
        } else {
            this.c = b(bVar.g, "https://device-api.asnapieu.com/");
            this.d = b(bVar.h, "https://combine.asnapieu.com/");
            this.e = b(bVar.i, "https://remote-data.asnapieu.com/");
            this.f = b(bVar.E, "https://wallet-api.asnapieu.com");
            this.g = b(bVar.k);
            this.h = b(bVar.j);
        }
        this.k = Collections.unmodifiableList(new ArrayList(bVar.o));
        this.m = Collections.unmodifiableList(new ArrayList(bVar.p));
        this.n = Collections.unmodifiableList(new ArrayList(bVar.q));
        this.o = Collections.unmodifiableList(new ArrayList(bVar.r));
        this.B = bVar.s.booleanValue();
        this.p = bVar.t;
        this.q = bVar.u;
        this.s = bVar.y;
        this.t = bVar.z;
        this.u = bVar.A;
        this.x = bVar.B;
        this.y = bVar.C;
        this.z = bVar.D;
        this.A = bVar.F;
        this.l = bVar.G;
        this.i = bVar.H;
        this.v = bVar.L;
        this.w = bVar.J;
        this.C = bVar.N;
    }

    public static int a(Integer... numArr) {
        for (Integer num : numArr) {
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    public static String b(String... strArr) {
        for (String str : strArr) {
            if (!hd3.G1(str)) {
                return str;
            }
        }
        return "";
    }

    public static String c(String... strArr) {
        for (String str : strArr) {
            if (!hd3.G1(str)) {
                return str;
            }
        }
        return null;
    }
}
