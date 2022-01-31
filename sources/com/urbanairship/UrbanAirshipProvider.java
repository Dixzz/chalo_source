package com.urbanairship;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.google.firebase.messaging.Constants;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UrbanAirshipProvider extends ContentProvider {
    public static String i;
    public final UriMatcher f = new UriMatcher(-1);
    public a g;
    public a h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ky5 f718a;
        public final String b;
        public final String c;

        public a(ky5 ky5, String str, String str2) {
            this.f718a = ky5;
            this.b = str;
            this.c = str2;
        }
    }

    public static String a(Context context) {
        if (i == null) {
            i = hj1.S(context.getPackageName(), ".urbanairship.provider");
        }
        return i;
    }

    public final a b(Uri uri) {
        UAirship uAirship;
        if (getContext() == null || ((!UAirship.u && !UAirship.v) || (uAirship = UAirship.x) == null)) {
            return null;
        }
        String str = uAirship.e.f711a;
        int match = this.f.match(uri);
        if (match == 0 || match == 1) {
            if (this.g == null) {
                this.g = new a(new bk5(getContext(), str), "richpush", Constants.MessagePayloadKeys.MSGID_SERVER);
            }
            return this.g;
        } else if (match == 4 || match == 5) {
            if (this.h == null) {
                this.h = new a(new tl5(getContext(), str), AnalyticsConstants.EVENTS, "_id");
            }
            return this.h;
        } else {
            throw new IllegalArgumentException(hj1.N("Invalid URI: ", uri));
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        a b = b(uri);
        if (b == null || getContext() == null) {
            return -1;
        }
        ky5 ky5 = b.f718a;
        String str = b.b;
        SQLiteDatabase f2 = ky5.f();
        List arrayList = new ArrayList();
        if (f2 != null) {
            f2.beginTransaction();
            for (ContentValues contentValues : contentValuesArr) {
                try {
                    f2.replaceOrThrow(str, null, contentValues);
                } catch (Exception e) {
                    yj5.e(e, "Unable to insert into database", new Object[0]);
                    f2.endTransaction();
                    arrayList = Collections.emptyList();
                }
            }
            f2.setTransactionSuccessful();
            f2.endTransaction();
        }
        return arrayList.size();
    }

    public int delete(Uri uri, String str, String[] strArr) {
        a b = b(uri);
        if (b == null || getContext() == null || !b.f718a.b(getContext())) {
            return -1;
        }
        return b.f718a.c(b.b, str, strArr);
    }

    public String getType(Uri uri) {
        int match = this.f.match(uri);
        if (match == 0) {
            return "vnd.urbanairship.cursor.dir/richpush";
        }
        if (match == 1) {
            return "vnd.urbanairship.cursor.item/richpush";
        }
        if (match == 2) {
            return "vnd.urbanairship.cursor.dir/preference";
        }
        if (match == 3) {
            return "vnd.urbanairship.cursor.item/preference";
        }
        if (match == 4) {
            return "vnd.urbanairship.cursor.item/events";
        }
        if (match == 5) {
            return "vnd.urbanairship.cursor.dir/events";
        }
        throw new IllegalArgumentException(hj1.N("Invalid Uri: ", uri));
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        long j;
        a b = b(uri);
        if (!(b == null || getContext() == null || contentValues == null)) {
            ky5 ky5 = b.f718a;
            String str = b.b;
            if (ky5.f() != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 3) {
                        break;
                    }
                    try {
                        j = ky5.f().replaceOrThrow(str, null, contentValues);
                        break;
                    } catch (Exception e) {
                        yj5.e(e, "Unable to insert into database", new Object[0]);
                        i2++;
                    }
                }
            }
            j = -1;
            if (j != -1) {
                return Uri.withAppendedPath(uri, contentValues.getAsString(b.c));
            }
        }
        return null;
    }

    public boolean onCreate() {
        if (getContext() == null) {
            return false;
        }
        this.f.addURI(a(getContext()), "richpush", 0);
        this.f.addURI(a(getContext()), "richpush/*", 1);
        this.f.addURI(a(getContext()), AnalyticsConstants.PREFERENCES, 2);
        this.f.addURI(a(getContext()), "preferences/*", 3);
        this.f.addURI(a(getContext()), AnalyticsConstants.EVENTS, 5);
        this.f.addURI(a(getContext()), "events/*", 5);
        Autopilot.d((Application) getContext().getApplicationContext(), true);
        Object obj = UAirship.t;
        bm5.f(getContext().getApplicationContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        a b = b(uri);
        if (b == null || getContext() == null || !b.f718a.b(getContext())) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("limit");
        if (queryParameter != null) {
            cursor = b.f718a.l(b.b, strArr, str, strArr2, str2, hj1.S("0, ", queryParameter));
        } else {
            cursor = b.f718a.k(b.b, strArr, str, strArr2, str2);
        }
        if (cursor != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    public void shutdown() {
        a aVar = this.g;
        if (aVar != null) {
            aVar.f718a.a();
            this.g = null;
        }
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.f718a.a();
            this.h = null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a b = b(uri);
        int i2 = -1;
        if (b != null && getContext() != null) {
            ky5 ky5 = b.f718a;
            String str2 = b.b;
            SQLiteDatabase f2 = ky5.f();
            if (f2 != null) {
                for (int i3 = 0; i3 < 3; i3++) {
                    try {
                        i2 = f2.update(str2, contentValues, str, strArr);
                        break;
                    } catch (SQLException e) {
                        yj5.e(e, "Update Failed", new Object[0]);
                    }
                }
            }
        }
        return i2;
    }
}
