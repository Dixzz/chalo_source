package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import defpackage.q5;
import java.io.File;
import java.util.Objects;

/* renamed from: ky5  reason: default package */
/* compiled from: DataManager */
public abstract class ky5 {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteOpenHelper f2139a;
    public final String b;

    /* renamed from: ky5$a */
    /* compiled from: DataManager */
    public class a extends SQLiteOpenHelper {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            super.onConfigure(sQLiteDatabase);
            ky5.this.g(sQLiteDatabase);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            ky5.this.h(sQLiteDatabase);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            yj5.a("Downgrading database %s from version %s to %s", sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2));
            ky5.this.i(sQLiteDatabase, i, i2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            super.onOpen(sQLiteDatabase);
            Objects.requireNonNull(ky5.this);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            yj5.a("Upgrading database %s from version %s to %s", sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2));
            ky5.this.j(sQLiteDatabase, i, i2);
        }
    }

    public ky5(Context context, String str, String str2, int i) {
        String absolutePath;
        String T = hj1.T(str, "_", str2);
        Object obj = q5.f2896a;
        File file = new File(q5.c.c(context), "com.urbanairship.databases");
        if (!file.exists() && !file.mkdirs()) {
            yj5.c("Failed to create UA no backup directory.", new Object[0]);
        }
        File file2 = new File(file, T);
        File[] fileArr = {context.getDatabasePath(T), new File(file, str2), context.getDatabasePath(str2)};
        if (!file2.exists()) {
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    absolutePath = file2.getAbsolutePath();
                    break;
                }
                File file3 = fileArr[i2];
                if (file3.exists()) {
                    if (!file3.renameTo(file2)) {
                        absolutePath = file3.getAbsolutePath();
                        break;
                    }
                    File file4 = new File(file3.getAbsolutePath() + "-journal");
                    if (file4.exists()) {
                        if (!file4.renameTo(new File(file2.getAbsolutePath() + "-journal"))) {
                            yj5.c("Failed to move the journal file: " + file4, new Object[0]);
                        }
                    }
                }
                i2++;
            }
        } else {
            absolutePath = file2.getAbsolutePath();
        }
        this.b = absolutePath;
        this.f2139a = new a(context, absolutePath, null, i);
    }

    public void a() {
        try {
            this.f2139a.close();
        } catch (Exception e) {
            yj5.e(e, "Failed to close the database.", new Object[0]);
        }
    }

    public boolean b(Context context) {
        return context.getDatabasePath(this.b).exists();
    }

    public int c(String str, String str2, String[] strArr) {
        if (str2 == null) {
            str2 = "1";
        }
        SQLiteDatabase f = f();
        if (f == null) {
            return -1;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return f.delete(str, str2, strArr);
            } catch (Exception e) {
                yj5.e(e, "Unable to delete item from a database", new Object[0]);
            }
        }
        return -1;
    }

    public boolean d(Context context) {
        try {
            return context.getDatabasePath(this.b).delete();
        } catch (Exception e) {
            StringBuilder i0 = hj1.i0("Failed to delete database: ");
            i0.append(this.b);
            yj5.e(e, i0.toString(), new Object[0]);
            return false;
        }
    }

    public SQLiteDatabase e() {
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                return this.f2139a.getReadableDatabase();
            } catch (SQLiteException e) {
                SystemClock.sleep(100);
                yj5.e(e, "DataManager - Error opening readable database. Retrying...", new Object[i]);
            }
        }
        return null;
    }

    public SQLiteDatabase f() {
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                return this.f2139a.getWritableDatabase();
            } catch (SQLiteException e) {
                SystemClock.sleep(100);
                yj5.e(e, "DataManager - Error opening writable database. Retrying...", new Object[i]);
            }
        }
        return null;
    }

    @TargetApi(16)
    public void g(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void h(SQLiteDatabase sQLiteDatabase);

    public abstract void i(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public abstract void j(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public Cursor k(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return l(str, strArr, str2, strArr2, str3, null);
    }

    public Cursor l(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4) {
        SQLiteDatabase e = e();
        if (e == null) {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return e.query(str, strArr, str2, strArr2, null, null, str3, str4);
            } catch (SQLException e2) {
                yj5.e(e2, "Query Failed", new Object[0]);
            }
        }
        return null;
    }
}
