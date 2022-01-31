package defpackage;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import java.util.Timer;
import java.util.regex.Pattern;

/* renamed from: hc5  reason: default package */
/* compiled from: InstallReferrerPlay */
public class hc5 implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f1358a;
    public InstallReferrerClient b;

    /* renamed from: hc5$a */
    /* compiled from: InstallReferrerPlay */
    public interface a {
    }

    static {
        Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
    }

    public hc5(Context context, a aVar) {
        Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
        Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
        Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
        Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");
        this.f1358a = context;
        new Timer();
    }

    public void a() {
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(this.f1358a).build();
            this.b = build;
            build.startConnection(this);
        } catch (SecurityException unused) {
        }
    }
}
