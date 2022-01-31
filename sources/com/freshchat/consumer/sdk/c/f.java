package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.UnknownFragment;
import com.freshchat.consumer.sdk.c.a.i;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.q;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f extends b {
    private static final String[] eh = new i().cR();

    public static class a {
        private MessageFragment ei;
        private String ej;
        private int position;

        public a(MessageFragment messageFragment, String str, int i) {
            this.ei = messageFragment;
            this.ej = str;
            this.position = i;
        }
    }

    public f(Context context) {
        super(context);
    }

    private ContentValues c(MessageFragment messageFragment, String str, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("position", Integer.valueOf(i));
        contentValues.put("uploaded", Integer.valueOf(i2));
        String aH = as.aH(messageFragment.getContent());
        String aH2 = as.aH(messageFragment.getContentType());
        contentValues.put("content", aH);
        contentValues.put(FirebaseAnalytics.Param.CONTENT_TYPE, aH2);
        contentValues.put("frag_type", Integer.valueOf(messageFragment.getFragmentType()));
        try {
            JSONObject jSONObject = new JSONObject(ab.io().toJson(messageFragment, new m(this).getType()));
            jSONObject.remove("content");
            jSONObject.remove("contentType");
            jSONObject.remove("fragmentType");
            contentValues.put("extras_json", jSONObject.toString());
        } catch (Exception e) {
            q.a(e);
        }
        return contentValues;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.freshchat.consumer.sdk.c.f.a e(android.database.Cursor r11, java.util.Map<java.lang.String, java.lang.Integer> r12) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.f.e(android.database.Cursor, java.util.Map):com.freshchat.consumer.sdk.c.f$a");
    }

    public List<MessageFragment> W(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("fragments", eh, "_id = ?", new String[]{str}, null, null, "position");
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    a e = e(cursor, a2);
                    if (e != null) {
                        arrayList.add(e.ei);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Boolean> a(SQLiteDatabase sQLiteDatabase, List<MessageFragment> list, String str, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            int b = k.b(list);
            for (int i2 = 0; i2 < b; i2++) {
                try {
                    arrayList.add(Boolean.valueOf(a(sQLiteDatabase, list.get(i2), str, i2, i)));
                } catch (Exception e) {
                    arrayList.add(Boolean.FALSE);
                    q.a(e);
                    throw e;
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return arrayList;
    }

    @Override // com.freshchat.consumer.sdk.c.b
    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("uploaded", hj1.r(hashMap, "extras_json", hj1.r(hashMap, "content", hj1.r(hashMap, FirebaseAnalytics.Param.CONTENT_TYPE, hj1.r(hashMap, "frag_type", hj1.r(hashMap, "position", Integer.valueOf(cursor.getColumnIndex("position")), cursor, "frag_type"), cursor, FirebaseAnalytics.Param.CONTENT_TYPE), cursor, "content"), cursor, "extras_json"), cursor, "uploaded"));
        }
        return hashMap;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("fragments", eh, "extras_json LIKE ?", new String[]{"%rawJsonOfUnsupportedType%"}, null, null, null);
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                Integer num = a2.get("extras_json");
                if (num == null) {
                    b.c(cursor);
                    return;
                }
                Integer num2 = a2.get("uploaded");
                if (num2 == null) {
                    b.c(cursor);
                    return;
                }
                do {
                    String string = cursor.getString(num.intValue());
                    if (!as.isEmpty(string) && string.contains("rawJsonOfUnsupportedType")) {
                        try {
                            a e = e(cursor, a2);
                            if (e != null && (e.ei instanceof UnknownFragment)) {
                                ((UnknownFragment) e.ei).setRawJsonOfUnsupportedType(new JSONObject(((UnknownFragment) e.ei).getRawJsonOfUnsupportedType()).getString("rawJsonOfUnsupportedType"));
                                a(sQLiteDatabase, e.ei, e.ej, e.position, cursor.getInt(num2.intValue()));
                            }
                        } catch (Exception e2) {
                            q.a(e2);
                        }
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e3) {
            q.a(e3);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, MessageFragment messageFragment, String str, int i, int i2) {
        try {
            return sQLiteDatabase.replace("fragments", null, c(messageFragment, str, i, i2)) != -1;
        } catch (Exception e) {
            q.a(e);
            return false;
        }
    }

    public boolean b(MessageFragment messageFragment, String str, int i, int i2) {
        try {
            ContentValues c = c(messageFragment, str, i, i2);
            cs().update("fragments", c, "_id=? AND position=?", new String[]{str, String.valueOf(i)});
            return true;
        } catch (Exception e) {
            q.a(e);
            return false;
        }
    }

    public Map<String, List<MessageFragment>> h(long j) {
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery("SELECT fragments.* FROM fragments JOIN message ON message._id = fragments._id WHERE display!=-1 AND channel_id=? ORDER BY _id,position", new String[]{Long.toString(j)});
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    a e = e(cursor, a2);
                    if (e != null) {
                        if (!hashMap.containsKey(e.ej)) {
                            hashMap.put(e.ej, new ArrayList());
                        }
                        List list = (List) hashMap.get(e.ej);
                        list.add(e.position, e.ei);
                        hashMap.put(e.ej, list);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashMap;
    }

    public String z(long j) {
        Throwable th;
        Exception e;
        String str;
        Cursor cursor = null;
        r0 = null;
        String str2 = null;
        try {
            Cursor rawQuery = cs().rawQuery("SELECT fragments.* FROM fragments JOIN message ON message._id = fragments._id WHERE display!=-1 AND frag_type=" + FragmentType.CALENDAR_EVENT.asInt() + " AND " + "channel_id" + "=? ORDER BY " + "_id" + "," + "position", new String[]{Long.toString(j)});
            try {
                if (b.b(rawQuery)) {
                    Map<String, Integer> a2 = a(rawQuery);
                    long fP = n.fP();
                    long j2 = 0;
                    do {
                        a e2 = e(rawQuery, a2);
                        if (e2 != null) {
                            if (e2.ei instanceof CalendarEventFragment) {
                                CalendarEventFragment calendarEventFragment = (CalendarEventFragment) e2.ei;
                                if (cm.a(calendarEventFragment)) {
                                    long startMillis = calendarEventFragment.getStartMillis();
                                    if (startMillis > 0) {
                                        if (startMillis >= fP) {
                                            if (j2 == 0 || startMillis < j2) {
                                                str2 = e2.ej;
                                                j2 = startMillis;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } while (rawQuery.moveToNext());
                }
                b.c(rawQuery);
                return str2;
            } catch (Exception e3) {
                e = e3;
                cursor = rawQuery;
                str = null;
                try {
                    q.a(e);
                    b.c(cursor);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    b.c(cursor);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                b.c(cursor);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            str = null;
            q.a(e);
            b.c(cursor);
            return str;
        }
    }
}
