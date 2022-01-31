package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: bk5  reason: default package */
/* compiled from: MessageCenterDataManager */
public class bk5 extends ky5 {
    public bk5(Context context, String str) {
        super(context, str, "ua_richpush.db", 3);
    }

    @Override // defpackage.ky5
    public void h(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS richpush (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_id TEXT UNIQUE, message_url TEXT, message_body_url TEXT, message_read_url TEXT, title TEXT, extra TEXT, unread INTEGER, unread_orig INTEGER, deleted INTEGER, timestamp TEXT, raw_message_object TEXT,expiration_timestamp TEXT);");
    }

    @Override // defpackage.ky5
    public void i(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS richpush");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS richpush (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_id TEXT UNIQUE, message_url TEXT, message_body_url TEXT, message_read_url TEXT, title TEXT, extra TEXT, unread INTEGER, unread_orig INTEGER, deleted INTEGER, timestamp TEXT, raw_message_object TEXT,expiration_timestamp TEXT);");
    }

    @Override // defpackage.ky5
    public void j(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE richpush ADD COLUMN raw_message_object TEXT;");
        } else if (i != 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS richpush");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS richpush (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_id TEXT UNIQUE, message_url TEXT, message_body_url TEXT, message_read_url TEXT, title TEXT, extra TEXT, unread INTEGER, unread_orig INTEGER, deleted INTEGER, timestamp TEXT, raw_message_object TEXT,expiration_timestamp TEXT);");
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE richpush ADD COLUMN expiration_timestamp TEXT;");
    }
}
