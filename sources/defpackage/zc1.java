package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import com.razorpay.AnalyticsConstants;

/* renamed from: zc1  reason: default package */
/* compiled from: Device */
public abstract class zc1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f4155a;

    public zc1(Context context) {
        this.f4155a = context;
    }

    public String a() {
        return Settings.Secure.getString(this.f4155a.getContentResolver(), AnalyticsConstants.ANDROID_ID);
    }

    public String b() {
        try {
            Cursor query = this.f4155a.getContentResolver().query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/email_v2"}, null);
            if (query == null) {
                return null;
            }
            String string = query.moveToNext() ? query.getString(query.getColumnIndex("data1")) : null;
            query.close();
            return string;
        } catch (Exception e) {
            e(e);
            return null;
        }
    }

    public final String c(Context context, String str) {
        try {
            Cursor query = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), new String[]{str}, "mimetype=?", new String[]{"vnd.android.cursor.item/name"}, null);
            if (query == null) {
                return null;
            }
            String string = query.moveToNext() ? query.getString(query.getColumnIndex(str)) : null;
            query.close();
            return string;
        } catch (Exception e) {
            e(e);
            return null;
        }
    }

    public String d() {
        String c = c(this.f4155a, "data2");
        String c2 = c(this.f4155a, "data3");
        if (c == null || c2 == null) {
            return c != null ? c : c2;
        }
        return c + ' ' + c2;
    }

    public abstract void e(Exception exc);
}
