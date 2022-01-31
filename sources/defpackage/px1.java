package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.fy1;
import java.util.List;

/* renamed from: px1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class px1 implements fy1.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ px1 f2866a = new px1();

    @Override // defpackage.fy1.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
        List<fy1.a> list = fy1.h;
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }
}
