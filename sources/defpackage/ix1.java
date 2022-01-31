package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.dy1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* renamed from: ix1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ix1 implements dy1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dy1 f1580a;
    public final /* synthetic */ jv1 b;
    public final /* synthetic */ gv1 c;

    public /* synthetic */ ix1(dy1 dy1, jv1 jv1, gv1 gv1) {
        this.f1580a = dy1;
        this.b = jv1;
        this.c = gv1;
    }

    @Override // defpackage.dy1.b
    public final Object apply(Object obj) {
        long j;
        dy1 dy1 = this.f1580a;
        jv1 jv1 = this.b;
        gv1 gv1 = this.c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (dy1.c().compileStatement("PRAGMA page_size").simpleQueryForLong() * dy1.c().compileStatement("PRAGMA page_count").simpleQueryForLong() >= dy1.i.e()) {
            return -1L;
        }
        Long e = dy1.e(sQLiteDatabase, jv1);
        if (e != null) {
            j = e.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", jv1.b());
            contentValues.put("priority", Integer.valueOf(oy1.a(jv1.d())));
            contentValues.put("next_request_ms", (Integer) 0);
            if (jv1.c() != null) {
                contentValues.put("extras", Base64.encodeToString(jv1.c(), 0));
            }
            j = sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        int d = dy1.i.d();
        byte[] bArr = gv1.d().b;
        boolean z = bArr.length <= d;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(j));
        contentValues2.put("transport_name", gv1.g());
        contentValues2.put("timestamp_ms", Long.valueOf(gv1.e()));
        contentValues2.put("uptime_ms", Long.valueOf(gv1.h()));
        contentValues2.put("payload_encoding", gv1.d().f1174a.f4209a);
        contentValues2.put("code", gv1.c());
        contentValues2.put("num_attempts", (Integer) 0);
        contentValues2.put("inline", Boolean.valueOf(z));
        contentValues2.put("payload", z ? bArr : new byte[0]);
        long insert = sQLiteDatabase.insert(AnalyticsConstants.EVENTS, null, contentValues2);
        if (!z) {
            int ceil = (int) Math.ceil(((double) bArr.length) / ((double) d));
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (i - 1) * d, Math.min(i * d, bArr.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(insert));
                contentValues3.put("sequence_num", Integer.valueOf(i));
                contentValues3.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues3);
            }
        }
        for (Map.Entry entry : Collections.unmodifiableMap(gv1.b()).entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(insert));
            contentValues4.put("name", (String) entry.getKey());
            contentValues4.put(FirebaseAnalytics.Param.VALUE, (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues4);
        }
        return Long.valueOf(insert);
    }
}
