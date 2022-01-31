package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/* renamed from: fy1  reason: default package */
/* compiled from: SchemaManager */
public final class fy1 extends SQLiteOpenHelper {
    public static final List<a> h = Arrays.asList(sx1.f3275a, px1.f2866a, qx1.f3001a, rx1.f3144a);
    public final int f;
    public boolean g = false;

    /* renamed from: fy1$a */
    /* compiled from: SchemaManager */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    @Inject
    public fy1(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f = i;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<a> list = h;
        if (i2 <= list.size()) {
            while (i < i2) {
                h.get(i).a(sQLiteDatabase);
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i + " to " + i2 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.g = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.f;
        if (!this.g) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.g) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.g) {
            onConfigure(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.g) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, i, i2);
    }
}
