package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.razorpay.AnalyticsConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: kc5  reason: default package */
/* compiled from: MPDbAdapter */
public class kc5 {
    public static final Map<Context, kc5> b = new HashMap();
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;

    /* renamed from: a  reason: collision with root package name */
    public final a f2047a;

    /* renamed from: kc5$a */
    /* compiled from: MPDbAdapter */
    public static class a extends SQLiteOpenHelper {
        public final File f;
        public final jc5 g;
        public final Context h;

        /* renamed from: kc5$a$a  reason: collision with other inner class name */
        /* compiled from: MPDbAdapter */
        public class C0040a implements FilenameFilter {
            public C0040a(a aVar) {
            }

            public boolean accept(File file, String str) {
                return str.startsWith("com.mixpanel.android.mpmetrics.MixpanelAPI_");
            }
        }

        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 7);
            this.f = context.getDatabasePath(str);
            this.g = jc5.b(context);
            this.h = context;
        }

        public void a() {
            close();
            this.f.delete();
        }

        public final void c(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(kc5.f);
            sQLiteDatabase.execSQL(kc5.j);
            File file = new File(this.h.getApplicationInfo().dataDir, "shared_prefs");
            if (file.exists() && file.isDirectory()) {
                for (String str : file.list(new C0040a(this))) {
                    SharedPreferences sharedPreferences = this.h.getSharedPreferences(str.split("\\.xml")[0], 0);
                    String string = sharedPreferences.getString("waiting_array", null);
                    if (string != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(string);
                            sQLiteDatabase.beginTransaction();
                            for (int i = 0; i < jSONArray.length(); i++) {
                                try {
                                    try {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                                        String string2 = jSONObject.getString("$token");
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("data", jSONObject.toString());
                                        contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                                        contentValues.put("automatic_data", Boolean.FALSE);
                                        contentValues.put(AnalyticsConstants.TOKEN, string2);
                                        sQLiteDatabase.insert(b.ANONYMOUS_PEOPLE.getName(), null, contentValues);
                                    } catch (JSONException unused) {
                                    }
                                } finally {
                                    sQLiteDatabase.endTransaction();
                                }
                            }
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (JSONException unused2) {
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.remove("waiting_array");
                        edit.apply();
                    }
                }
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(kc5.c);
            sQLiteDatabase.execSQL(kc5.d);
            sQLiteDatabase.execSQL(kc5.e);
            sQLiteDatabase.execSQL(kc5.f);
            sQLiteDatabase.execSQL(kc5.g);
            sQLiteDatabase.execSQL(kc5.h);
            sQLiteDatabase.execSQL(kc5.i);
            sQLiteDatabase.execSQL(kc5.j);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            int i3;
            int i4;
            if (i < 4 || i2 > 7) {
                StringBuilder i0 = hj1.i0("DROP TABLE IF EXISTS ");
                i0.append(b.EVENTS.getName());
                sQLiteDatabase.execSQL(i0.toString());
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + b.PEOPLE.getName());
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + b.GROUPS.getName());
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + b.ANONYMOUS_PEOPLE.getName());
                sQLiteDatabase.execSQL(kc5.c);
                sQLiteDatabase.execSQL(kc5.d);
                sQLiteDatabase.execSQL(kc5.e);
                sQLiteDatabase.execSQL(kc5.f);
                sQLiteDatabase.execSQL(kc5.g);
                sQLiteDatabase.execSQL(kc5.h);
                sQLiteDatabase.execSQL(kc5.i);
                sQLiteDatabase.execSQL(kc5.j);
                return;
            }
            if (i == 4) {
                StringBuilder i02 = hj1.i0("ALTER TABLE ");
                b bVar = b.EVENTS;
                i02.append(bVar.getName());
                i02.append(" ADD COLUMN ");
                i02.append("automatic_data");
                i02.append(" INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL(i02.toString());
                StringBuilder sb = new StringBuilder();
                sb.append("ALTER TABLE ");
                b bVar2 = b.PEOPLE;
                sb.append(bVar2.getName());
                sb.append(" ADD COLUMN ");
                sb.append("automatic_data");
                sb.append(" INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL(sb.toString());
                sQLiteDatabase.execSQL("ALTER TABLE " + bVar.getName() + " ADD COLUMN " + AnalyticsConstants.TOKEN + " STRING NOT NULL DEFAULT ''");
                sQLiteDatabase.execSQL("ALTER TABLE " + bVar2.getName() + " ADD COLUMN " + AnalyticsConstants.TOKEN + " STRING NOT NULL DEFAULT ''");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SELECT * FROM ");
                sb2.append(bVar.getName());
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb2.toString(), null);
                while (rawQuery.moveToNext()) {
                    try {
                        String string = new JSONObject(rawQuery.getString(rawQuery.getColumnIndex("data") >= 0 ? rawQuery.getColumnIndex("data") : 1)).getJSONObject(AnalyticsConstants.PROPERTIES).getString(AnalyticsConstants.TOKEN);
                        i4 = rawQuery.getInt(rawQuery.getColumnIndex("_id") >= 0 ? rawQuery.getColumnIndex("_id") : 0);
                        try {
                            sQLiteDatabase.execSQL("UPDATE " + b.EVENTS.getName() + " SET " + AnalyticsConstants.TOKEN + " = '" + string + "' WHERE _id = " + i4);
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        i4 = 0;
                        String name = b.EVENTS.getName();
                        sQLiteDatabase.delete(name, "_id = " + i4, null);
                    }
                }
                StringBuilder i03 = hj1.i0("SELECT * FROM ");
                i03.append(b.PEOPLE.getName());
                Cursor rawQuery2 = sQLiteDatabase.rawQuery(i03.toString(), null);
                while (rawQuery2.moveToNext()) {
                    try {
                        String string2 = new JSONObject(rawQuery2.getString(rawQuery2.getColumnIndex("data") >= 0 ? rawQuery2.getColumnIndex("data") : 1)).getString("$token");
                        i3 = rawQuery2.getInt(rawQuery2.getColumnIndex("_id") >= 0 ? rawQuery2.getColumnIndex("_id") : 0);
                        try {
                            sQLiteDatabase.execSQL("UPDATE " + b.PEOPLE.getName() + " SET " + AnalyticsConstants.TOKEN + " = '" + string2 + "' WHERE _id = " + i3);
                        } catch (JSONException unused3) {
                        }
                    } catch (JSONException unused4) {
                        i3 = 0;
                        String name2 = b.PEOPLE.getName();
                        sQLiteDatabase.delete(name2, "_id = " + i3, null);
                    }
                }
                sQLiteDatabase.execSQL(kc5.e);
                sQLiteDatabase.execSQL(kc5.i);
                c(sQLiteDatabase);
            }
            if (i == 5) {
                sQLiteDatabase.execSQL(kc5.e);
                sQLiteDatabase.execSQL(kc5.i);
                c(sQLiteDatabase);
            }
            if (i == 6) {
                c(sQLiteDatabase);
            }
        }
    }

    /* renamed from: kc5$b */
    /* compiled from: MPDbAdapter */
    public enum b {
        EVENTS(AnalyticsConstants.EVENTS),
        PEOPLE("people"),
        ANONYMOUS_PEOPLE("anonymous_people"),
        GROUPS("groups");
        
        private final String mTableName;

        private b(String str) {
            this.mTableName = str;
        }

        public String getName() {
            return this.mTableName;
        }
    }

    static {
        StringBuilder i0 = hj1.i0("CREATE TABLE ");
        b bVar = b.EVENTS;
        i0.append(bVar.getName());
        i0.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        i0.append("data");
        i0.append(" STRING NOT NULL, ");
        hj1.V0(i0, "created_at", " INTEGER NOT NULL, ", "automatic_data", " INTEGER DEFAULT 0, ");
        c = hj1.a0(i0, AnalyticsConstants.TOKEN, " STRING NOT NULL DEFAULT '')");
        StringBuilder i02 = hj1.i0("CREATE TABLE ");
        b bVar2 = b.PEOPLE;
        i02.append(bVar2.getName());
        i02.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        i02.append("data");
        i02.append(" STRING NOT NULL, ");
        hj1.V0(i02, "created_at", " INTEGER NOT NULL, ", "automatic_data", " INTEGER DEFAULT 0, ");
        d = hj1.a0(i02, AnalyticsConstants.TOKEN, " STRING NOT NULL DEFAULT '')");
        StringBuilder i03 = hj1.i0("CREATE TABLE ");
        b bVar3 = b.GROUPS;
        i03.append(bVar3.getName());
        i03.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        i03.append("data");
        i03.append(" STRING NOT NULL, ");
        hj1.V0(i03, "created_at", " INTEGER NOT NULL, ", "automatic_data", " INTEGER DEFAULT 0, ");
        e = hj1.a0(i03, AnalyticsConstants.TOKEN, " STRING NOT NULL DEFAULT '')");
        StringBuilder i04 = hj1.i0("CREATE TABLE ");
        b bVar4 = b.ANONYMOUS_PEOPLE;
        i04.append(bVar4.getName());
        i04.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        i04.append("data");
        i04.append(" STRING NOT NULL, ");
        hj1.V0(i04, "created_at", " INTEGER NOT NULL, ", "automatic_data", " INTEGER DEFAULT 0, ");
        f = hj1.a0(i04, AnalyticsConstants.TOKEN, " STRING NOT NULL DEFAULT '')");
        StringBuilder i05 = hj1.i0("CREATE INDEX IF NOT EXISTS time_idx ON ");
        i05.append(bVar.getName());
        i05.append(" (");
        i05.append("created_at");
        i05.append(");");
        g = i05.toString();
        StringBuilder i06 = hj1.i0("CREATE INDEX IF NOT EXISTS time_idx ON ");
        i06.append(bVar2.getName());
        i06.append(" (");
        i06.append("created_at");
        i06.append(");");
        h = i06.toString();
        StringBuilder i07 = hj1.i0("CREATE INDEX IF NOT EXISTS time_idx ON ");
        i07.append(bVar3.getName());
        i07.append(" (");
        i07.append("created_at");
        i07.append(");");
        i = i07.toString();
        StringBuilder i08 = hj1.i0("CREATE INDEX IF NOT EXISTS time_idx ON ");
        i08.append(bVar4.getName());
        i08.append(" (");
        i08.append("created_at");
        i08.append(");");
        j = i08.toString();
    }

    public kc5(Context context) {
        this.f2047a = new a(context, "mixpanel");
    }

    public static kc5 g(Context context) {
        kc5 kc5;
        Map<Context, kc5> map = b;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                kc5 = new kc5(applicationContext);
                map.put(applicationContext, kc5);
            } else {
                kc5 = map.get(applicationContext);
            }
        }
        return kc5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0077, code lost:
        if (r1 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0079, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (r1 != null) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080 A[SYNTHETIC, Splitter:B:20:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(org.json.JSONObject r7, java.lang.String r8, defpackage.kc5.b r9, boolean r10) {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc5.a(org.json.JSONObject, java.lang.String, kc5$b, boolean):int");
    }

    public boolean b() {
        a aVar = this.f2047a;
        if (!aVar.f.exists() || Math.max(aVar.f.getUsableSpace(), (long) aVar.g.e) >= aVar.f.length()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3.f2047a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        r3.f2047a.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(defpackage.kc5.b r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = r4.getName()
            kc5$a r0 = r3.f2047a     // Catch:{ SQLiteException -> 0x002c }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x002c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x002c }
            r1.<init>()     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r2 = "token = '"
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002c }
            r1.append(r5)     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r5 = "'"
            r1.append(r5)     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r5 = r1.toString()     // Catch:{ SQLiteException -> 0x002c }
            r1 = 0
            r0.delete(r4, r5, r1)     // Catch:{ SQLiteException -> 0x002c }
        L_0x0024:
            kc5$a r4 = r3.f2047a
            r4.close()
            goto L_0x0032
        L_0x002a:
            r4 = move-exception
            goto L_0x0033
        L_0x002c:
            kc5$a r4 = r3.f2047a     // Catch:{ all -> 0x002a }
            r4.a()     // Catch:{ all -> 0x002a }
            goto L_0x0024
        L_0x0032:
            return
        L_0x0033:
            kc5$a r5 = r3.f2047a
            r5.close()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc5.c(kc5$b, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3.f2047a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        r3.f2047a.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(defpackage.kc5.b r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = r4.getName()
            kc5$a r0 = r3.f2047a     // Catch:{ SQLiteException -> 0x002c }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x002c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x002c }
            r1.<init>()     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r2 = "automatic_data = 1 AND token = '"
            r1.append(r2)     // Catch:{ SQLiteException -> 0x002c }
            r1.append(r5)     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r5 = "'"
            r1.append(r5)     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r5 = r1.toString()     // Catch:{ SQLiteException -> 0x002c }
            r1 = 0
            r0.delete(r4, r5, r1)     // Catch:{ SQLiteException -> 0x002c }
        L_0x0024:
            kc5$a r4 = r3.f2047a
            r4.close()
            goto L_0x0032
        L_0x002a:
            r4 = move-exception
            goto L_0x0033
        L_0x002c:
            kc5$a r4 = r3.f2047a     // Catch:{ all -> 0x002a }
            r4.a()     // Catch:{ all -> 0x002a }
            goto L_0x0024
        L_0x0032:
            return
        L_0x0033:
            kc5$a r5 = r3.f2047a
            r5.close()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc5.d(kc5$b, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3.f2047a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r3.f2047a.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(long r4, defpackage.kc5.b r6) {
        /*
            r3 = this;
            java.lang.String r6 = r6.getName()
            kc5$a r0 = r3.f2047a     // Catch:{ SQLiteException -> 0x0027 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0027 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0027 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0027 }
            java.lang.String r2 = "created_at <= "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x0027 }
            r1.append(r4)     // Catch:{ SQLiteException -> 0x0027 }
            java.lang.String r4 = r1.toString()     // Catch:{ SQLiteException -> 0x0027 }
            r5 = 0
            r0.delete(r6, r4, r5)     // Catch:{ SQLiteException -> 0x0027 }
        L_0x001f:
            kc5$a r4 = r3.f2047a
            r4.close()
            goto L_0x002d
        L_0x0025:
            r4 = move-exception
            goto L_0x002e
        L_0x0027:
            kc5$a r4 = r3.f2047a     // Catch:{ all -> 0x0025 }
            r4.a()     // Catch:{ all -> 0x0025 }
            goto L_0x001f
        L_0x002d:
            return
        L_0x002e:
            kc5$a r5 = r3.f2047a
            r5.close()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc5.e(long, kc5$b):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e7, code lost:
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e5 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0118 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] f(defpackage.kc5.b r17, java.lang.String r18, boolean r19) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc5.f(kc5$b, java.lang.String, boolean):java.lang.String[]");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0109, code lost:
        r14 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        defpackage.kc5.b.ANONYMOUS_PEOPLE.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0111, code lost:
        if (r13 != null) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0113, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0117, code lost:
        r6 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r12.f2047a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011d, code lost:
        if (r6 != null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011f, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0128, code lost:
        r14 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0129, code lost:
        r6 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012a, code lost:
        if (r6 != null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012c, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012f, code lost:
        r12.f2047a.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0134, code lost:
        throw r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x010c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0056 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005c A[SYNTHETIC, Splitter:B:11:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int h(java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc5.h(java.lang.String, java.lang.String):int");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057 A[LOOP:0: B:8:0x0051->B:11:0x0057, LOOP_END, SYNTHETIC, Splitter:B:11:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A[SYNTHETIC, Splitter:B:27:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i(java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc5.i(java.util.Map, java.lang.String):int");
    }
}
