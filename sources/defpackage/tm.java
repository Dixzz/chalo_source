package defpackage;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.IOException;
import java.util.List;

/* renamed from: tm  reason: default package */
/* compiled from: FrameworkSQLiteDatabase */
public class tm implements om {
    public static final String[] g = new String[0];
    public final SQLiteDatabase f;

    /* renamed from: tm$a */
    /* compiled from: FrameworkSQLiteDatabase */
    public class a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ rm f3376a;

        public a(tm tmVar, rm rmVar) {
            this.f3376a = rmVar;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f3376a.c(new wm(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* renamed from: tm$b */
    /* compiled from: FrameworkSQLiteDatabase */
    public class b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ rm f3377a;

        public b(tm tmVar, rm rmVar) {
            this.f3377a = rmVar;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f3377a.c(new wm(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public tm(SQLiteDatabase sQLiteDatabase) {
        this.f = sQLiteDatabase;
    }

    @Override // defpackage.om
    public Cursor D0(rm rmVar) {
        return this.f.rawQueryWithFactory(new a(this, rmVar), rmVar.a(), g, null);
    }

    @Override // defpackage.om
    public sm G(String str) {
        return new xm(this.f.compileStatement(str));
    }

    @Override // defpackage.om
    public boolean J0() {
        return this.f.inTransaction();
    }

    @Override // defpackage.om
    public Cursor U(rm rmVar, CancellationSignal cancellationSignal) {
        return this.f.rawQueryWithFactory(new b(this, rmVar), rmVar.a(), g, null, cancellationSignal);
    }

    @Override // defpackage.om
    public boolean V0() {
        return this.f.isWriteAheadLoggingEnabled();
    }

    public List<Pair<String, String>> a() {
        return this.f.getAttachedDbs();
    }

    @Override // defpackage.om
    public void beginTransaction() {
        this.f.beginTransaction();
    }

    public String c() {
        return this.f.getPath();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    @Override // defpackage.om
    public void e0(String str, Object[] objArr) throws SQLException {
        this.f.execSQL(str, objArr);
    }

    @Override // defpackage.om
    public void endTransaction() {
        this.f.endTransaction();
    }

    @Override // defpackage.om
    public void f0() {
        this.f.beginTransactionNonExclusive();
    }

    @Override // defpackage.om
    public boolean isOpen() {
        return this.f.isOpen();
    }

    @Override // defpackage.om
    public Cursor n0(String str) {
        return D0(new nm(str));
    }

    @Override // defpackage.om
    public void setTransactionSuccessful() {
        this.f.setTransactionSuccessful();
    }

    @Override // defpackage.om
    public void y(String str) throws SQLException {
        this.f.execSQL(str);
    }
}
