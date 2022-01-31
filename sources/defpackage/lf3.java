package defpackage;

import android.database.Cursor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: lf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final /* synthetic */ class lf3 implements rf3 {

    /* renamed from: a  reason: collision with root package name */
    public final mf3 f2208a;

    public lf3(mf3 mf3) {
        this.f2208a = mf3;
    }

    @Override // defpackage.rf3
    public final Object e() {
        Map map;
        mf3 mf3 = this.f2208a;
        Cursor query = mf3.f2369a.query(mf3.b, mf3.h, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new n2(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
