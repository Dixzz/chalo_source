package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.urbanairship.json.JsonValue;

/* renamed from: iw5  reason: default package */
/* compiled from: NotificationChannelRegistryDataManager */
public class iw5 extends ky5 {
    public iw5(Context context, String str, String str2) {
        super(context, str, str2, 2);
    }

    @Override // defpackage.ky5
    public void h(SQLiteDatabase sQLiteDatabase) {
        yj5.a("Creating database", new Object[0]);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notification_channels (id INTEGER PRIMARY KEY AUTOINCREMENT,channel_id TEXT UNIQUE,data TEXT);");
    }

    @Override // defpackage.ky5
    public void i(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notification_channels");
        h(sQLiteDatabase);
    }

    @Override // defpackage.ky5
    public void j(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            sQLiteDatabase.execSQL("DELETE FROM notification_channels WHERE rowid NOT IN ( SELECT max(rowid) FROM notification_channels GROUP BY channel_id);");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX notification_channels_channel_id ON notification_channels(channel_id);");
        } else if (i != 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notification_channels");
            h(sQLiteDatabase);
        }
    }

    public fw5 m(String str) {
        Cursor k = k("notification_channels", null, "channel_id = ?", new String[]{str}, null);
        fw5 fw5 = null;
        if (k == null) {
            return null;
        }
        k.moveToFirst();
        if (!k.isAfterLast()) {
            String string = k.getString(k.getColumnIndex("data"));
            try {
                fw5 = fw5.a(JsonValue.p(string));
            } catch (xt5 unused) {
                yj5.c("Unable to parse notification channel: %s", string);
            }
        }
        k.close();
        return fw5;
    }
}
