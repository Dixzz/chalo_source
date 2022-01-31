package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;

/* renamed from: na4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class na4 extends bc4 {
    public final qa4 c = new qa4(this, this.f3331a.f3627a, "google_app_measurement_local.db");
    public boolean d;

    public na4(vb4 vb4) {
        super(vb4);
    }

    public static long v(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (query.moveToFirst()) {
                long j = query.getLong(0);
                query.close();
                return j;
            }
            query.close();
            return -1;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // defpackage.bc4
    public final boolean u() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2 A[SYNTHETIC, Splitter:B:47:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0114 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(int r17, byte[] r18) {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.na4.w(int, byte[]):boolean");
    }

    public final void x() {
        b();
        try {
            int delete = z().delete("messages", null, null) + 0;
            if (delete > 0) {
                g().n.b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            g().f.b("Error resetting local analytics data. error", e);
        }
    }

    public final boolean y() {
        b();
        if (this.d || !this.f3331a.f3627a.getDatabasePath("google_app_measurement_local.db").exists()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase z = z();
                if (z == null) {
                    this.d = true;
                    if (z != null) {
                        z.close();
                    }
                    return false;
                }
                z.beginTransaction();
                z.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                z.setTransactionSuccessful();
                z.endTransaction();
                z.close();
                return true;
            } catch (SQLiteFullException e) {
                g().f.b("Error deleting app launch break from local database", e);
                this.d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep((long) i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e2) {
                if (0 != 0) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                g().f.b("Error deleting app launch break from local database", e2);
                this.d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        g().i.a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final SQLiteDatabase z() throws SQLiteException {
        if (this.d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.d = true;
        return null;
    }
}
