package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.rabbitmq.client.StringRpcServer;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: jc3  reason: default package */
public final class jc3 extends yb3 implements Closeable {
    public static final String k = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    public static final String l = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    public final kc3 h;
    public final ee3 i = new ee3(this.f.c);
    public final ee3 j = new ee3(this.f.c);

    public jc3(ac3 ac3) {
        super(ac3);
        this.h = new kc3(this, ac3.f146a, "google_analytics_v4.db");
    }

    public final void A0(long j2) {
        jz1.c();
        g0();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j2));
        k("Deleting hit, id", Long.valueOf(j2));
        o0(arrayList);
    }

    public final Map<String, String> B0(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = str.length() != 0 ? "?".concat(str) : new String("?");
            }
            return fb2.a(new URI(str), StringRpcServer.STRING_ENCODING);
        } catch (URISyntaxException e) {
            L("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @Override // defpackage.yb3
    public final void a0() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.h.close();
        } catch (SQLiteException e) {
            L("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            L("Error closing database", e2);
        }
    }

    public final void endTransaction() {
        g0();
        i0().endTransaction();
    }

    public final SQLiteDatabase i0() {
        try {
            return this.h.getWritableDatabase();
        } catch (SQLiteException e) {
            J("Error opening database", e);
            throw e;
        }
    }

    public final boolean j0() {
        return y0() == 0;
    }

    public final long m0(long j2, String str, String str2) {
        gj1.j(str);
        gj1.j(str2);
        g0();
        jz1.c();
        return q0("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j2), str, str2});
    }

    public final void o0(List<Long> list) {
        Objects.requireNonNull(list, "null reference");
        jz1.c();
        g0();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i2 = 0; i2 < list.size(); i2++) {
                Long l2 = list.get(i2);
                if (l2 == null || l2.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(l2);
            }
            sb.append(")");
            String sb2 = sb.toString();
            try {
                SQLiteDatabase i0 = i0();
                k("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = i0.delete("hits2", sb2, null);
                if (delete != list.size()) {
                    j(5, "Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                }
            } catch (SQLiteException e) {
                L("Error deleting hits", e);
                throw e;
            }
        }
    }

    public final long q0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = i0().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            }
            rawQuery.close();
            return 0;
        } catch (SQLiteException e) {
            K("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void setTransactionSuccessful() {
        g0();
        i0().setTransactionSuccessful();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0149 A[Catch:{ SQLiteException -> 0x0159 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014f A[Catch:{ SQLiteException -> 0x0159 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w0(defpackage.nd3 r19) {
        /*
        // Method dump skipped, instructions count: 352
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jc3.w0(nd3):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<defpackage.nd3> x0(long r17) {
        /*
        // Method dump skipped, instructions count: 164
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jc3.x0(long):java.util.List");
    }

    public final long y0() {
        jz1.c();
        g0();
        Cursor cursor = null;
        try {
            Cursor rawQuery = i0().rawQuery("SELECT COUNT(*) FROM hits2", null);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            K("Database error", "SELECT COUNT(*) FROM hits2", e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final int z0() {
        jz1.c();
        g0();
        if (!this.i.b(86400000)) {
            return 0;
        }
        this.i.a();
        M("Deleting stale hits (if any)");
        SQLiteDatabase i0 = i0();
        Objects.requireNonNull((db2) this.f.c);
        int delete = i0.delete("hits2", "hit_time < ?", new String[]{Long.toString(System.currentTimeMillis() - 2592000000L)});
        k("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }
}
