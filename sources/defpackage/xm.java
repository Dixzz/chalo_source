package defpackage;

import android.database.sqlite.SQLiteStatement;

/* renamed from: xm  reason: default package */
/* compiled from: FrameworkSQLiteStatement */
public class xm extends wm implements sm {
    public final SQLiteStatement g;

    public xm(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.g = sQLiteStatement;
    }

    @Override // defpackage.sm
    public int F() {
        return this.g.executeUpdateDelete();
    }

    @Override // defpackage.sm
    public long g1() {
        return this.g.executeInsert();
    }
}
