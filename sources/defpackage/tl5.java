package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: tl5  reason: default package */
/* compiled from: EventsStorage */
public class tl5 extends ky5 {
    public tl5(Context context, String str) {
        super(context, str, "ua_analytics.db", 1);
    }

    @Override // defpackage.ky5
    public void h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (_id INTEGER PRIMARY KEY AUTOINCREMENT,type TEXT,event_id TEXT,time INTEGER,data TEXT,session_id TEXT,event_size INTEGER);");
    }

    @Override // defpackage.ky5
    public void i(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        yj5.a("Downgrading analytics database from version %s to %s, which will destroy all data.", Integer.valueOf(i), Integer.valueOf(i2));
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (_id INTEGER PRIMARY KEY AUTOINCREMENT,type TEXT,event_id TEXT,time INTEGER,data TEXT,session_id TEXT,event_size INTEGER);");
    }

    @Override // defpackage.ky5
    public void j(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        yj5.a("Upgrading analytics database from version %s to %s, which will destroy all old data", Integer.valueOf(i), Integer.valueOf(i2));
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (_id INTEGER PRIMARY KEY AUTOINCREMENT,type TEXT,event_id TEXT,time INTEGER,data TEXT,session_id TEXT,event_size INTEGER);");
    }
}
