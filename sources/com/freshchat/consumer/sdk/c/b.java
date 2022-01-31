package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.c.a.c;
import com.freshchat.consumer.sdk.c.a.h;
import com.freshchat.consumer.sdk.c.a.n;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.q;
import java.util.List;
import java.util.Map;

public abstract class b {
    private static SQLiteDatabase eb;
    private final Context context;
    private a ec;

    public class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "freshchat.db", (SQLiteDatabase.CursorFactory) null, 7);
        }

        private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                i3++;
                for (String str : c.q(i3)) {
                    sQLiteDatabase.execSQL(str);
                }
                if (i == 1) {
                    StringBuilder i0 = hj1.i0("_status=");
                    i0.append(Csat.CSatStatus.NOT_RATED.asInt());
                    String sb = i0.toString();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("initiated_time", Long.valueOf(System.currentTimeMillis()));
                    sQLiteDatabase.update("custsat", contentValues, sb, null);
                    new g(b.this.context).b(sQLiteDatabase);
                }
                if (i3 == 5) {
                    new g(b.this.context).c(sQLiteDatabase);
                    new f(b.this.context).a(sQLiteDatabase);
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(SQLiteDatabase sQLiteDatabase, h[] hVarArr) {
            a(sQLiteDatabase, hVarArr, true);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(SQLiteDatabase sQLiteDatabase, h[] hVarArr, boolean z) {
            if (z) {
                sQLiteDatabase.beginTransaction();
            }
            try {
                for (h hVar : hVarArr) {
                    sQLiteDatabase.delete(hVar.cP(), null, null);
                }
                if (z) {
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (!z) {
                    return;
                }
            } catch (Exception e) {
                q.a(e);
                if (!z) {
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    sQLiteDatabase.endTransaction();
                }
                throw th;
            }
            sQLiteDatabase.endTransaction();
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            List<String> m = c.m(7);
            for (int i = 0; i < m.size(); i++) {
                m.get(i);
                sQLiteDatabase.execSQL(m.get(i));
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!sQLiteDatabase.isReadOnly()) {
                sQLiteDatabase.execSQL("PRAGMA foreign_keys=true;");
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            a(sQLiteDatabase, i, i2);
        }
    }

    public b(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public static void a(SQLiteStatement sQLiteStatement) {
        ad.a(sQLiteStatement);
    }

    public static boolean b(Cursor cursor) {
        return cursor != null && cursor.moveToFirst();
    }

    public static void c(Cursor cursor) {
        ad.a(cursor);
    }

    private a cr() {
        if (this.ec == null) {
            synchronized (b.class) {
                if (this.ec == null) {
                    this.ec = new a(this.context);
                }
            }
        }
        return this.ec;
    }

    public static boolean d(Cursor cursor) {
        return cursor != null && !cursor.isClosed();
    }

    public static boolean j(Cursor cursor) {
        return !b(cursor);
    }

    public abstract Map<String, Integer> a(Cursor cursor);

    public SQLiteDatabase cs() {
        if (eb == null) {
            synchronized (b.class) {
                if (eb == null) {
                    eb = cr().getWritableDatabase();
                }
            }
        }
        return eb;
    }

    public void ct() {
        if (cr() != null) {
            cr().a(cs(), n.eq);
        }
    }

    public void iQ() {
        if (cr() != null) {
            cr().a(cs(), n.qY);
        }
    }

    public void v(boolean z) {
        if (cr() != null) {
            cr().a((a) cs(), (SQLiteDatabase) n.er, (h[]) z);
        }
    }
}
