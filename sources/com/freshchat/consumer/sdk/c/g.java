package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.c.a.j;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class g extends b {
    public static final String TAG = "com.freshchat.consumer.sdk.c.g";
    private static final String[] el = new j().cR();
    public static final String kP;
    private Context context;
    private f ek;

    static {
        StringBuilder i0 = hj1.i0("SELECT CONV._id, CONV.channel_id,initiated_time FROM conversations AS CONV  JOIN custsat AS CSAT  ON (CONV._id=CSAT.conv_id AND CSAT._status=");
        i0.append(Csat.CSatStatus.NOT_RATED.asInt());
        i0.append(")");
        kP = i0.toString();
    }

    public g(Context context2) {
        super(context2);
        this.context = context2.getApplicationContext();
    }

    private void a(Cursor cursor, List<Message> list) {
        if (b.b(cursor)) {
            Map<String, Integer> a2 = a(cursor);
            do {
                Message f = f(cursor, a2);
                if (f != null) {
                    f.setMessageFragments(cy().W(f.getAlias()));
                    list.add(f);
                }
            } while (cursor.moveToNext());
        }
    }

    private static ContentValues c(Message message) {
        if (message.getAlias() == null) {
            message.setAlias(String.valueOf(System.nanoTime()));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("created_at", Long.valueOf(message.getCreatedMillis()));
        contentValues.put("_id", message.getAlias());
        contentValues.put("channel_id", Long.valueOf(message.getChannelId()));
        contentValues.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, Integer.valueOf(message.getMessageType()));
        contentValues.put("marketing_id", Long.valueOf(message.getMarketingId()));
        contentValues.put("conv_id", Long.valueOf(message.getConversationId()));
        contentValues.put("read", Integer.valueOf(message.isRead() ? 1 : 0));
        contentValues.put("user_id", message.getMessageUserAlias());
        contentValues.put("user_type", Integer.valueOf(message.getMessageUserType()));
        int i = 1;
        if (message.getUploadState() != 1) {
            i = 0;
        }
        contentValues.put("uploaded", Integer.valueOf(i));
        contentValues.put("should_translate", Integer.valueOf(message.getShouldTranslate()));
        String str = "[]";
        try {
            List<MessageFragment> replyFragments = message.getReplyFragments();
            if (k.a(replyFragments)) {
                str = ab.in().toJson(replyFragments, new l().getType());
            }
        } catch (Exception e) {
            q.a(e);
        }
        contentValues.put("reply_fragments", str);
        String str2 = "{}";
        try {
            if (message.getInternalMeta() != null) {
                str2 = ab.in().toJson(message.getInternalMeta());
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        contentValues.put("internal_meta", str2);
        contentValues.put("responded", Integer.valueOf(message.isResponded() ? 1 : 0));
        try {
            JSONObject jSONObject = new JSONObject();
            if (message.getId() > 0) {
                jSONObject.put("id", message.getId());
            }
            if (message.getReplyTo() != null) {
                jSONObject.put("replyTo", new JSONObject(ab.in().toJson(message.getReplyTo())));
            }
            contentValues.put("extras_json", jSONObject.toString());
        } catch (Exception e3) {
            q.a(e3);
        }
        return contentValues;
    }

    private Set<String> cA() {
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            cursor = cB();
            if (b.b(cursor)) {
                int columnIndex = cursor.getColumnIndex("_id");
                do {
                    hashSet.add(cursor.getString(columnIndex));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashSet;
    }

    private Cursor cB() {
        return cs().query("message", el, null, null, null, null, "created_at");
    }

    private List<Long> cG() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery(kP, null);
            RemoteConfig bD = ap.bD(this.context);
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("CONV.channel_id");
                int columnIndex2 = cursor.getColumnIndex("initiated_time");
                do {
                    boolean z = false;
                    if (au.a(bD)) {
                        z = au.a(bD, cursor.getLong(columnIndex2));
                    }
                    if (!z) {
                        arrayList.add(Long.valueOf(cursor.getLong(columnIndex)));
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    private f cy() {
        if (this.ek == null) {
            this.ek = new f(this.context);
        }
        return this.ek;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v85, types: [java.util.List] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01d6 A[Catch:{ Exception -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.freshchat.consumer.sdk.beans.Message f(android.database.Cursor r25, java.util.Map<java.lang.String, java.lang.Integer> r26) {
        /*
        // Method dump skipped, instructions count: 537
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.g.f(android.database.Cursor, java.util.Map):com.freshchat.consumer.sdk.beans.Message");
    }

    private boolean n(long j) {
        boolean z = false;
        if (j <= 0) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"created_at"}, "marketing_id =0  AND uploaded=1 AND user_type=0 AND channel_id = ?", new String[]{Long.toString(j)}, null, null, null);
            if (b.b(cursor) && cursor.getCount() > 0) {
                z = true;
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return z;
    }

    private long o(long j) {
        long j2 = 0;
        if (j <= 0) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"created_at"}, "marketing_id =0 AND channel_id = ?", new String[]{Long.toString(j)}, null, null, "created_at DESC ", "1");
            if (b.b(cursor)) {
                j2 = cursor.getLong(0);
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return j2;
    }

    public List<Message> A(long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("message", el, "message_type IN (" + Message.MessageType.MESSAGE_TYPE_CALENDER_INVITE_SENT_BY_AGENT.getIntValue() + ") AND " + "responded" + "!=" + 1 + " AND " + "channel_id" + "=?", new String[]{Long.toString(j)}, null, null, null);
            a(cursor, arrayList);
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public Message B(long j) {
        String z = cy().z(j);
        if (as.isEmpty(z)) {
            return null;
        }
        return X(z);
    }

    public Message X(String str) {
        Throwable th;
        Cursor cursor;
        Exception e;
        Cursor cursor2 = null;
        try {
            cursor = cs().query("message", el, "_id=?", new String[]{str}, null, null, null);
            try {
                int count = cursor.getCount();
                String str2 = TAG;
                ai.d(str2, "Message by alias " + str + " count " + count);
                if (b.b(cursor)) {
                    Message f = f(cursor, a(cursor));
                    if (f != null) {
                        f.setMessageFragments(cy().W(f.getAlias()));
                    }
                    ai.d(str2, "Message by alias " + str + " message " + f);
                    b.c(cursor);
                    return f;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    b.c(cursor2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.a(e);
            b.c(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            b.c(cursor2);
            throw th;
        }
        b.c(cursor);
        return null;
    }

    public List<Boolean> a(List<Message> list, long j) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        Set<String> cA = cA();
        Set<Long> cz = cz();
        try {
            cs().beginTransaction();
            for (Message message : list) {
                try {
                    String alias = message.getAlias();
                    long marketingId = message.getMarketingId();
                    if (cA.contains(alias)) {
                        str = TAG;
                        str2 = "Ignoring duplicate message " + alias;
                    } else if (marketingId <= 0 || !cz.contains(Long.valueOf(marketingId))) {
                        message.setChannelId(j);
                        arrayList.add(Boolean.valueOf(a(cs(), message)));
                    } else {
                        str = TAG;
                        str2 = "Ignoring duplicate marketing message " + marketingId;
                    }
                    ai.d(str, str2);
                } catch (Exception e) {
                    arrayList.add(Boolean.FALSE);
                    q.a(e);
                }
            }
            cs().setTransactionSuccessful();
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            cs().endTransaction();
            throw th;
        }
        cs().endTransaction();
        return arrayList;
    }

    @Override // com.freshchat.consumer.sdk.c.b
    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("conv_id", Integer.valueOf(cursor.getColumnIndex("conv_id")));
            hashMap.put("should_translate", hj1.r(hashMap, "responded", hj1.r(hashMap, "extras_json", hj1.r(hashMap, "internal_meta", hj1.r(hashMap, "reply_fragments", hj1.r(hashMap, "uploaded", hj1.r(hashMap, "read", hj1.r(hashMap, "created_at", hj1.r(hashMap, "user_type", hj1.r(hashMap, "user_id", hj1.r(hashMap, Constants.MessagePayloadKeys.MESSAGE_TYPE, hj1.r(hashMap, "marketing_id", hj1.r(hashMap, "_id", hj1.r(hashMap, "channel_id", Integer.valueOf(cursor.getColumnIndex("channel_id")), cursor, "_id"), cursor, "marketing_id"), cursor, Constants.MessagePayloadKeys.MESSAGE_TYPE), cursor, "user_id"), cursor, "user_type"), cursor, "created_at"), cursor, "read"), cursor, "uploaded"), cursor, "reply_fragments"), cursor, "internal_meta"), cursor, "extras_json"), cursor, "responded"), cursor, "should_translate"));
        }
        return hashMap;
    }

    public boolean a(long j, long j2) {
        long o = o(j);
        return n(j) && ((o > 0 ? 1 : (o == 0 ? 0 : -1)) > 0 && ((System.currentTimeMillis() - o) > j2 ? 1 : ((System.currentTimeMillis() - o) == j2 ? 0 : -1)) < 0);
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, Message message) {
        return a(sQLiteDatabase, message, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        if (r9 == false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        r7.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        if (r9 == false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.database.sqlite.SQLiteDatabase r7, com.freshchat.consumer.sdk.beans.Message r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.g.a(android.database.sqlite.SQLiteDatabase, com.freshchat.consumer.sdk.beans.Message, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[Catch:{ Exception -> 0x006c, all -> 0x006a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.database.sqlite.SQLiteDatabase r9) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.g.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public boolean b(Message message) {
        return a(cs(), message, true);
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("message", el, "reply_fragments LIKE ?", new String[]{"%rawJsonOfUnsupportedType%"}, null, null, null);
            if (cursor == null) {
                b.c(cursor);
                return;
            }
            Map<String, Integer> a2 = a(cursor);
            Integer num = a2.get("reply_fragments");
            if (num == null) {
                b.c(cursor);
                return;
            }
            if (b.b(cursor)) {
                do {
                    try {
                        JSONArray jSONArray = new JSONArray(cursor.getString(num.intValue()));
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                            if (jSONObject.has("rawJsonOfUnsupportedType")) {
                                jSONArray.put(i, new JSONObject(jSONObject.getString("rawJsonOfUnsupportedType")));
                            }
                        }
                        Message f = f(cursor, a2);
                        if (f != null) {
                            f.setReplyFragments((List) ab.io().fromJson(jSONArray.toString(), new o(this).getType()));
                            a(sQLiteDatabase, f);
                        }
                    } catch (Exception e) {
                        q.a(e);
                    }
                } while (cursor.moveToNext());
            }
            b.c(cursor);
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
    }

    public List<Message> cC() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("message", el, "display!=-1 AND uploaded=0 AND user_type=0", null, null, null, null);
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    Message f = f(cursor, a2);
                    f.setMessageFragments(cy().W(f.getAlias()));
                    arrayList.add(f);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public long cD() {
        long j = 0;
        Cursor cursor = null;
        try {
            String valueOf = String.valueOf(0);
            cursor = cs().rawQuery("SELECT MAX(created_at) as MAX_TIME FROM message WHERE user_type !=? ", new String[]{valueOf});
            if (cursor.moveToNext()) {
                j = cursor.getLong(0);
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return j;
    }

    public Map<Long, Integer> cF() {
        Long valueOf;
        int i;
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"channel_id", "COUNT(1)"}, "display!=-1 AND read=0", null, "channel_id", null, null);
            while (cursor.moveToNext()) {
                hashMap.put(Long.valueOf(cursor.getLong(0)), Integer.valueOf(cursor.getInt(1)));
            }
            for (Long l : cG()) {
                long longValue = l.longValue();
                if (hashMap.containsKey(Long.valueOf(longValue))) {
                    valueOf = Long.valueOf(longValue);
                    i = Integer.valueOf(((Integer) hashMap.get(Long.valueOf(longValue))).intValue() + 1);
                } else {
                    valueOf = Long.valueOf(longValue);
                    i = 1;
                }
                hashMap.put(valueOf, i);
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashMap;
    }

    public Set<Long> cz() {
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            cursor = cB();
            if (b.b(cursor)) {
                int columnIndex = cursor.getColumnIndex("marketing_id");
                do {
                    hashSet.add(Long.valueOf(cursor.getLong(columnIndex)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        String str = TAG;
        StringBuilder i0 = hj1.i0("Returning marketing IDs of size ");
        i0.append(hashSet.size());
        ai.d(str, i0.toString());
        return hashSet;
    }

    /* JADX INFO: finally extract failed */
    public int gr() {
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"_id"}, "user_type!= 0", null, null, null, null);
            int count = cursor.getCount();
            b.c(cursor);
            return count;
        } catch (Exception e) {
            q.a(e);
            b.c(cursor);
            return 0;
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
    }

    public Set<Long> i(long j) {
        HashSet hashSet = new HashSet();
        if (j <= 0) {
            return hashSet;
        }
        Cursor cursor = null;
        try {
            cursor = cs().query("message", new String[]{"marketing_id"}, "marketing_id > 0 AND read=0 AND channel_id = ?", new String[]{Long.toString(j)}, null, null, null);
            if (b.b(cursor)) {
                int columnIndex = cursor.getColumnIndex("marketing_id");
                do {
                    hashSet.add(Long.valueOf(cursor.getLong(columnIndex)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return hashSet;
    }

    public boolean j(long j) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = cs().query("message", el, "marketing_id=?", new String[]{String.valueOf(j)}, null, null, null);
            int count = cursor.getCount();
            String str = TAG;
            ai.d(str, "Message by marketing ID " + j);
            if (count > 0) {
                z = true;
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return z;
    }

    public List<String> jN() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query(true, "message", new String[]{"user_id"}, "uploaded=1 AND user_type=0", null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("user_id")));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Message> k(long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Map<String, List<MessageFragment>> h = cy().h(j);
            cursor = cs().query("message", el, "display!=-1 AND channel_id=?", new String[]{Long.toString(j)}, null, null, "created_at");
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    Message f = f(cursor, a2);
                    f.setMessageFragments(h.get(f.getAlias()));
                    arrayList.add(f);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public Message l(long j) {
        Throwable th;
        Exception e;
        Message message;
        Cursor cursor = null;
        Message message2 = null;
        try {
            Cursor query = cs().query("message", el, "channel_id=? AND display != -1", new String[]{Long.toString(j)}, null, null, "created_at DESC", "1");
            try {
                if (b.b(query)) {
                    message2 = f(query, a(query));
                    message2.setMessageFragments(cy().W(message2.getAlias()));
                }
                b.c(query);
                return message2;
            } catch (Exception e2) {
                e = e2;
                cursor = query;
                message = null;
                try {
                    q.a(e);
                    b.c(cursor);
                    return message;
                } catch (Throwable th2) {
                    th = th2;
                    b.c(cursor);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                b.c(cursor);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            message = null;
            q.a(e);
            b.c(cursor);
            return message;
        }
    }

    public int m(long j) {
        cs().beginTransaction();
        int i = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("read", (Integer) 1);
            i = cs().update("message", contentValues, "read=0 AND channel_id=?", new String[]{Long.toString(j)});
            cs().setTransactionSuccessful();
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            cs().endTransaction();
            throw th;
        }
        cs().endTransaction();
        return i;
    }

    public boolean p(long j) {
        for (Channel channel : new c(this.context).cv()) {
            if (a(channel.getId(), j)) {
                return true;
            }
        }
        return false;
    }
}
