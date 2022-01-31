package defpackage;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.provider.Settings;
import android.util.Xml;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: fw5  reason: default package */
/* compiled from: NotificationChannelCompat */
public class fw5 implements cu5 {
    public boolean f = false;
    public boolean g = true;
    public boolean h = false;
    public boolean i = false;
    public String j = null;
    public String k = null;
    public final String l;
    public CharSequence m;
    public Uri n = Settings.System.DEFAULT_NOTIFICATION_URI;
    public int o;
    public int p = 0;
    public int q = -1000;
    public long[] r = null;

    public fw5(NotificationChannel notificationChannel) {
        this.f = notificationChannel.canBypassDnd();
        this.g = notificationChannel.canShowBadge();
        this.h = notificationChannel.shouldShowLights();
        this.i = notificationChannel.shouldVibrate();
        this.j = notificationChannel.getDescription();
        this.k = notificationChannel.getGroup();
        this.l = notificationChannel.getId();
        this.m = notificationChannel.getName();
        this.n = notificationChannel.getSound();
        this.o = notificationChannel.getImportance();
        this.p = notificationChannel.getLightColor();
        this.q = notificationChannel.getLockscreenVisibility();
        this.r = notificationChannel.getVibrationPattern();
    }

    public static fw5 a(JsonValue jsonValue) {
        zt5 h2 = jsonValue.h();
        if (h2 != null) {
            String i2 = h2.u("id").i();
            String i3 = h2.u("name").i();
            int e = h2.u("importance").e(-1);
            if (!(i2 == null || i3 == null || e == -1)) {
                fw5 fw5 = new fw5(i2, i3, e);
                fw5.f = h2.u("can_bypass_dnd").a(false);
                fw5.g = h2.u("can_show_badge").a(true);
                fw5.h = h2.u("should_show_lights").a(false);
                fw5.i = h2.u("should_vibrate").a(false);
                fw5.j = h2.u("description").i();
                fw5.k = h2.u("group").i();
                fw5.p = h2.u("light_color").e(0);
                fw5.q = h2.u("lockscreen_visibility").e(-1000);
                fw5.m = h2.u("name").o();
                String i4 = h2.u("sound").i();
                if (!hd3.G1(i4)) {
                    fw5.n = Uri.parse(i4);
                }
                yt5 f2 = h2.u("vibration_pattern").f();
                if (f2 != null) {
                    long[] jArr = new long[f2.size()];
                    for (int i5 = 0; i5 < f2.size(); i5++) {
                        jArr[i5] = f2.d(i5).g(0);
                    }
                    fw5.r = jArr;
                }
                return fw5;
            }
        }
        yj5.c("Unable to deserialize notification channel: %s", jsonValue);
        return null;
    }

