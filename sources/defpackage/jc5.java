package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.rabbitmq.client.ConnectionFactory;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: jc5  reason: default package */
/* compiled from: MPConfig */
public class jc5 {
    public static boolean E = false;
    public static jc5 F;
    public static final Object G = new Object();
    public final int A;
    public final String B;
    public final String C;
    public SSLSocketFactory D;

    /* renamed from: a  reason: collision with root package name */
    public final int f1903a;
    public final int b;
    public final boolean c;
    public final long d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final String[] l;
    public String m;
    public String n;
    public String o;
    public String p;
    public final boolean q;
    public final String r;
    public final String s;
    public final boolean t;
    public final int u;
    public final boolean v;
    public final int w;
    public final int x;
    public final int y;
    public boolean z;

    public jc5(Bundle bundle, Context context) {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, null, null);
            sSLSocketFactory = instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
        }
        this.D = sSLSocketFactory;
        boolean z2 = bundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        E = z2;
        if (z2) {
            rd5.f3070a = 2;
        }
        bundle.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval");
        this.f1903a = bundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.b = bundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", ConnectionFactory.DEFAULT_CONNECTION_TIMEOUT);
        this.c = bundle.getBoolean("com.mixpanel.android.MPConfig.FlushOnBackground", true);
        this.e = bundle.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
        this.s = bundle.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
        this.g = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
        this.h = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
        this.i = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
        this.j = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableViewCrawler", false);
        this.t = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
        this.k = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableExceptionHandler", false);
        this.u = bundle.getInt("com.mixpanel.android.MPConfig.ImageCacheMaxMemoryFactor", 10);
        this.v = bundle.getBoolean("com.mixpanel.android.MPConfig.IgnoreInvisibleViewsVisualEditor", false);
        this.q = bundle.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
        this.w = bundle.getInt("com.mixpanel.android.MPConfig.NotificationDefaults", 0);
        this.x = bundle.getInt("com.mixpanel.android.MPConfig.MinimumSessionDuration", 10000);
        this.y = bundle.getInt("com.mixpanel.android.MPConfig.SessionTimeoutDuration", Integer.MAX_VALUE);
        this.z = bundle.getBoolean("com.mixpanel.android.MPConfig.UseIpAddressForGeolocation", true);
        this.f = bundle.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
        this.A = bundle.getInt("com.mixpanel.android.MPConfig.NotificationChannelImportance", 3);
        Object obj = bundle.get("com.mixpanel.android.MPConfig.DataExpiration");
        long j2 = 432000000;
        if (obj != null) {
            try {
                if (obj instanceof Integer) {
                    j2 = (long) ((Integer) obj).intValue();
                } else if (obj instanceof Float) {
                    j2 = (long) ((Float) obj).floatValue();
                } else {
                    throw new NumberFormatException(obj.toString() + " is not a number.");
                }
            } catch (Exception unused2) {
            }
        }
        this.d = j2;
        String string = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelId");
        this.B = string == null ? "mp" : string;
        String string2 = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelName");
        this.C = string2 == null ? ed5.a(context).g : string2;
        String string3 = bundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        if (string3 != null) {
            this.m = string3;
        } else {
            this.m = a("https://api.mixpanel.com/track/", this.z);
        }
        String string4 = bundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        if (string4 != null) {
            this.n = string4;
        } else {
            this.n = a("https://api.mixpanel.com/engage/", this.z);
        }
        String string5 = bundle.getString("com.mixpanel.android.MPConfig.GroupsEndpoint");
        if (string5 != null) {
            this.o = string5;
        } else {
            this.o = "https://api.mixpanel.com/groups/";
        }
        String string6 = bundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        if (string6 != null) {
            this.p = string6;
        } else {
            this.p = "https://api.mixpanel.com/decide";
        }
        String string7 = bundle.getString("com.mixpanel.android.MPConfig.EditorUrl");
        this.r = string7 == null ? "wss://switchboard.mixpanel.com/connect/" : string7;
        int i2 = bundle.getInt("com.mixpanel.android.MPConfig.DisableViewCrawlerForProjects", -1);
        if (i2 != -1) {
            this.l = context.getResources().getStringArray(i2);
        } else {
            this.l = new String[0];
        }
        toString();
    }

    public static jc5 b(Context context) {
        synchronized (G) {
            if (F == null) {
                F = d(context.getApplicationContext());
            }
        }
        return F;
    }

    public static jc5 d(Context context) {
        String packageName = context.getPackageName();
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new jc5(bundle, context);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(hj1.S("Can't configure Mixpanel with package name ", packageName), e2);
        }
    }

    public final String a(String str, boolean z2) {
        String str2 = "1";
        if (str.contains("?ip=")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, str.indexOf("?ip=")));
            sb.append("?ip=");
            if (!z2) {
                str2 = "0";
            }
            sb.append(str2);
            return sb.toString();
        }
        StringBuilder k0 = hj1.k0(str, "?ip=");
        if (!z2) {
            str2 = "0";
        }
        k0.append(str2);
        return k0.toString();
    }

    public synchronized SSLSocketFactory c() {
        return this.D;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Mixpanel (5.9.6) configured with:\n    AutoShowMixpanelUpdates ");
        i0.append(this.q);
        i0.append("\n    BulkUploadLimit ");
        i0.append(this.f1903a);
        i0.append("\n    FlushInterval ");
        i0.append(this.b);
        i0.append("\n    DataExpiration ");
        i0.append(this.d);
        i0.append("\n    MinimumDatabaseLimit ");
        i0.append(this.e);
        i0.append("\n    DisableAppOpenEvent ");
        i0.append(this.i);
        i0.append("\n    DisableViewCrawler ");
        i0.append(this.j);
        i0.append("\n    DisableGestureBindingUI ");
        i0.append(this.g);
        i0.append("\n    DisableEmulatorBindingUI ");
        i0.append(this.h);
        i0.append("\n    EnableDebugLogging ");
        i0.append(E);
        i0.append("\n    TestMode ");
        i0.append(this.f);
        i0.append("\n    EventsEndpoint ");
        i0.append(this.m);
        i0.append("\n    PeopleEndpoint ");
        i0.append(this.n);
        i0.append("\n    DecideEndpoint ");
        i0.append(this.p);
        i0.append("\n    EditorUrl ");
        i0.append(this.r);
        i0.append("\n    ImageCacheMaxMemoryFactor ");
        i0.append(this.u);
        i0.append("\n    DisableDecideChecker ");
        i0.append(this.t);
        i0.append("\n    IgnoreInvisibleViewsEditor ");
        i0.append(this.v);
        i0.append("\n    NotificationDefaults ");
        i0.append(this.w);
        i0.append("\n    MinimumSessionDuration: ");
        i0.append(this.x);
        i0.append("\n    SessionTimeoutDuration: ");
        i0.append(this.y);
        i0.append("\n    DisableExceptionHandler: ");
        i0.append(this.k);
        i0.append("\n    NotificationChannelId: ");
        i0.append(this.B);
        i0.append("\n    NotificationChannelName: ");
        i0.append(this.C);
        i0.append("\n    NotificationChannelImportance: ");
        i0.append(this.A);
        i0.append("\n    FlushOnBackground: ");
        i0.append(this.c);
        i0.append("\n    UseIpAddressForGeolocation: ");
        i0.append(this.z);
        return i0.toString();
    }
}
