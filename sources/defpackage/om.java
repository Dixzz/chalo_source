package defpackage;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import java.io.Closeable;

/* renamed from: om  reason: default package */
/* compiled from: SupportSQLiteDatabase */
public interface om extends Closeable {
    Cursor D0(rm rmVar);

    sm G(String str);

    boolean J0();

    Cursor U(rm rmVar, CancellationSignal cancellationSignal);

    boolean V0();

    void beginTransaction();

    void e0(String str, Object[] objArr) throws SQLException;

    void endTransaction();

    void f0();

    boolean isOpen();

    Cursor n0(String str);

    void setTransactionSuccessful();

    void y(String str) throws SQLException;
}
