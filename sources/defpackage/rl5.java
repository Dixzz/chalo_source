package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.urbanairship.UrbanAirshipProvider;
import defpackage.zt5;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: rl5  reason: default package */
/* compiled from: EventResolver */
public class rl5 extends mk5 {
    public final Uri b;

    public rl5(Context context) {
        super(context);
        String str = UrbanAirshipProvider.i;
        StringBuilder i0 = hj1.i0("content://");
        i0.append(UrbanAirshipProvider.a(context));
        i0.append("/events");
        this.b = Uri.parse(i0.toString());
    }

    public boolean e(Set<String> set) {
        if (set == null || set.size() == 0) {
            yj5.h("Nothing to delete. Returning.", new Object[0]);
            return false;
        }
        int size = set.size();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < size) {
            sb.append("?");
            i++;
            if (i != size) {
                sb.append(", ");
            }
        }
        if (a(this.b, hj1.T("event_id IN ( ", sb.toString(), " )"), (String[]) set.toArray(new String[size])) > 0) {
            return true;
        }
        return false;
    }

    public int f() {
        Cursor c = c(this.b, new String[]{"SUM(event_size) as _size"}, null, null, null);
        if (c == null) {
            yj5.c("EventsStorage - Unable to query events database.", new Object[0]);
            return 0;
        }
        Integer valueOf = c.moveToFirst() ? Integer.valueOf(c.getInt(0)) : null;
        c.close();
        if (valueOf == null) {
            return 0;
        }
        return valueOf.intValue();
    }

    public Map<String, String> g(int i) {
        HashMap hashMap = new HashMap(i);
        Cursor c = c(this.b.buildUpon().appendQueryParameter("limit", String.valueOf(i)).build(), new String[]{"event_id", "data"}, null, null, "_id ASC");
        if (c == null) {
            return hashMap;
        }
        c.moveToFirst();
        while (!c.isAfterLast()) {
            hashMap.put(c.getString(0), c.getString(1));
            c.moveToNext();
        }
        c.close();
        return hashMap;
    }

    public void h(ll5 ll5, String str) {
        Objects.requireNonNull(ll5);
        zt5.b s = zt5.s();
        zt5 d = ll5.d();
        zt5.b s2 = zt5.s();
        s2.h(d);
        s2.f("session_id", str);
        zt5 a2 = s2.a();
        s.f("type", ll5.f());
        s.f("event_id", ll5.f);
        s.f("time", ll5.g);
        s.e("data", a2);
        String zt5 = s.a().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", ll5.f());
        contentValues.put("event_id", ll5.f);
        contentValues.put("data", zt5);
        contentValues.put("time", ll5.g);
        contentValues.put("session_id", str);
        contentValues.put("event_size", Integer.valueOf(zt5.length()));
        try {
            b().insert(this.b, contentValues);
        } catch (Exception e) {
            yj5.e(e, "Failed to insert in UrbanAirshipProvider.", new Object[0]);
        }
    }

    public void i(int i) {
        while (f() > i) {
            Cursor c = c(this.b.buildUpon().appendQueryParameter("limit", "1").build(), new String[]{"session_id"}, null, null, "_id ASC");
            String str = null;
            if (c == null) {
                yj5.c("EventsStorage - Unable to query database.", new Object[0]);
            } else {
                if (c.moveToFirst()) {
                    str = c.getString(0);
                }
                c.close();
            }
            if (!hd3.G1(str)) {
                yj5.a("Event database size exceeded. Deleting oldest session: %s", str);
                int a2 = a(this.b, "session_id = ?", new String[]{str});
                if (a2 > 0) {
                    yj5.a("Deleted %s rows with session ID %s", Integer.valueOf(a2), str);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
