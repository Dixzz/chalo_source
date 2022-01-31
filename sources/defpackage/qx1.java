package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.fy1;
import java.util.List;

/* renamed from: qx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qx1 implements fy1.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ qx1 f3001a = new qx1();

    @Override // defpackage.fy1.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
        List<fy1.a> list = fy1.h;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
