package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.dy1;

/* renamed from: jx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class jx1 implements dy1.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f1991a;

    public /* synthetic */ jx1(SQLiteDatabase sQLiteDatabase) {
        this.f1991a = sQLiteDatabase;
    }

    @Override // defpackage.dy1.d
    public final Object a() {
        this.f1991a.beginTransaction();
        return null;
    }
}
