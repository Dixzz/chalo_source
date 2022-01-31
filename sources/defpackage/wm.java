package defpackage;

import android.database.sqlite.SQLiteProgram;

/* renamed from: wm  reason: default package */
/* compiled from: FrameworkSQLiteProgram */
public class wm implements qm {
    public final SQLiteProgram f;

    public wm(SQLiteProgram sQLiteProgram) {
        this.f = sQLiteProgram;
    }

    @Override // defpackage.qm
    public void E0(int i) {
        this.f.bindNull(i);
    }

    @Override // defpackage.qm
    public void N(int i, double d) {
        this.f.bindDouble(i, d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    @Override // defpackage.qm
    public void d0(int i, long j) {
        this.f.bindLong(i, j);
    }

    @Override // defpackage.qm
    public void h0(int i, byte[] bArr) {
        this.f.bindBlob(i, bArr);
    }

    @Override // defpackage.qm
    public void z(int i, String str) {
        this.f.bindString(i, str);
    }
}
