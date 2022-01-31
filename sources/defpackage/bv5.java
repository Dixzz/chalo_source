package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UrbanAirshipProvider;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* renamed from: bv5  reason: default package */
/* compiled from: MessageCenterResolver */
public class bv5 extends mk5 {
    public final Uri b;

    public bv5(Context context) {
        super(context);
        String str = UrbanAirshipProvider.i;
        StringBuilder i0 = hj1.i0("content://");
        i0.append(UrbanAirshipProvider.a(context));
        i0.append("/richpush");
        this.b = Uri.parse(i0.toString());
    }

    public int e(Set<String> set) {
        StringBuilder i0 = hj1.i0("message_id IN ( ");
        i0.append(hd3.D2("?", set.size(), ", "));
        i0.append(" )");
        return a(this.b, i0.toString(), (String[]) set.toArray(new String[0]));
    }

    public final Collection<wu5> f(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null) {
            return arrayList;
        }
        while (cursor.moveToNext()) {
            try {
                String string = cursor.getString(cursor.getColumnIndex("raw_message_object"));
                boolean z = true;
                boolean z2 = cursor.getInt(cursor.getColumnIndex("unread")) == 1;
                if (cursor.getInt(cursor.getColumnIndex("deleted")) != 1) {
                    z = false;
                }
                wu5 a2 = wu5.a(JsonValue.p(string), z2, z);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            } catch (xt5 e) {
                yj5.e(e, "RichPushResolver - Failed to parse message from the database.", new Object[0]);
            }
        }
        cursor.close();
        return arrayList;
    }

    public final ContentValues g(JsonValue jsonValue) {
        if (jsonValue == null || !(jsonValue.f instanceof zt5)) {
            yj5.c("RichPushResolver - Unexpected message: %s", jsonValue);
            return null;
        }
        zt5 n = jsonValue.n();
        if (hd3.G1(n.u(Constants.MessagePayloadKeys.MSGID_SERVER).i())) {
            yj5.c("RichPushResolver - Message is missing an ID: %s", jsonValue);
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", n.u("message_sent").i());
        contentValues.put(Constants.MessagePayloadKeys.MSGID_SERVER, n.u(Constants.MessagePayloadKeys.MSGID_SERVER).i());
        contentValues.put("message_url", n.u("message_url").i());
        contentValues.put("message_body_url", n.u("message_body_url").i());
        contentValues.put("message_read_url", n.u("message_read_url").i());
        contentValues.put(ProductPromotionsObject.KEY_TITLE, n.u(ProductPromotionsObject.KEY_TITLE).i());
        contentValues.put("unread_orig", Boolean.valueOf(n.u("unread").a(true)));
        contentValues.put("extra", n.u("extra").toString());
        contentValues.put("raw_message_object", n.toString());
        if (n.f.containsKey("message_expiry")) {
            contentValues.put("expiration_timestamp", n.u("message_expiry").i());
        }
        return contentValues;
    }

    public final int h(Set<String> set, ContentValues contentValues) {
        Uri uri = this.b;
        StringBuilder i0 = hj1.i0("message_id IN ( ");
        i0.append(hd3.D2("?", set.size(), ", "));
        i0.append(" )");
        return d(uri, contentValues, i0.toString(), (String[]) set.toArray(new String[0]));
    }
}
