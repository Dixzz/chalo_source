package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.c.a.e;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c extends b {
    private static final String[] ee = new e().cR();
    private final Context context;

    public c(Context context2) {
        super(context2);
        this.context = context2;
    }

    private ContentValues b(Channel channel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(channel.getId()));
        contentValues.put("name", channel.getName());
        contentValues.put("icon", channel.getIconUrl());
        contentValues.put("position", Integer.toString(channel.getPosition()));
        contentValues.put("hidden", Integer.valueOf(channel.isHidden() ? 1 : 0));
        contentValues.put("type", channel.getChannelType());
        contentValues.put("is_default", Integer.valueOf(channel.isDefault() ? 1 : 0));
        contentValues.put("restricted", Integer.valueOf(channel.isRestricted() ? 1 : 0));
        contentValues.put("updated_at", Long.valueOf(channel.getUpdatedAt()));
        contentValues.put("channel_alias", channel.getChannelAlias());
        return contentValues;
    }

    private Channel b(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        boolean z = false;
        Channel channel = new Channel().setId(cursor.getLong(map.get("_id").intValue())).setName(cursor.getString(map.get("name").intValue())).setIconUrl(cursor.getString(map.get("icon").intValue())).setHidden(cursor.getInt(map.get("hidden").intValue()) == 1).setPosition(cursor.getInt(map.get("position").intValue())).setChannelType(cursor.getString(map.get("type").intValue())).setDefault(cursor.getInt(map.get("is_default").intValue()) == 1);
        if (cursor.getInt(map.get("restricted").intValue()) == 1) {
            z = true;
        }
        return channel.setRestricted(z).setUpdatedAt(cursor.getLong(map.get("updated_at").intValue())).setChannelAlias(cursor.getString(map.get("channel_alias").intValue()));
    }

    public List<Channel> a(List<String> list, boolean z) {
        Channel cw;
        List<Channel> d = d(list);
        g gVar = new g(this.context);
        for (Channel channel : d) {
            Message l = gVar.l(channel.getId());
            if (l != null) {
                channel.setLatestOrWelcomeMessage(l);
            }
        }
        if (z && k.isEmpty(d) && (cw = cw()) != null) {
            d.add(cw);
        }
        return d;
    }

    @Override // com.freshchat.consumer.sdk.c.b
    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("channel_alias", hj1.r(hashMap, "updated_at", hj1.r(hashMap, "restricted", hj1.r(hashMap, "is_default", hj1.r(hashMap, "type", hj1.r(hashMap, "position", hj1.r(hashMap, "hidden", hj1.r(hashMap, "icon", hj1.r(hashMap, "name", Integer.valueOf(cursor.getColumnIndex("name")), cursor, "icon"), cursor, "hidden"), cursor, "position"), cursor, "type"), cursor, "is_default"), cursor, "restricted"), cursor, "updated_at"), cursor, "channel_alias"));
        }
        return hashMap;
    }

    public void a(List<Channel> list, List<Tag> list2) {
        SQLiteDatabase cs = cs();
        cs.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hidden", (Integer) 1);
            cs.update("channels", contentValues, null, null);
            ArrayList arrayList = new ArrayList();
            for (Channel channel : list) {
                if (channel.getLatestOrWelcomeMessage() != null) {
                    arrayList.add(channel.getLatestOrWelcomeMessage());
                }
                cs.replace("channels", null, b(channel));
            }
            if (k.a(arrayList)) {
                g gVar = new g(this.context);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    gVar.a(cs(), (Message) it.next(), false);
                }
            }
            if (k.a(list2)) {
                new j(this.context).f(list2);
            }
            cs.setTransactionSuccessful();
        } catch (Exception unused) {
            ai.e("FRESHCHAT_WARNING", com.freshchat.consumer.sdk.b.c.CHANNEL_UPDATE_FAILED.toString());
        } catch (Throwable th) {
            cs.endTransaction();
            throw th;
        }
        cs.endTransaction();
    }

    public List<Channel> cv() {
        return a((List<String>) null, true);
    }

    public Channel cw() {
        Cursor cursor;
        Throwable th;
        Exception e;
        Channel channel = null;
        try {
            cursor = cs().query("channels", ee, "is_default = '1'", null, null, null, "CAST(_id as int)");
            try {
                if (b.b(cursor)) {
                    channel = b(cursor, a(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return channel;
                } catch (Throwable th2) {
                    th = th2;
                    b.c(cursor);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.a(e);
            b.c(cursor);
            return channel;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return channel;
    }

    public List<Channel> d(List<String> list) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            if (k.a(list)) {
                cursor = cs().rawQuery(" SELECT DISTINCT channels.*  FROM channels, (SELECT *  FROM tags WHERE " + j.a(k.b(list), Tag.TaggedType.CHANNEL) + ")  AS matching_tags  WHERE ( matching_tags." + "tagged_id" + " = " + "_id" + ") AND " + "hidden" + "= 0  ORDER BY " + "position", (String[]) list.toArray(new String[0]));
            } else {
                cursor = cs().query("channels", ee, "hidden = 0 AND restricted = 0", null, null, null, "position");
            }
            cursor2 = cursor;
            if (b.b(cursor2)) {
                Map<String, Integer> a2 = a(cursor2);
                do {
                    Channel b = b(cursor2, a2);
                    if (b != null) {
                        arrayList.add(b);
                    }
                } while (cursor2.moveToNext());
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor2);
        return arrayList;
    }

    public Channel e(long j) {
        Throwable th;
        Cursor cursor;
        Exception e;
        Channel channel = null;
        channel = null;
        Cursor cursor2 = null;
        try {
            cursor = cs().query("channels", ee, "_id=?", new String[]{Long.toString(j)}, null, null, null);
            try {
                if (b.b(cursor)) {
                    channel = b(cursor, a(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return channel;
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
            return channel;
        } catch (Throwable th3) {
            th = th3;
            b.c(cursor2);
            throw th;
        }
        b.c(cursor);
        return channel;
    }

    public List<Channel> gn() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = cs().query("channels", null, null, null, null, null, null, null);
            if (b.b(cursor)) {
                Map<String, Integer> a2 = a(cursor);
                do {
                    Channel b = b(cursor, a2);
                    if (b != null) {
                        arrayList.add(b);
                    }
                } while (cursor.moveToNext());
            }
            g gVar = new g(this.context);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Channel channel = (Channel) it.next();
                Message X = gVar.X(channel.getId() + "_welcome_message");
                if (X != null) {
                    channel.setLatestOrWelcomeMessage(X);
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }
}
