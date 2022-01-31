package defpackage;

import android.database.Cursor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ur3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class ur3 implements as3 {

    /* renamed from: a  reason: collision with root package name */
    public final vr3 f3546a;

    public ur3(vr3 vr3) {
        this.f3546a = vr3;
    }

    @Override // defpackage.as3
    public final Object zza() {
        Map map;
        vr3 vr3 = this.f3546a;
        Cursor query = vr3.f3677a.query(vr3.b, vr3.h, null, null, null);
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
