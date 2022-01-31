package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.razorpay.AnalyticsConstants;
import defpackage.iy1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* renamed from: dy1  reason: default package */
/* compiled from: SQLiteEventStore */
public class dy1 implements xx1, iy1 {
    public static final zt1 j = new zt1("proto");
    public final fy1 f;
    public final jy1 g;
    public final jy1 h;
    public final yx1 i;

    /* renamed from: dy1$b */
    /* compiled from: SQLiteEventStore */
    public interface b<T, U> {
        U apply(T t);
    }

    /* renamed from: dy1$c */
    /* compiled from: SQLiteEventStore */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f904a;
        public final String b;

        public c(String str, String str2, a aVar) {
            this.f904a = str;
            this.b = str2;
        }
    }

    /* renamed from: dy1$d */
    /* compiled from: SQLiteEventStore */
    public interface d<T> {
        T a();
    }

    @Inject
    public dy1(jy1 jy1, jy1 jy12, yx1 yx1, fy1 fy1) {
        this.f = fy1;
        this.g = jy1;
        this.h = jy12;
        this.i = yx1;
    }

    public static String h(Iterable<cy1> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<cy1> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T i(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // defpackage.xx1
    public Iterable<cy1> I(jv1 jv1) {
        return (Iterable) f(new mx1(this, jv1));
    }

    @Override // defpackage.xx1
    public cy1 L0(jv1 jv1, gv1 gv1) {
        Object[] objArr = {jv1.d(), gv1.g(), jv1.b()};
        gj1.L("SQLiteEventStore");
        String.format("Storing event with priority=%s, name=%s for destination %s", objArr);
        long longValue = ((Long) f(new ix1(this, jv1, gv1))).longValue();
        if (longValue < 1) {
            return null;
        }
        return new wx1(longValue, jv1, gv1);
    }

    @Override // defpackage.xx1
    public void Q(jv1 jv1, long j2) {
        f(new kx1(j2, jv1));
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.xx1
    public long T0(jv1 jv1) {
        Long l;
        Cursor rawQuery = c().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{jv1.b(), String.valueOf(oy1.a(jv1.d()))});
        try {
            if (rawQuery.moveToNext()) {
                l = Long.valueOf(rawQuery.getLong(0));
            } else {
                l = 0L;
            }
            rawQuery.close();
            return l.longValue();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // defpackage.xx1
    public Iterable<jv1> W() {
        SQLiteDatabase c2 = c();
        c2.beginTransaction();
        try {
            List list = (List) i(c2.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), lx1.f2288a);
            c2.setTransactionSuccessful();
            return list;
        } finally {
            c2.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.xx1
    public boolean Y0(jv1 jv1) {
        Boolean bool;
        SQLiteDatabase c2 = c();
        c2.beginTransaction();
        try {
            Long e = e(c2, jv1);
            if (e == null) {
                bool = Boolean.FALSE;
            } else {
                bool = (Boolean) i(c().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{e.toString()}), tx1.f3417a);
            }
            c2.setTransactionSuccessful();
            c2.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th) {
            c2.endTransaction();
            throw th;
        }
    }

    @Override // defpackage.iy1
    public <T> T a(iy1.a<T> aVar) {
        SQLiteDatabase c2 = c();
        g(new jx1(c2), hx1.f1440a);
        try {
            T execute = aVar.execute();
            c2.setTransactionSuccessful();
            return execute;
        } finally {
            c2.endTransaction();
        }
    }

    public SQLiteDatabase c() {
        fy1 fy1 = this.f;
        Objects.requireNonNull(fy1);
        return (SQLiteDatabase) g(new ux1(fy1), fx1.f1181a);
    }

    @Override // defpackage.xx1
    public void c1(Iterable<cy1> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder i0 = hj1.i0("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            i0.append(h(iterable));
            String sb = i0.toString();
            SQLiteDatabase c2 = c();
            c2.beginTransaction();
            try {
                c2.compileStatement(sb).execute();
                c2.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                c2.setTransactionSuccessful();
            } finally {
                c2.endTransaction();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    public final Long e(SQLiteDatabase sQLiteDatabase, jv1 jv1) {
        Long l;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(jv1.b(), String.valueOf(oy1.a(jv1.d()))));
        if (jv1.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(jv1.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            if (!query.moveToNext()) {
                l = null;
            } else {
                l = Long.valueOf(query.getLong(0));
            }
            return l;
        } finally {
            query.close();
        }
    }

    public <T> T f(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase c2 = c();
        c2.beginTransaction();
        try {
            T apply = bVar.apply(c2);
            c2.setTransactionSuccessful();
            return apply;
        } finally {
            c2.endTransaction();
        }
    }

    public final <T> T g(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.h.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.h.a() >= ((long) this.i.a()) + a2) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.xx1
    public int s() {
        long a2 = this.g.a() - this.i.b();
        SQLiteDatabase c2 = c();
        c2.beginTransaction();
        try {
            Integer valueOf = Integer.valueOf(c2.delete(AnalyticsConstants.EVENTS, "timestamp_ms < ?", new String[]{String.valueOf(a2)}));
            c2.setTransactionSuccessful();
            c2.endTransaction();
            return valueOf.intValue();
        } catch (Throwable th) {
            c2.endTransaction();
            throw th;
        }
    }

    @Override // defpackage.xx1
    public void u(Iterable<cy1> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder i0 = hj1.i0("DELETE FROM events WHERE _id in ");
            i0.append(h(iterable));
            c().compileStatement(i0.toString()).execute();
        }
    }
}
