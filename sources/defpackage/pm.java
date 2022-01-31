package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.io.File;

/* renamed from: pm  reason: default package */
/* compiled from: SupportSQLiteOpenHelper */
public interface pm extends Closeable {

    /* renamed from: pm$a */
    /* compiled from: SupportSQLiteOpenHelper */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f2828a;

        public a(int i) {
            this.f2828a = i;
        }

        public final void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception unused) {
                }
            }
        }

        public abstract void b(om omVar);

        public abstract void c(om omVar);

        public abstract void d(om omVar, int i, int i2);

        public abstract void e(om omVar);

        public abstract void f(om omVar, int i, int i2);
    }

    /* renamed from: pm$b */
    /* compiled from: SupportSQLiteOpenHelper */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2829a;
        public final String b;
        public final a c;
        public final boolean d;

        public b(Context context, String str, a aVar, boolean z) {
            this.f2829a = context;
            this.b = str;
            this.c = aVar;
            this.d = z;
        }
    }

    /* renamed from: pm$c */
    /* compiled from: SupportSQLiteOpenHelper */
    public interface c {
        pm a(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    om l0();

    void setWriteAheadLoggingEnabled(boolean z);
}
