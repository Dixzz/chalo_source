package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.urbanairship.json.JsonValue;
import defpackage.by5;
import java.util.HashSet;
import java.util.Set;

/* renamed from: cy5  reason: default package */
/* compiled from: RemoteDataStore */
public class cy5 extends ky5 {
    public cy5(Context context, String str, String str2) {
        super(context, str, str2, 2);
    }

    @Override // defpackage.ky5
    public void h(SQLiteDatabase sQLiteDatabase) {
        yj5.a("Creating database", new Object[0]);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS payloads (id INTEGER PRIMARY KEY AUTOINCREMENT,type TEXT,time INTEGER,data TEXT,metadata TEXT);");
    }

    @Override // defpackage.ky5
    public void i(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Unable to downgrade database");
    }

    @Override // defpackage.ky5
    public void j(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != 1) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS payloads");
            h(sQLiteDatabase);
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE payloads ADD COLUMN metadata TEXT;");
    }

    public final Set<by5> m(Cursor cursor) {
        cursor.moveToFirst();
        HashSet hashSet = new HashSet();
        while (!cursor.isAfterLast()) {
            try {
                by5.b bVar = new by5.b();
                bVar.f492a = cursor.getString(cursor.getColumnIndex("type"));
                bVar.b = cursor.getLong(cursor.getColumnIndex("time"));
                bVar.d = JsonValue.p(cursor.getString(cursor.getColumnIndex("metadata"))).n();
                bVar.c = JsonValue.p(cursor.getString(cursor.getColumnIndex("data"))).n();
                hashSet.add(bVar.a());
            } catch (IllegalArgumentException | xt5 e) {
                yj5.e(e, "RemoteDataStore - failed to retrieve payload", new Object[0]);
            }
            cursor.moveToNext();
        }
        return hashSet;
    }
}
