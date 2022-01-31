package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.rabbitmq.client.StringRpcServer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
/* renamed from: ic5  reason: default package */
/* compiled from: InstallReferrerReceiver */
public class ic5 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final Pattern f1504a = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
    public final Pattern b = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
    public final Pattern c = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
    public final Pattern d = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
    public final Pattern e = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

    public final String a(Matcher matcher) {
        String group;
        if (!matcher.find() || (group = matcher.group(2)) == null) {
            return null;
        }
        try {
            return URLDecoder.decode(group, StringRpcServer.STRING_ENCODING);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        String string;
        Bundle extras = intent.getExtras();
        if (!(extras == null || (string = extras.getString("referrer")) == null)) {
            HashMap m0 = hj1.m0("referrer", string);
            String a2 = a(this.f1504a.matcher(string));
            if (a2 != null) {
                m0.put("utm_source", a2);
            }
            String a3 = a(this.b.matcher(string));
            if (a3 != null) {
                m0.put("utm_medium", a3);
            }
            String a4 = a(this.c.matcher(string));
            if (a4 != null) {
                m0.put("utm_campaign", a4);
            }
            String a5 = a(this.d.matcher(string));
            if (a5 != null) {
                m0.put("utm_content", a5);
            }
            String a6 = a(this.e.matcher(string));
            if (a6 != null) {
                m0.put("utm_term", a6);
            }
            synchronized (xc5.s) {
                SharedPreferences.Editor edit = context.getSharedPreferences("com.mixpanel.android.mpmetrics.ReferralInfo", 0).edit();
                edit.clear();
                for (Map.Entry entry : m0.entrySet()) {
                    edit.putString((String) entry.getKey(), (String) entry.getValue());
                }
                edit.apply();
                xc5.r = true;
            }
        }
    }
}
