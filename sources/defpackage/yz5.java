package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.io.File;

/* renamed from: yz5  reason: default package */
/* compiled from: FabricContext */
public class yz5 extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final String f4103a;
    public final String b;

    public yz5(Context context, String str, String str2) {
        super(context);
        this.b = str;
        this.f4103a = str2;
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f4103a);
    }

    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.f4103a);
        file.mkdirs();
        return new File(file, str);
    }

    @TargetApi(8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f4103a);
    }

    @TargetApi(8)
    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.f4103a);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f4103a);
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return super.getSharedPreferences(hj1.b0(new StringBuilder(), this.b, ProductDiscountsObject.KEY_DELIMITER, str), i);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @TargetApi(11)
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }
}
