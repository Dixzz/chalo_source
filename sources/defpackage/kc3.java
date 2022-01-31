package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.razorpay.AnalyticsConstants;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* renamed from: kc3  reason: default package */
public final class kc3 extends SQLiteOpenHelper {
    public final /* synthetic */ jc3 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kc3(jc3 jc3, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f = jc3;
    }

    public static Set<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        String[] columnNames;
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(hj1.y(str.length() + 22, "SELECT * FROM ", str, " LIMIT 0"), null);
        try {
            for (String str2 : rawQuery.getColumnNames()) {
                hashSet.add(str2);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            boolean moveToFirst = cursor.moveToFirst();
            cursor.close();
            return moveToFirst;
        } catch (SQLiteException e) {
            this.f.r("Error querying for table", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (this.f.j.b(3600000)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.f.j.a();
                this.f.V("Opening the database failed, dropping the table and recreating it");
                String str = jc3.k;
                this.f.f.f146a.getDatabasePath("google_analytics_v4.db").delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    this.f.j.b = 0;
                    return writableDatabase;
                } catch (SQLiteException e) {
                    this.f.L("Failed to open freshly created database", e);
                    throw e;
                }
            }
        } else {
            throw new SQLiteException("Database open failed");
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i;
        String path = sQLiteDatabase.getPath();
        try {
            i = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            rd3.d("Invalid version number", Build.VERSION.SDK);
            i = 0;
        }
        if (i >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!a(sQLiteDatabase, "hits2")) {
            sQLiteDatabase.execSQL(jc3.k);
        } else {
            Set<String> c = c(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (!((HashSet) c).remove(str)) {
                    String valueOf = String.valueOf(str);
                    throw new SQLiteException(valueOf.length() != 0 ? "Database hits2 is missing required column: ".concat(valueOf) : new String("Database hits2 is missing required column: "));
                }
            }
            HashSet hashSet = (HashSet) c;
            boolean z = !hashSet.remove("hit_app_id");
            if (!hashSet.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (z) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }
        if (!a(sQLiteDatabase, AnalyticsConstants.PROPERTIES)) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            return;
        }
        Set<String> c2 = c(sQLiteDatabase, AnalyticsConstants.PROPERTIES);
        String[] strArr2 = {"app_uid", "cid", "tid", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "adid", "hits_count"};
        for (int i2 = 0; i2 < 6; i2++) {
            String str2 = strArr2[i2];
            if (!((HashSet) c2).remove(str2)) {
                String valueOf2 = String.valueOf(str2);
                throw new SQLiteException(valueOf2.length() != 0 ? "Database properties is missing required column: ".concat(valueOf2) : new String("Database properties is missing required column: "));
            }
        }
        if (!((HashSet) c2).isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
