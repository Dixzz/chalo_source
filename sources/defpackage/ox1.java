package defpackage;

import android.database.Cursor;
import defpackage.bv1;
import defpackage.dy1;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* renamed from: ox1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ox1 implements dy1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dy1 f2740a;
    public final /* synthetic */ List b;
    public final /* synthetic */ jv1 c;

    public /* synthetic */ ox1(dy1 dy1, List list, jv1 jv1) {
        this.f2740a = dy1;
        this.b = list;
        this.c = jv1;
    }

    @Override // defpackage.dy1.b
    public final Object apply(Object obj) {
        zt1 zt1;
        zt1 zt12;
        dy1 dy1 = this.f2740a;
        List list = this.b;
        jv1 jv1 = this.c;
        Cursor cursor = (Cursor) obj;
        Objects.requireNonNull(dy1);
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            bv1.b bVar = new bv1.b();
            bVar.f = new HashMap();
            bVar.f(cursor.getString(1));
            bVar.e(cursor.getLong(2));
            bVar.g(cursor.getLong(3));
            if (z) {
                String string = cursor.getString(4);
                if (string == null) {
                    zt12 = dy1.j;
                } else {
                    zt12 = new zt1(string);
                }
                bVar.d(new fv1(zt12, cursor.getBlob(5)));
            } else {
                String string2 = cursor.getString(4);
                if (string2 == null) {
                    zt1 = dy1.j;
                } else {
                    zt1 = new zt1(string2);
                }
                bVar.d(new fv1(zt1, (byte[]) dy1.i(dy1.c().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), gx1.f1311a)));
            }
            if (!cursor.isNull(6)) {
                bVar.b = Integer.valueOf(cursor.getInt(6));
            }
            list.add(new wx1(j, jv1, bVar.b()));
        }
        return null;
    }
}
