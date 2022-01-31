package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import com.google.firebase.messaging.Constants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: vo5  reason: default package */
/* compiled from: LegacyDataMigrator */
public class vo5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3669a;
    public final kq5 b;
    public final hk5 c;

    /* renamed from: vo5$a */
    /* compiled from: LegacyDataMigrator */
    public static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f3670a;
        public final Set<String> b = new HashSet();
        public final oo5 c;

        public a(oo5 oo5, Set set, uo5 uo5) {
            this.c = oo5;
            this.f3670a = set;
        }

        @Override // defpackage.vo5.b
        public void a(wo5 wo5, List<xo5> list) {
            wo5.k = "in_app_message";
            if (this.f3670a.contains(wo5.b)) {
                zt5.b s = zt5.s();
                s.h(wo5.l.n());
                s.f("source", "remote-data");
                wo5.l = JsonValue.x(s.a());
            }
            String j = wo5.l.n().u(Constants.MessagePayloadKeys.MSGID_SERVER).j(wo5.b);
            if ("app-defined".equals(wo5.l.n().u("source").o())) {
                zt5.b s2 = zt5.s();
                s2.h(wo5.d);
                s2.f("com.urbanairship.original_schedule_id", wo5.b);
                s2.f("com.urbanairship.original_message_id", j);
                wo5.d = s2.a();
                String str = j;
                int i = 0;
                while (this.b.contains(str)) {
                    i++;
                    str = j + "#" + i;
                }
                j = str;
            }
            wo5.b = j;
            for (xo5 xo5 : list) {
                xo5.g = j;
            }
            this.b.add(j);
            JsonValue jsonValue = wo5.l.n().f.get("audience");
            if (jsonValue != null) {
                try {
                    wo5.u = fm5.a(jsonValue);
                } catch (xt5 e) {
                    yj5.e(e, "Unable to schedule due to audience JSON", new Object[0]);
                    return;
                }
            }
            yj5.h("Saving migrated message schedule: %s triggers: %s", wo5, list);
            this.c.n(wo5, list);
        }
    }

    /* renamed from: vo5$b */
    /* compiled from: LegacyDataMigrator */
    public interface b {
        void a(wo5 wo5, List<xo5> list);
    }

    public vo5(Context context, kq5 kq5, hk5 hk5) {
        this.f3669a = context.getApplicationContext();
        this.b = kq5;
        this.c = hk5;
    }

    public final void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (SQLException e) {
                yj5.e(e, "Failed to close cursor.", new Object[0]);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x01b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.database.Cursor r10, defpackage.vo5.b r11) {
        /*
        // Method dump skipped, instructions count: 458
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vo5.b(android.database.Cursor, vo5$b):void");
    }

    public final void c(to5 to5, b bVar) {
        Cursor cursor = null;
        try {
            cursor = to5.n();
            if (cursor != null) {
                b(cursor, bVar);
            }
        } catch (Exception e) {
            yj5.e(e, "Error when migrating database.", new Object[0]);
        } catch (Throwable th) {
            a(null);
            to5.m();
            to5.a();
            to5.d(this.f3669a);
            throw th;
        }
        a(cursor);
        to5.m();
        to5.a();
        to5.d(this.f3669a);
    }
}
