package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.fy1;
import java.util.List;

/* renamed from: rx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class rx1 implements fy1.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ rx1 f3144a = new rx1();

    @Override // defpackage.fy1.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
        List<fy1.a> list = fy1.h;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }
}
