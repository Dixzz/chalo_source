package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.firebase.messaging.Constants;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: uu5  reason: default package */
/* compiled from: InboxJobHandler */
public class uu5 {

    /* renamed from: a  reason: collision with root package name */
    public final bv5 f3557a;
    public final kv5 b;
    public final qu5 c;
    public final hk5 d;
    public final kp5 e;
    public final tu5 f;

    public uu5(Context context, qu5 qu5, kv5 kv5, kp5 kp5, kq5 kq5, hk5 hk5) {
        bv5 bv5 = new bv5(context);
        tu5 tu5 = new tu5(kq5);
        this.c = qu5;
        this.b = kv5;
        this.e = kp5;
        this.d = hk5;
        this.f3557a = bv5;
        this.f = tu5;
    }

    public final boolean a() {
        String l = this.e.l();
        if (hd3.G1(l)) {
            yj5.a("No Channel. User will be created after channel registrations finishes.", new Object[0]);
            return false;
        }
        try {
            tq5<lv5> a2 = this.f.a(l);
            if (a2.c()) {
                T t = a2.e;
                yj5.f("InboxJobHandler - Created Rich Push user: %s", t.f2282a);
                this.d.f("com.urbanairship.user.LAST_UPDATE_TIME").b(String.valueOf(System.currentTimeMillis()));
                this.d.l("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME");
                this.b.e(t.f2282a, t.b, l);
                return true;
            }
            yj5.a("Rich Push user creation failed: %s", a2);
            return false;
        } catch (rq5 e2) {
            yj5.b(e2, "User creation failed.", new Object[0]);
            return false;
        }
    }

    public final void b() {
        String l = this.e.l();
        if (!hd3.G1(l)) {
            bv5 bv5 = this.f3557a;
            Collection<wu5> f2 = bv5.f(bv5.c(bv5.b, null, "deleted = ?", new String[]{"1"}, null));
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((ArrayList) f2).iterator();
            while (it.hasNext()) {
                wu5 wu5 = (wu5) it.next();
                JsonValue jsonValue = wu5.n;
                if (jsonValue != null) {
                    arrayList.add(jsonValue);
                    hashSet.add(wu5.j);
                }
            }
            if (hashSet.size() != 0) {
                yj5.h("Found %s messages to delete.", Integer.valueOf(hashSet.size()));
                try {
                    tq5<Void> e2 = this.f.e(this.b, l, arrayList);
                    yj5.h("Delete inbox messages response: %s", e2);
                    if (e2.c == 200) {
                        this.f3557a.e(hashSet);
                    }
                } catch (rq5 e3) {
                    yj5.b(e3, "Deleted message state synchronize failed.", new Object[0]);
                }
            }
        }
    }

    public final void c() {
        String l = this.e.l();
        if (!hd3.G1(l)) {
            bv5 bv5 = this.f3557a;
            Collection<wu5> f2 = bv5.f(bv5.c(bv5.b, null, "unread = ? AND unread <> unread_orig", new String[]{"0"}, null));
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((ArrayList) f2).iterator();
            while (it.hasNext()) {
                wu5 wu5 = (wu5) it.next();
                JsonValue jsonValue = wu5.n;
                if (jsonValue != null) {
                    arrayList.add(jsonValue);
                    hashSet.add(wu5.j);
                }
            }
            if (!hashSet.isEmpty()) {
                yj5.h("Found %s messages to mark read.", Integer.valueOf(hashSet.size()));
                try {
                    tq5<Void> f3 = this.f.f(this.b, l, arrayList);
                    yj5.h("Mark inbox messages read response: %s", f3);
                    if (f3.c == 200) {
                        bv5 bv52 = this.f3557a;
                        Objects.requireNonNull(bv52);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("unread_orig", Boolean.FALSE);
                        bv52.h(hashSet, contentValues);
                    }
                } catch (rq5 e2) {
                    yj5.b(e2, "Read message state synchronize failed.", new Object[0]);
                }
            }
        }
    }

    public final void d(yt5 yt5) {
        HashSet hashSet;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet2 = new HashSet();
        Iterator<JsonValue> it = yt5.iterator();
        while (true) {
            int i = -1;
            if (!it.hasNext()) {
                break;
            }
            JsonValue next = it.next();
            if (!(next.f instanceof zt5)) {
                yj5.c("InboxJobHandler - Invalid message payload: %s", next);
            } else {
                String i2 = next.n().u(Constants.MessagePayloadKeys.MSGID_SERVER).i();
                if (i2 == null) {
                    yj5.c("InboxJobHandler - Invalid message payload, missing message ID: %s", next);
                } else {
                    hashSet2.add(i2);
                    bv5 bv5 = this.f3557a;
                    ContentValues g = bv5.g(next);
                    if (g != null) {
                        i = bv5.d(Uri.withAppendedPath(bv5.b, i2), g, "message_id = ?", new String[]{i2});
                    }
                    if (i != 1) {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            bv5 bv52 = this.f3557a;
            Objects.requireNonNull(bv52);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ContentValues g2 = bv52.g((JsonValue) it2.next());
                if (g2 != null) {
                    g2.put("unread", g2.getAsBoolean("unread_orig"));
                    arrayList2.add(g2);
                }
            }
            if (!arrayList2.isEmpty()) {
                try {
                    bv52.b().bulkInsert(bv52.b, (ContentValues[]) arrayList2.toArray(new ContentValues[0]));
                } catch (Exception e2) {
                    yj5.e(e2, "Failed to bulk insert in UrbanAirshipProvider.", new Object[0]);
                }
            }
        }
        bv5 bv53 = this.f3557a;
        Cursor c2 = bv53.c(bv53.b, null, null, null, null);
        if (c2 == null) {
            hashSet = new HashSet();
        } else {
            HashSet hashSet3 = new HashSet(c2.getCount());
            int i3 = -1;
            while (c2.moveToNext()) {
                if (i3 == -1) {
                    i3 = c2.getColumnIndex(Constants.MessagePayloadKeys.MSGID_SERVER);
                }
                hashSet3.add(c2.getString(i3));
            }
            c2.close();
            hashSet = hashSet3;
        }
        hashSet.removeAll(hashSet2);
        this.f3557a.e(hashSet);
    }
}
