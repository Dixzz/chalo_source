package defpackage;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;

/* renamed from: dg5  reason: default package */
/* compiled from: TrillLogger */
public class dg5 {

    /* renamed from: a  reason: collision with root package name */
    public final ag5 f833a;
    public final int b;
    public ArrayList<String> c;
    public ArrayList<short[]> d;
    public String e = "";
    public String f = "";
    public String g = "";
    public boolean h = true;
    public int i = 0;

    public dg5(Context context, boolean z) {
        String str;
        ag5 ag5 = new ag5(context);
        this.f833a = ag5;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        if (str3.startsWith(str2)) {
            str = ag5.a(str3);
        } else {
            str = ag5.a(str2) + str3 + "-" + Settings.Secure.getString(ag5.f161a.getContentResolver(), AnalyticsConstants.ANDROID_ID);
        }
        this.e = str;
        this.f = Settings.Secure.getString(ag5.f161a.getContentResolver(), AnalyticsConstants.ANDROID_ID);
        this.b = Build.VERSION.SDK_INT;
        this.g = hj1.a0(new StringBuilder(), this.e, " as Receiver");
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        if (z) {
            this.g = hj1.a0(new StringBuilder(), this.f, " as Sender");
        }
        FirebaseApp.initializeApp(context, new FirebaseOptions.Builder().setApplicationId("1:918715664469:android:7eee30a7515813a1152cdc").setProjectId("trill-demo").setApiKey("AIzaSyAPoQcHVZUN4639iAVLKr-mqx2fQCRjsiI").setStorageBucket("trill-demo.appspot.com").setDatabaseUrl("trill-demo.appspot.com").build(), "trillbit-sdk");
    }
}
