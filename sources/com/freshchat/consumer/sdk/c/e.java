package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.c.a.f;
import com.freshchat.consumer.sdk.c.a.g;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e extends b {
    private static final String[] ef = new f().cR();
    private static final String[] eg = new g().cR();
    private final Context context;

    public e(Context context2) {
        super(context2);
        this.context = context2;
    }

    private Conversation c(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        long j = cursor.getLong(map.get("_id").intValue());
        Conversation conversation = new Conversation(j);
        conversation.setChannelId(cursor.getLong(map.get("channel_id").intValue()));
        int i = cursor.getInt(map.get("has_pending_csat").intValue());
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        conversation.setHasPendingCsat(z);
        Csat g = g(j);
        if (g == null) {
            return conversation;
        }
        conversation.setCsat(g);
        return conversation;
    }

    private Csat d(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        Csat csat = new Csat();
        csat.setCsatId(cursor.getLong(map.get("csat_id").intValue()));
        csat.setQuestion(cursor.getString(map.get("question").intValue()));
        boolean z = false;
        csat.setMandatory(cursor.getInt(map.get("mandatory").intValue()) == 1);
        if (cursor.getInt(map.get("comments_allowed").intValue()) == 1) {
            z = true;
        }
        csat.setMobileUserCommentsAllowed(z);
        csat.setInitiatedTime(cursor.getLong(map.get("initiated_time").intValue()));
        csat.setStatus(Csat.CSatStatus.fromInt(cursor.getInt(map.get("_status").intValue())));
        return csat;
    }

    private Map<String, Integer> e(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("channel_id", Integer.valueOf(cursor.getColumnIndex("channel_id")));
            hashMap.put("has_pending_csat", hj1.r(hashMap, "_id", Integer.valueOf(cursor.getColumnIndex("_id")), cursor, "has_pending_csat"));
        }
        return hashMap;
    }

    private Map<String, Integer> f(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("csat_id", Integer.valueOf(cursor.getColumnIndex("csat_id")));
            hashMap.put("initiated_time", hj1.r(hashMap, "comments_allowed", hj1.r(hashMap, "mandatory", hj1.r(hashMap, "question", hj1.r(hashMap, "_status", Integer.valueOf(cursor.getColumnIndex("_status")), cursor, "question"), cursor, "mandatory"), cursor, "comments_allowed"), cursor, "initiated_time"));
        }
        return hashMap;
    }

    public void U(String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_status", Integer.valueOf(Csat.CSatStatus.RATED_NOT_UPLOADED.asInt()));
            cs().update("custsat", contentValues, "conv_id=?", new String[]{str});
        } catch (Exception e) {
            q.a(e);
        }
    }

    @Override // com.freshchat.consumer.sdk.c.b
    public Map<String, Integer> a(Cursor cursor) {
        return null;
    }

    public void a(long j, Csat csat) {
        if (csat != null) {
            try {
                SQLiteStatement compileStatement = cs().compileStatement(new g().k(false));
                cs().beginTransaction();
                compileStatement.clearBindings();
                compileStatement.bindLong(1, j);
                compileStatement.bindLong(2, csat.getCsatId());
                compileStatement.bindString(3, csat.getQuestion());
                long j2 = 1;
                compileStatement.bindLong(4, csat.isMobileUserCommentsAllowed() ? 1 : 0);
                if (!csat.isMandatory()) {
                    j2 = 0;
                }
                compileStatement.bindLong(5, j2);
                compileStatement.bindLong(6, (long) csat.getStatus().asInt());
                compileStatement.bindLong(7, csat.getInitiatedTime());
                compileStatement.executeInsert();
                cs().setTransactionSuccessful();
            } catch (Exception e) {
                q.a(e);
            } catch (Throwable th) {
                cs().endTransaction();
                throw th;
            }
            cs().endTransaction();
        }
    }

    public void a(Conversation conversation) {
        if (conversation != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(conversation);
            f(arrayList);
        }
    }

    public Conversation f(long j) {
        Throwable th;
        Cursor cursor;
        Exception e;
        Conversation conversation = null;
        conversation = null;
        Cursor cursor2 = null;
        try {
            cursor = cs().query("conversations", ef, "channel_id=?", new String[]{Long.toString(j)}, null, null, null);
            try {
                if (b.b(cursor)) {
                    conversation = c(cursor, e(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return conversation;
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
            return conversation;
        } catch (Throwable th3) {
            th = th3;
            b.c(cursor2);
            throw th;
        }
        b.c(cursor);
        return conversation;
    }

    public void f(List<Conversation> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new f().cS());
        cs().beginTransaction();
        h hVar = new h(this.context);
        for (int i = 0; i < list.size(); i++) {
            Conversation conversation = list.get(i);
            long conversationId = conversation.getConversationId();
            long j = 0;
            if (conversationId != 0) {
                List<Participant> participants = conversation.getParticipants();
                if (k.a(participants)) {
                    hVar.g(participants);
                }
                compileStatement.clearBindings();
                compileStatement.bindString(1, Long.toString(conversationId));
                compileStatement.bindLong(2, conversation.getChannelId());
                if (conversation.hasPendingCsat()) {
                    j = 1;
                }
                compileStatement.bindLong(3, j);
                compileStatement.execute();
            }
        }
        cs().setTransactionSuccessful();
        cs().endTransaction();
    }

    public void fR() {
        RemoteConfig bD = ap.bD(this.context);
        if (au.a(bD)) {
            Cursor cursor = null;
            try {
                cs().beginTransaction();
                cursor = cs().rawQuery(g.kP, null);
                ArrayList arrayList = new ArrayList();
                if (cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("CONV._id");
                    int columnIndex2 = cursor.getColumnIndex("initiated_time");
                    do {
                        if (au.a(bD, cursor.getLong(columnIndex2))) {
                            arrayList.add(cursor.getString(columnIndex));
                        }
                    } while (cursor.moveToNext());
                    if (k.a(arrayList)) {
                        SQLiteDatabase cs = cs();
                        cs.delete("custsat", "conv_id=" + as.a("?", ",", k.b(arrayList)), (String[]) arrayList.toArray(new String[0]));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("has_pending_csat", (Integer) 0);
                        SQLiteDatabase cs2 = cs();
                        cs2.update("conversations", contentValues, "_id=" + as.a("?", ",", k.b(arrayList)), (String[]) arrayList.toArray(new String[0]));
                    }
                }
                cs().setTransactionSuccessful();
            } catch (Exception e) {
                q.a(e);
            } catch (Throwable th) {
                b.c(null);
                cs().endTransaction();
                throw th;
            }
            b.c(cursor);
            cs().endTransaction();
        }
    }

    public Csat g(long j) {
        Throwable th;
        Cursor cursor;
        Exception e;
        Csat csat = null;
        csat = null;
        Cursor cursor2 = null;
        try {
            cursor = cs().query("custsat", eg, "conv_id=?", new String[]{Long.toString(j)}, null, null, null);
            try {
                if (b.b(cursor)) {
                    csat = d(cursor, f(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return csat;
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
            return csat;
        } catch (Throwable th3) {
            th = th3;
            b.c(cursor2);
            throw th;
        }
        b.c(cursor);
        return csat;
    }

    public void t(long j) {
        try {
            cs().beginTransaction();
            String l = Long.toString(j);
            cs().delete("custsat", "conv_id=?", new String[]{l});
            ContentValues contentValues = new ContentValues();
            contentValues.put("has_pending_csat", (Integer) 0);
            cs().update("conversations", contentValues, "_id=?", new String[]{l});
            cs().setTransactionSuccessful();
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            cs().endTransaction();
            throw th;
        }
        cs().endTransaction();
    }
}
