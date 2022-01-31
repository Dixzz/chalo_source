package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: mk5  reason: default package */
/* compiled from: UrbanAirshipResolver */
public class mk5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2392a;

    public mk5(Context context) {
        this.f2392a = context;
    }

    public int a(Uri uri, String str, String[] strArr) {
        try {
            return b().delete(uri, str, strArr);
        } catch (Exception e) {
            yj5.e(e, "Failed to perform a delete in UrbanAirshipProvider.", new Object[0]);
            return -1;
        }
    }

    public final ContentResolver b() {
        return this.f2392a.getContentResolver();
    }

    public Cursor c(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return b().query(uri, strArr, str, strArr2, str2);
        } catch (Exception e) {
            yj5.e(e, "Failed to query the UrbanAirshipProvider.", new Object[0]);
            return null;
        }
    }

    public int d(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return b().update(uri, contentValues, str, strArr);
        } catch (Exception e) {
            yj5.e(e, "Failed to perform an update in UrbanAirshipProvider.", new Object[0]);
            return 0;
        }
    }
}
