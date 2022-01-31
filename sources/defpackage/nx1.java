package defpackage;

import android.database.Cursor;
import defpackage.dy1;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: nx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class nx1 implements dy1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f2617a;

    public /* synthetic */ nx1(Map map) {
        this.f2617a = map;
    }

    @Override // defpackage.dy1.b
    public final Object apply(Object obj) {
        Map map = this.f2617a;
        Cursor cursor = (Cursor) obj;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new dy1.c(cursor.getString(1), cursor.getString(2), null));
        }
        return null;
    }
}
