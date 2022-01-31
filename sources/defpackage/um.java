package defpackage;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import defpackage.pm;
import java.io.File;

/* renamed from: um  reason: default package */
/* compiled from: FrameworkSQLiteOpenHelper */
public class um implements pm {
    public final Context f;
    public final String g;
    public final pm.a h;
    public final boolean i;
    public final Object j = new Object();
    public a k;
    public boolean l;

    /* renamed from: um$a */
    /* compiled from: FrameworkSQLiteOpenHelper */
    public static class a extends SQLiteOpenHelper {
        public final tm[] f;
        public final pm.a g;
        public boolean h;

        /* renamed from: um$a$a  reason: collision with other inner class name */
        /* compiled from: FrameworkSQLiteOpenHelper */
        public class C0060a implements DatabaseErrorHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ pm.a f3525a;
            public final /* synthetic */ tm[] b;

            public C0060a(pm.a aVar, tm[] tmVarArr) {
                this.f3525a = aVar;
                this.b = tmVarArr;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
                r4 = r1.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
                if (r4.hasNext() != false) goto L_0x0034;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
                r0.a((java.lang.String) r4.next().second);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
                r0.a(r4.c());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
                throw r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
                if (r1 != null) goto L_0x002a;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0024 */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
            /* JADX WARNING: Removed duplicated region for block: B:6:0x0022 A[ExcHandler: all (r2v0 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
              PHI: (r1v9 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:4:0x001d, B:7:0x0024, B:8:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:4:0x001d] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCorruption(android.database.sqlite.SQLiteDatabase r4) {
                /*
                // Method dump skipped, instructions count: 109
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.um.a.C0060a.onCorruption(android.database.sqlite.SQLiteDatabase):void");
            }
        }

        public a(Context context, String str, tm[] tmVarArr, pm.a aVar) {
            super(context, str, null, aVar.f2828a, new C0060a(aVar, tmVarArr));
            this.g = aVar;
            this.f = tmVarArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
            if ((r1.f == r3) == false) goto L_0x000e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static defpackage.tm c(defpackage.tm[] r2, android.database.sqlite.SQLiteDatabase r3) {
            /*
                r0 = 0
                r1 = r2[r0]
                if (r1 == 0) goto L_0x000e
                android.database.sqlite.SQLiteDatabase r1 = r1.f
                if (r1 != r3) goto L_0x000b
                r1 = 1
                goto L_0x000c
            L_0x000b:
                r1 = 0
            L_0x000c:
                if (r1 != 0) goto L_0x0015
            L_0x000e:
                tm r1 = new tm
                r1.<init>(r3)
                r2[r0] = r1
            L_0x0015:
                r2 = r2[r0]
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.um.a.c(tm[], android.database.sqlite.SQLiteDatabase):tm");
        }

        public tm a(SQLiteDatabase sQLiteDatabase) {
            return c(this.f, sQLiteDatabase);
        }

        @Override // java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f[0] = null;
        }

        public synchronized om e() {
            this.h = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (this.h) {
                close();
                return e();
            }
            return a(writableDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.g.b(c(this.f, sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.g.c(c(this.f, sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.h = true;
            this.g.d(c(this.f, sQLiteDatabase), i, i2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.h) {
                this.g.e(c(this.f, sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.h = true;
            this.g.f(c(this.f, sQLiteDatabase), i, i2);
        }
    }

    public um(Context context, String str, pm.a aVar, boolean z) {
        this.f = context;
        this.g = str;
        this.h = aVar;
        this.i = z;
    }

    public final a a() {
        a aVar;
        synchronized (this.j) {
            if (this.k == null) {
                tm[] tmVarArr = new tm[1];
                if (Build.VERSION.SDK_INT < 23 || this.g == null || !this.i) {
                    this.k = new a(this.f, this.g, tmVarArr, this.h);
                } else {
                    this.k = new a(this.f, new File(this.f.getNoBackupFilesDir(), this.g).getAbsolutePath(), tmVarArr, this.h);
                }
                this.k.setWriteAheadLoggingEnabled(this.l);
            }
            aVar = this.k;
        }
        return aVar;
    }

    @Override // java.io.Closeable, defpackage.pm, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // defpackage.pm
    public String getDatabaseName() {
        return this.g;
    }

    @Override // defpackage.pm
    public om l0() {
        return a().e();
    }

    @Override // defpackage.pm
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.j) {
            a aVar = this.k;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z);
            }
            this.l = z;
        }
    }
}
