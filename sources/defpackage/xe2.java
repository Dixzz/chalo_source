package defpackage;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: xe2  reason: default package */
public final class xe2 {
    public static final ConcurrentHashMap<Uri, xe2> h = new ConcurrentHashMap<>();
    public static final String[] i = {AnalyticsConstants.KEY, FirebaseAnalytics.Param.VALUE};

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f3921a;
    public final Uri b;
    public final ContentObserver c;
    public final Object d = new Object();
    public volatile Map<String, String> e;
    public final Object f = new Object();
    public final List<ze2> g = new ArrayList();

    public xe2(ContentResolver contentResolver, Uri uri) {
        this.f3921a = contentResolver;
        this.b = uri;
        this.c = new ye2(this);
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        Cursor query = this.f3921a.query(this.b, i, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashMap.put(query.getString(0), query.getString(1));
                } catch (SQLiteException | SecurityException unused) {
                    return null;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
        }
        return hashMap;
    }
}