    public static List<fw5> c(Context context, XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        ArrayList arrayList = new ArrayList();
        while (1 != xmlResourceParser.next()) {
            if (2 == xmlResourceParser.getEventType() && "NotificationChannel".equals(xmlResourceParser.getName())) {
                gy5 gy5 = new gy5(context, Xml.asAttributeSet(xmlResourceParser));
                String d = gy5.d("name");
                String d2 = gy5.d("id");
                int c = gy5.c("importance", -1);
                if (hd3.G1(d) || hd3.G1(d2) || c == -1) {
                    yj5.c("Invalid notification channel. Missing name (%s), id (%s), or importance (%s)", d, d2, Integer.valueOf(c));
                } else {
                    fw5 fw5 = new fw5(d2, d, c);
                    fw5.f = gy5.a("can_bypass_dnd", false);
                    fw5.g = gy5.a("can_show_badge", true);
                    fw5.h = gy5.a("should_show_lights", false);
                    fw5.i = gy5.a("should_vibrate", false);
                    fw5.j = gy5.d("description");
                    fw5.k = gy5.d("group");
                    fw5.p = gy5.b("light_color", 0);
                    fw5.q = gy5.c("lockscreen_visibility", -1000);
                    int attributeResourceValue = gy5.b.getAttributeResourceValue(null, "sound", 0);
                    if (attributeResourceValue == 0) {
                        String attributeValue = gy5.b.getAttributeValue(null, "sound");
                        attributeResourceValue = attributeValue != null ? gy5.f1317a.getResources().getIdentifier(attributeValue, "raw", gy5.f1317a.getPackageName()) : 0;
                    }
                    if (attributeResourceValue != 0) {
                        StringBuilder i0 = hj1.i0("android.resource://");
                        i0.append(context.getPackageName());
                        i0.append("/raw/");
                        i0.append(context.getResources().getResourceEntryName(attributeResourceValue));
                        fw5.n = Uri.parse(i0.toString());
                    } else {
                        String d3 = gy5.d("sound");
                        if (!hd3.G1(d3)) {
                            fw5.n = Uri.parse(d3);
                        }
                    }
                    String d4 = gy5.d("vibration_pattern");
                    if (!hd3.G1(d4)) {
                        String[] split = d4.split(",");
                        long[] jArr = new long[split.length];
                        for (int i2 = 0; i2 < split.length; i2++) {
                            jArr[i2] = Long.parseLong(split[i2]);
                        }
                        fw5.r = jArr;
                    }
                    arrayList.add(fw5);
                }
            }
        }
        return arrayList;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("can_bypass_dnd", Boolean.valueOf(this.f));
        s.i("can_show_badge", Boolean.valueOf(this.g));
        s.i("should_show_lights", Boolean.valueOf(this.h));
        s.i("should_vibrate", Boolean.valueOf(this.i));
        s.i("description", this.j);
        s.i("group", this.k);
        s.i("id", this.l);
        s.i("importance", Integer.valueOf(this.o));
        s.i("light_color", Integer.valueOf(this.p));
        s.i("lockscreen_visibility", Integer.valueOf(this.q));
        s.i("name", this.m.toString());
        Uri uri = this.n;
        s.i("sound", uri != null ? uri.toString() : null);
        s.i("vibration_pattern", JsonValue.x(this.r));
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fw5.class != obj.getClass()) {
            return false;
        }
        fw5 fw5 = (fw5) obj;
        if (this.f != fw5.f || this.g != fw5.g || this.h != fw5.h || this.i != fw5.i || this.o != fw5.o || this.p != fw5.p || this.q != fw5.q) {
            return false;
        }
        String str = this.j;
        if (str == null ? fw5.j != null : !str.equals(fw5.j)) {
            return false;
        }
        String str2 = this.k;
        if (str2 == null ? fw5.k != null : !str2.equals(fw5.k)) {
            return false;
        }
        String str3 = this.l;
        if (str3 == null ? fw5.l != null : !str3.equals(fw5.l)) {
            return false;
        }
        CharSequence charSequence = this.m;
        if (charSequence == null ? fw5.m != null : !charSequence.equals(fw5.m)) {
            return false;
        }
        Uri uri = this.n;
        if (uri == null ? fw5.n == null : uri.equals(fw5.n)) {
            return Arrays.equals(this.r, fw5.r);
        }
        return false;
    }

    public int hashCode() {
        int i2 = (((((((this.f ? 1 : 0) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31;
        String str = this.j;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.k;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.l;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.m;
        int hashCode4 = (hashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Uri uri = this.n;
        if (uri != null) {
            i3 = uri.hashCode();
        }
        return Arrays.hashCode(this.r) + ((((((((hashCode4 + i3) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("NotificationChannelCompat{bypassDnd=");
        i0.append(this.f);
        i0.append(", showBadge=");
        i0.append(this.g);
        i0.append(", showLights=");
        i0.append(this.h);
        i0.append(", shouldVibrate=");
        i0.append(this.i);
        i0.append(", description='");
        hj1.U0(i0, this.j, '\'', ", group='");
        hj1.U0(i0, this.k, '\'', ", identifier='");
        hj1.U0(i0, this.l, '\'', ", name=");
        i0.append((Object) this.m);
        i0.append(", sound=");
        i0.append(this.n);
        i0.append(", importance=");
        i0.append(this.o);
        i0.append(", lightColor=");
        i0.append(this.p);
        i0.append(", lockscreenVisibility=");
        i0.append(this.q);
        i0.append(", vibrationPattern=");
        i0.append(Arrays.toString(this.r));
        i0.append('}');
        return i0.toString();
    }

    public fw5(String str, CharSequence charSequence, int i2) {
        this.l = str;
        this.m = charSequence;
        this.o = i2;
    }
}
