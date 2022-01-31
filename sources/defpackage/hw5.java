package defpackage;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.R;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: hw5  reason: default package */
/* compiled from: NotificationChannelRegistry */
public class hw5 {

    /* renamed from: a  reason: collision with root package name */
    public final iw5 f1437a;
    public final Executor b;
    public final Context c;
    public final NotificationManager d;

    public hw5(Context context, AirshipConfigOptions airshipConfigOptions) {
        iw5 iw5 = new iw5(context, airshipConfigOptions.f711a, "ua_notification_channel_registry.db");
        Executor a2 = pj5.a();
        this.c = context;
        this.f1437a = iw5;
        this.b = a2;
        this.d = (NotificationManager) context.getSystemService("notification");
    }

    /* JADX INFO: finally extract failed */
    public static fw5 a(hw5 hw5, String str) {
        List<fw5> list;
        Context context = hw5.c;
        XmlResourceParser xml = context.getResources().getXml(R.xml.ua_default_channels);
        try {
            list = fw5.c(context, xml);
            xml.close();
        } catch (Exception e) {
            yj5.e(e, "Failed to parse channels", new Object[0]);
            xml.close();
            list = Collections.emptyList();
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
        for (fw5 fw5 : list) {
            if (str.equals(fw5.l)) {
                SQLiteDatabase f = hw5.f1437a.f();
                if (f == null) {
                    yj5.c("NotificationChannelRegistryDataManager - Unable to save notification channel.", new Object[0]);
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("channel_id", fw5.l);
                    contentValues.put("data", fw5.b().toString());
                    f.insertWithOnConflict("notification_channels", null, contentValues, 5);
                }
                return fw5;
            }
        }
        return null;
    }

    public fw5 b(String str) {
        try {
            ck5 ck5 = new ck5();
            this.b.execute(new gw5(this, str, ck5));
            return (fw5) ck5.get();
        } catch (InterruptedException e) {
            yj5.e(e, "Failed to get notification channel.", new Object[0]);
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            yj5.e(e2, "Failed to get notification channel.", new Object[0]);
            return null;
        }
    }
}
