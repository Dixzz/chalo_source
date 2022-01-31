package defpackage;

import android.database.sqlite.SQLiteDatabase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.dy1;
import defpackage.gv1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;

/* renamed from: mx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class mx1 implements dy1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dy1 f2457a;
    public final /* synthetic */ jv1 b;

    public /* synthetic */ mx1(dy1 dy1, jv1 jv1) {
        this.f2457a = dy1;
        this.b = jv1;
    }

    @Override // defpackage.dy1.b
    public final Object apply(Object obj) {
        dy1 dy1 = this.f2457a;
        jv1 jv1 = this.b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Objects.requireNonNull(dy1);
        ArrayList arrayList = new ArrayList();
        Long e = dy1.e(sQLiteDatabase, jv1);
        if (e != null) {
            dy1.i(sQLiteDatabase.query(AnalyticsConstants.EVENTS, new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{e.toString()}, null, null, null, String.valueOf(dy1.i.c())), new ox1(dy1, arrayList, jv1));
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(((cy1) arrayList.get(i)).b());
            if (i < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        dy1.i(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", FirebaseAnalytics.Param.VALUE}, sb.toString(), null, null, null, null), new nx1(hashMap));
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            cy1 cy1 = (cy1) listIterator.next();
            if (hashMap.containsKey(Long.valueOf(cy1.b()))) {
                gv1.a i2 = cy1.a().i();
                for (dy1.c cVar : (Set) hashMap.get(Long.valueOf(cy1.b()))) {
                    i2.a(cVar.f904a, cVar.b);
                }
                listIterator.set(new wx1(cy1.b(), cy1.c(), i2.b()));
            }
        }
        return arrayList;
    }
}
