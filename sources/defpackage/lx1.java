package defpackage;

import android.database.Cursor;
import android.util.Base64;
import defpackage.cv1;
import defpackage.dy1;
import defpackage.jv1;
import java.util.ArrayList;

/* renamed from: lx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class lx1 implements dy1.b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ lx1 f2288a = new lx1();

    @Override // defpackage.dy1.b
    public final Object apply(Object obj) {
        byte[] bArr;
        Cursor cursor = (Cursor) obj;
        zt1 zt1 = dy1.j;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            jv1.a a2 = jv1.a();
            a2.b(cursor.getString(1));
            a2.c(oy1.b(cursor.getInt(2)));
            String string = cursor.getString(3);
            if (string == null) {
                bArr = null;
            } else {
                bArr = Base64.decode(string, 0);
            }
            cv1.b bVar = (cv1.b) a2;
            bVar.b = bArr;
            arrayList.add(bVar.a());
        }
        return arrayList;
    }
}
