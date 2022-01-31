package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import defpackage.dy1;

/* renamed from: kx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class kx1 implements dy1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f2131a;
    public final /* synthetic */ jv1 b;

    public /* synthetic */ kx1(long j, jv1 jv1) {
        this.f2131a = j;
        this.b = jv1;
    }

    @Override // defpackage.dy1.b
    public final Object apply(Object obj) {
        long j = this.f2131a;
        jv1 jv1 = this.b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{jv1.b(), String.valueOf(oy1.a(jv1.d()))}) < 1) {
            contentValues.put("backend_name", jv1.b());
            contentValues.put("priority", Integer.valueOf(oy1.a(jv1.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
