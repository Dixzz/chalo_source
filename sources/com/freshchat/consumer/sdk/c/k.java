package com.freshchat.consumer.sdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.c.a.m;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import java.util.HashMap;
import java.util.Map;

public class k extends b {
    private static final String[] cR = new m().cR();
    private final Context context;

    public k(Context context2) {
        super(context2);
        this.context = context2;
    }

    private ContentValues b(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("meta_key", str);
        contentValues.put("meta_value", str2);
        contentValues.put("is_uploaded", (Integer) 0);
        contentValues.put("meta_type", Integer.valueOf(z ? 2 : 1));
        return contentValues;
    }

    private void b(String str, String str2) {
        if (as.a(str2)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_uploaded", (Integer) 1);
            cs().update("user_meta", contentValues, "meta_key = ?", new String[]{str});
        }
    }

    private void bu(String str) {
        try {
            cs().delete("user_meta", "meta_key = ? ", new String[]{str});
        } catch (Exception e) {
            q.a(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ Exception -> 0x0014, all -> 0x0011 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.User a(boolean r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.c.k.a(boolean, boolean):com.freshchat.consumer.sdk.beans.User");
    }

    @Override // com.freshchat.consumer.sdk.c.b
    public Map<String, Integer> a(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("meta_key", Integer.valueOf(cursor.getColumnIndex("meta_key")));
            hashMap.put("meta_type", hj1.r(hashMap, "meta_value", Integer.valueOf(cursor.getColumnIndex("meta_value")), cursor, "meta_type"));
        }
        return hashMap;
    }

    public void a(User user) {
        a("fc_user_first_name", user.getFirstName(), false);
        a("fc_user_last_name", user.getLastName(), false);
        a("fc_user_email", user.getEmail(), false);
        a("fc_user_phone", user.getPhone(), false);
        a("fc_user_phone_country", user.getPhoneCountry(), false);
        a("fc_user_ext_identifier", user.getExternalId(), false);
        a("fc_user_restore_id", user.getRestoreId(), false);
        a("fc_user_locale", user.getLocale(), false);
        a("fc_user_jwt_id_token", user.getJwtIdToken(), false);
        for (Map.Entry<String, String> entry : user.getMeta().entrySet()) {
            a(entry.getKey(), entry.getValue(), true);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (as.a(str2)) {
            ContentValues b = b(str, str2, z);
            if (cs().update("user_meta", b, "meta_key= ? AND meta_value!= ?", new String[]{str, str2}) == 0) {
                Cursor query = cs().query("user_meta", null, "meta_key = ?", new String[]{str}, null, null, null);
                if (b.j(query)) {
                    cs().insert("user_meta", null, b);
                }
                b.c(query);
            }
        }
    }

    public void b(User user) {
        for (Map.Entry<String, String> entry : user.getMeta().entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
        b("fc_user_first_name", user.getFirstName());
        b("fc_user_last_name", user.getLastName());
        b("fc_user_email", user.getEmail());
        b("fc_user_phone", user.getPhone());
        b("fc_user_phone_country", user.getPhoneCountry());
        b("fc_user_ext_identifier", user.getExternalId());
        b("fc_user_restore_id", user.getRestoreId());
        b("fc_user_locale", user.getLocale());
        b("fc_user_jwt_id_token", user.getJwtIdToken());
    }

    public boolean bV() {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = cs().query("user_meta", cR, "is_uploaded = 0", null, null, null, null, null);
            if (cursor.getCount() == 0) {
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

    public void iu() {
        bu("fc_user_restore_id");
    }
}
