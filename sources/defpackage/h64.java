package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.freshchat.consumer.sdk.beans.User;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appindexing.Indexable;
import com.razorpay.AnalyticsConstants;
import defpackage.yq3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import server.zophop.Constants;

/* renamed from: h64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class h64 extends jg4 {
    public static final String[] f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] g = {FirebaseAnalytics.Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] h = {User.DEVICE_META_APP_VERSION_NAME, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", AnalyticsConstants.ANDROID_ID, "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    public static final String[] i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final i64 d = new i64(this, this.f3331a.f3627a, "google_app_measurement.db");
    public final fg4 e = new fg4(this.f3331a.n);

    public h64(lg4 lg4) {
        super(lg4);
    }

    public static void F(ContentValues contentValues, String str, Object obj) {
        gj1.j(str);
        Objects.requireNonNull(obj, "null reference");
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String A(long r5) {
        /*
            r4 = this;
            r4.b()
            r4.k()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.s()     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0038 }
            if (r1 != 0) goto L_0x0030
            ra4 r6 = r4.g()     // Catch:{ SQLiteException -> 0x0038 }
            ta4 r6 = r6.n     // Catch:{ SQLiteException -> 0x0038 }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.a(r1)     // Catch:{ SQLiteException -> 0x0038 }
            r5.close()
            return r0
        L_0x0030:
            java.lang.String r6 = r5.getString(r6)
            r5.close()
            return r6
        L_0x0038:
            r6 = move-exception
            goto L_0x003e
        L_0x003a:
            r6 = move-exception
            goto L_0x0051
        L_0x003c:
            r6 = move-exception
            r5 = r0
        L_0x003e:
            ra4 r1 = r4.g()     // Catch:{ all -> 0x004f }
            ta4 r1 = r1.f     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "Error selecting expired configs"
            r1.b(r2, r6)     // Catch:{ all -> 0x004f }
            if (r5 == 0) goto L_0x004e
            r5.close()
        L_0x004e:
            return r0
        L_0x004f:
            r6 = move-exception
            r0 = r5
        L_0x0051:
            if (r0 == 0) goto L_0x0056
            r0.close()
        L_0x0056:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.A(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<defpackage.vg4> B(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.B(java.lang.String):java.util.List");
    }

    public final List<Pair<yq3, Long>> C(String str, int i2, int i3) {
        b();
        k();
        gj1.b(i2 > 0);
        gj1.b(i3 > 0);
        gj1.j(str);
        Cursor cursor = null;
        try {
            Cursor query = s().query(Constants.QUEUE, new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
            if (!query.moveToFirst()) {
                List<Pair<yq3, Long>> emptyList = Collections.emptyList();
                query.close();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            do {
                long j2 = query.getLong(0);
                try {
                    byte[] R = j().R(query.getBlob(1));
                    if (!arrayList.isEmpty() && R.length + i4 > i3) {
                        break;
                    }
                    try {
                        yq3.a aVar = (yq3.a) rg4.w(yq3.t0(), R);
                        if (!query.isNull(2)) {
                            int i5 = query.getInt(2);
                            if (aVar.h) {
                                aVar.i();
                                aVar.h = false;
                            }
                            yq3.U0((yq3) aVar.g, i5);
                        }
                        i4 += R.length;
                        arrayList.add(Pair.create((yq3) ((ru3) aVar.k()), Long.valueOf(j2)));
                    } catch (IOException e2) {
                        g().f.c("Failed to merge queued bundle. appId", ra4.q(str), e2);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } catch (IOException e3) {
                    g().f.c("Failed to unzip queued bundle. appId", ra4.q(str), e3);
                }
            } while (i4 <= i3);
            query.close();
            return arrayList;
        } catch (SQLiteException e4) {
            g().f.c("Error querying bundles. appId", ra4.q(str), e4);
            List<Pair<yq3, Long>> emptyList2 = Collections.emptyList();
            if (0 != 0) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ea, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00eb, code lost:
        r4 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010f, code lost:
        r0 = java.util.Collections.emptyList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0113, code lost:
        if (r12 != null) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0115, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0118, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011b, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0123, code lost:
        r10.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0103 A[Catch:{ all -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<defpackage.vg4> D(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.D(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final List<zzz> E(String str, String[] strArr) {
        b();
        k();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = s().query("conditional_properties", new String[]{"app_id", FirebaseAnalytics.Param.ORIGIN, "name", FirebaseAnalytics.Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object z2 = z(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j2 = cursor.getLong(6);
                    rg4 j3 = j();
                    byte[] blob = cursor.getBlob(7);
                    Parcelable.Creator<zzaq> creator = zzaq.CREATOR;
                    long j4 = cursor.getLong(8);
                    arrayList.add(new zzz(string, string2, new zzku(string3, cursor.getLong(10), z2, string2), j4, z, string4, (zzaq) j3.t(blob, creator), j2, (zzaq) j().t(cursor.getBlob(9), creator), cursor.getLong(11), (zzaq) j().t(cursor.getBlob(12), creator)));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    g().f.b("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf((int) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
                    break;
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e2) {
            g().f.b("Error querying conditional user property value", e2);
            List<zzz> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void G(m64 m64) {
        Objects.requireNonNull(m64, "null reference");
        b();
        k();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", m64.f2331a);
        contentValues.put("name", m64.b);
        contentValues.put("lifetime_count", Long.valueOf(m64.c));
        contentValues.put("current_bundle_count", Long.valueOf(m64.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(m64.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(m64.g));
        contentValues.put("last_bundled_day", m64.h);
        contentValues.put("last_sampled_complex_event_id", m64.i);
        contentValues.put("last_sampling_rate", m64.j);
        contentValues.put("current_session_count", Long.valueOf(m64.e));
        Boolean bool = m64.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (s().insertWithOnConflict(AnalyticsConstants.EVENTS, null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update event aggregates (got -1). appId", ra4.q(m64.f2331a));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing event aggregates. appId", ra4.q(m64.f2331a), e2);
        }
    }

    public final void H(bb4 bb4) {
        b();
        k();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", bb4.o());
        contentValues.put("app_instance_id", bb4.s());
        contentValues.put("gmp_app_id", bb4.v());
        contentValues.put("resettable_device_id_hash", bb4.E());
        contentValues.put("last_bundle_index", Long.valueOf(bb4.U()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(bb4.K()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(bb4.L()));
        contentValues.put(User.DEVICE_META_APP_VERSION_NAME, bb4.M());
        contentValues.put("app_store", bb4.O());
        contentValues.put("gmp_version", Long.valueOf(bb4.P()));
        contentValues.put("dev_cert_hash", Long.valueOf(bb4.Q()));
        contentValues.put("measurement_enabled", Boolean.valueOf(bb4.T()));
        bb4.f405a.f().b();
        contentValues.put("day", Long.valueOf(bb4.x));
        bb4.f405a.f().b();
        contentValues.put("daily_public_events_count", Long.valueOf(bb4.y));
        bb4.f405a.f().b();
        contentValues.put("daily_events_count", Long.valueOf(bb4.z));
        bb4.f405a.f().b();
        contentValues.put("daily_conversions_count", Long.valueOf(bb4.A));
        bb4.f405a.f().b();
        contentValues.put("config_fetched_time", Long.valueOf(bb4.F));
        bb4.f405a.f().b();
        contentValues.put("failed_config_fetch_time", Long.valueOf(bb4.G));
        contentValues.put("app_version_int", Long.valueOf(bb4.N()));
        contentValues.put("firebase_instance_id", bb4.H());
        bb4.f405a.f().b();
        contentValues.put("daily_error_events_count", Long.valueOf(bb4.B));
        bb4.f405a.f().b();
        contentValues.put("daily_realtime_events_count", Long.valueOf(bb4.C));
        bb4.f405a.f().b();
        contentValues.put("health_monitor_sample", bb4.D);
        contentValues.put(AnalyticsConstants.ANDROID_ID, Long.valueOf(bb4.g()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(bb4.h()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(bb4.i()));
        contentValues.put("admob_app_id", bb4.y());
        contentValues.put("dynamite_version", Long.valueOf(bb4.S()));
        if (bb4.k() != null) {
            if (bb4.k().size() == 0) {
                g().i.b("Safelisted events should not be an empty list. appId", bb4.o());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", bb4.k()));
            }
        }
        if (e04.a() && this.f3331a.g.t(bb4.o(), q64.j0)) {
            contentValues.put("ga_app_id", bb4.B());
        }
        try {
            SQLiteDatabase s = s();
            if (((long) s.update("apps", contentValues, "app_id = ?", new String[]{bb4.o()})) == 0 && s.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update app (got -1). appId", ra4.q(bb4.o()));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing app. appId", ra4.q(bb4.o()), e2);
        }
    }

    public final void I(List<Long> list) {
        b();
        k();
        Objects.requireNonNull(list, "null reference");
        if (list.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        } else if (Q()) {
            String join = TextUtils.join(",", list);
            String y = hj1.y(hj1.g0(join, 2), "(", join, ")");
            if (R(hj1.y(hj1.g0(y, 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", y, " AND retry_count =  2147483647 LIMIT 1"), null) > 0) {
                g().i.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase s = s();
                StringBuilder sb = new StringBuilder(String.valueOf(y).length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(y);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                s.execSQL(sb.toString());
            } catch (SQLiteException e2) {
                g().f.b("Error incrementing retry count. error", e2);
            }
        }
    }

    public final boolean J(yq3 yq3, boolean z) {
        b();
        k();
        gj1.j(yq3.F1());
        gj1.n(yq3.m1());
        h0();
        Objects.requireNonNull((db2) this.f3331a.n);
        long currentTimeMillis = System.currentTimeMillis();
        if (yq3.n1() < currentTimeMillis - d64.A() || yq3.n1() > d64.A() + currentTimeMillis) {
            g().i.d("Storing bundle outside of the max uploading time span. appId, now, timestamp", ra4.q(yq3.F1()), Long.valueOf(currentTimeMillis), Long.valueOf(yq3.n1()));
        }
        try {
            byte[] S = j().S(yq3.h());
            g().n.b("Saving bundle, size", Integer.valueOf(S.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", yq3.F1());
            contentValues.put("bundle_end_timestamp", Long.valueOf(yq3.n1()));
            contentValues.put("data", S);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (yq3.e0()) {
                contentValues.put("retry_count", Integer.valueOf(yq3.m0()));
            }
            try {
                if (s().insert(Constants.QUEUE, null, contentValues) != -1) {
                    return true;
                }
                g().f.b("Failed to insert bundle (got -1). appId", ra4.q(yq3.F1()));
                return false;
            } catch (SQLiteException e2) {
                g().f.c("Error storing bundle. appId", ra4.q(yq3.F1()), e2);
                return false;
            }
        } catch (IOException e3) {
            g().f.c("Data loss. Failed to serialize bundle. appId", ra4.q(yq3.F1()), e3);
            return false;
        }
    }

    public final boolean K(n64 n64, long j2, boolean z) {
        b();
        k();
        gj1.j(n64.f2517a);
        byte[] h2 = j().u(n64).h();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", n64.f2517a);
        contentValues.put("name", n64.b);
        contentValues.put("timestamp", Long.valueOf(n64.d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", h2);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (s().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            g().f.b("Failed to insert raw event (got -1). appId", ra4.q(n64.f2517a));
            return false;
        } catch (SQLiteException e2) {
            g().f.c("Error storing raw event. appId", ra4.q(n64.f2517a), e2);
            return false;
        }
    }

    public final boolean L(vg4 vg4) {
        b();
        k();
        if (X(vg4.f3646a, vg4.c) == null) {
            if (ug4.W(vg4.c)) {
                long R = R("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{vg4.f3646a});
                d64 d64 = this.f3331a.g;
                String str = vg4.f3646a;
                Objects.requireNonNull(d64);
                int i2 = 25;
                if (py3.a() && d64.t(null, q64.w0)) {
                    i2 = Math.max(Math.min(d64.o(str, q64.G), 100), 25);
                }
                if (R >= ((long) i2)) {
                    return false;
                }
            } else if (!"_npa".equals(vg4.c)) {
                if (R("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{vg4.f3646a, vg4.b}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", vg4.f3646a);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, vg4.b);
        contentValues.put("name", vg4.c);
        contentValues.put("set_timestamp", Long.valueOf(vg4.d));
        F(contentValues, FirebaseAnalytics.Param.VALUE, vg4.e);
        try {
            if (s().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update user property (got -1). appId", ra4.q(vg4.f3646a));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing user property. appId", ra4.q(vg4.f3646a), e2);
        }
        return true;
    }

    public final boolean M(zzz zzz) {
        b();
        k();
        if (X(zzz.f, zzz.h.g) == null) {
            if (R("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzz.f}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzz.f);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzz.g);
        contentValues.put("name", zzz.h.g);
        F(contentValues, FirebaseAnalytics.Param.VALUE, zzz.h.l1());
        contentValues.put("active", Boolean.valueOf(zzz.j));
        contentValues.put("trigger_event_name", zzz.k);
        contentValues.put("trigger_timeout", Long.valueOf(zzz.m));
        h();
        contentValues.put("timed_out_event", ug4.f0(zzz.l));
        contentValues.put("creation_timestamp", Long.valueOf(zzz.i));
        h();
        contentValues.put("triggered_event", ug4.f0(zzz.n));
        contentValues.put("triggered_timestamp", Long.valueOf(zzz.h.h));
        contentValues.put("time_to_live", Long.valueOf(zzz.o));
        h();
        contentValues.put("expired_event", ug4.f0(zzz.p));
        try {
            if (s().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                g().f.b("Failed to insert/update conditional user property (got -1)", ra4.q(zzz.f));
            }
        } catch (SQLiteException e2) {
            g().f.c("Error storing conditional user property", ra4.q(zzz.f), e2);
        }
        return true;
    }

    public final boolean N(String str, int i2, dq3 dq3) {
        k();
        b();
        gj1.j(str);
        Objects.requireNonNull(dq3, "null reference");
        Integer num = null;
        if (TextUtils.isEmpty(dq3.y())) {
            ta4 ta4 = g().i;
            Object q = ra4.q(str);
            Integer valueOf = Integer.valueOf(i2);
            if (dq3.w()) {
                num = Integer.valueOf(dq3.x());
            }
            ta4.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", q, valueOf, String.valueOf(num));
            return false;
        }
        byte[] h2 = dq3.h();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", dq3.w() ? Integer.valueOf(dq3.x()) : null);
        contentValues.put("event_name", dq3.y());
        contentValues.put("session_scoped", dq3.F() ? Boolean.valueOf(dq3.G()) : null);
        contentValues.put("data", h2);
        try {
            if (s().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            g().f.b("Failed to insert event filter (got -1). appId", ra4.q(str));
            return true;
        } catch (SQLiteException e2) {
            g().f.c("Error storing event filter. appId", ra4.q(str), e2);
            return false;
        }
    }

    public final boolean O(String str, int i2, gq3 gq3) {
        k();
        b();
        gj1.j(str);
        Objects.requireNonNull(gq3, "null reference");
        Integer num = null;
        if (TextUtils.isEmpty(gq3.w())) {
            ta4 ta4 = g().i;
            Object q = ra4.q(str);
            Integer valueOf = Integer.valueOf(i2);
            if (gq3.u()) {
                num = Integer.valueOf(gq3.v());
            }
            ta4.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", q, valueOf, String.valueOf(num));
            return false;
        }
        byte[] h2 = gq3.h();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", gq3.u() ? Integer.valueOf(gq3.v()) : null);
        contentValues.put("property_name", gq3.w());
        contentValues.put("session_scoped", gq3.A() ? Boolean.valueOf(gq3.B()) : null);
        contentValues.put("data", h2);
        try {
            if (s().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            g().f.b("Failed to insert property filter (got -1). appId", ra4.q(str));
            return false;
        } catch (SQLiteException e2) {
            g().f.c("Error storing property filter. appId", ra4.q(str), e2);
            return false;
        }
    }

    public final boolean P(String str, Long l2, long j2, uq3 uq3) {
        b();
        k();
        Objects.requireNonNull(uq3, "null reference");
        gj1.j(str);
        Objects.requireNonNull(l2, "null reference");
        byte[] h2 = uq3.h();
        g().n.c("Saving complex main event, appId, data size", d().t(str), Integer.valueOf(h2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", h2);
        try {
            if (s().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            g().f.b("Failed to insert complex main event (got -1). appId", ra4.q(str));
            return false;
        } catch (SQLiteException e2) {
            g().f.c("Error storing complex main event. appId", ra4.q(str), e2);
            return false;
        }
    }

    public final boolean Q() {
        return this.f3331a.f3627a.getDatabasePath("google_app_measurement.db").exists();
    }

    public final long R(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = s().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            g().f.c("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.bb4 S(java.lang.String r36) {
        /*
        // Method dump skipped, instructions count: 679
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.S(java.lang.String):bb4");
    }

    public final List<zzz> T(String str, String str2, String str3) {
        gj1.j(str);
        b();
        k();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return E(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final void U(String str, String str2) {
        gj1.j(str);
        gj1.j(str2);
        b();
        k();
        try {
            s().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            g().f.d("Error deleting user property. appId", ra4.q(str), d().x(str2), e2);
        }
    }

    public final boolean V(String str, List<Integer> list) {
        gj1.j(str);
        k();
        b();
        SQLiteDatabase s = s();
        try {
            long R = R("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min((int) com.google.firebase.perf.util.Constants.MAX_URL_LENGTH, this.f3331a.g.o(str, q64.F)));
            if (R <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            String y = hj1.y(hj1.g0(join, 2), "(", join, ")");
            return s.delete("audience_filter_values", hj1.y(hj1.g0(y, 140), "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", y, " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            g().f.c("Database error querying filters. appId", ra4.q(str), e2);
            return false;
        }
    }

    public final long W(String str) {
        gj1.j(str);
        b();
        k();
        try {
            return (long) s().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, this.f3331a.g.o(str, q64.p))))});
        } catch (SQLiteException e2) {
            g().f.c("Error deleting over the limit events. appId", ra4.q(str), e2);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.vg4 X(java.lang.String r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.X(java.lang.String, java.lang.String):vg4");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzz Y(java.lang.String r30, java.lang.String r31) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.Y(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzz");
    }

    public final int Z(String str, String str2) {
        gj1.j(str);
        gj1.j(str2);
        b();
        k();
        try {
            return s().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            g().f.d("Error deleting conditional property", ra4.q(str), d().x(str2), e2);
            return 0;
        }
    }

    public final void a0() {
        k();
        s().beginTransaction();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<defpackage.dq3>> b0(java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.b0(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<defpackage.gq3>> c0(java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.c0(java.lang.String, java.lang.String):java.util.Map");
    }

    public final void d0() {
        k();
        s().endTransaction();
    }

    public final long e0(String str) {
        gj1.j(str);
        return v("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final long f0(String str, String str2) {
        Throwable th;
        SQLiteException e2;
        long v;
        gj1.j(str);
        gj1.j(str2);
        b();
        k();
        SQLiteDatabase s = s();
        s.beginTransaction();
        long j2 = 0;
        try {
            StringBuilder sb = new StringBuilder(str2.length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                v = v(sb.toString(), new String[]{str}, -1);
                if (v == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (s.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        g().f.c("Failed to insert column (got -1). appId", ra4.q(str), str2);
                        s.endTransaction();
                        return -1;
                    }
                    v = 0;
                }
            } catch (SQLiteException e3) {
                e2 = e3;
                try {
                    g().f.d("Error inserting column. appId", ra4.q(str), str2, e2);
                    s.endTransaction();
                    return j2;
                } catch (Throwable th2) {
                    th = th2;
                    s.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + v));
                if (((long) s.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    g().f.c("Failed to update column (got 0). appId", ra4.q(str), str2);
                    s.endTransaction();
                    return -1;
                }
                s.setTransactionSuccessful();
                s.endTransaction();
                return v;
            } catch (SQLiteException e4) {
                e2 = e4;
                j2 = v;
                g().f.d("Error inserting column. appId", ra4.q(str), str2, e2);
                s.endTransaction();
                return j2;
            }
        } catch (SQLiteException e5) {
            e2 = e5;
            g().f.d("Error inserting column. appId", ra4.q(str), str2, e2);
            s.endTransaction();
            return j2;
        } catch (Throwable th3) {
            th = th3;
            s.endTransaction();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle g0(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.g0(java.lang.String):android.os.Bundle");
    }

    public final void h0() {
        b();
        k();
        if (Q()) {
            long a2 = i().h.a();
            Objects.requireNonNull((db2) this.f3331a.n);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(elapsedRealtime - a2) > q64.y.a(null).longValue()) {
                i().h.b(elapsedRealtime);
                b();
                k();
                if (Q()) {
                    SQLiteDatabase s = s();
                    Objects.requireNonNull((db2) this.f3331a.n);
                    int delete = s.delete(Constants.QUEUE, "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(d64.A())});
                    if (delete > 0) {
                        g().n.b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    public final long i0() {
        Cursor cursor = null;
        try {
            cursor = s().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return -1;
            }
            long j2 = cursor.getLong(0);
            cursor.close();
            return j2;
        } catch (SQLiteException e2) {
            g().f.b("Error querying raw events", e2);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // defpackage.jg4
    public final boolean n() {
        return false;
    }

    public final void q() {
        k();
        s().setTransactionSuccessful();
    }

    public final SQLiteDatabase s() {
        b();
        try {
            return this.d.getWritableDatabase();
        } catch (SQLiteException e2) {
            g().i.b("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String t() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.s()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0025, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0027
        L_0x0020:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0039
        L_0x0025:
            r2 = move-exception
            r0 = r1
        L_0x0027:
            ra4 r3 = r6.g()     // Catch:{ all -> 0x0038 }
            ta4 r3 = r3.f     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0037
            r0.close()
        L_0x0037:
            return r1
        L_0x0038:
            r1 = move-exception
        L_0x0039:
            if (r0 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.t():java.lang.String");
    }

    public final long u(yq3 yq3) throws IOException {
        b();
        k();
        gj1.j(yq3.F1());
        byte[] h2 = yq3.h();
        long s = j().s(h2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", yq3.F1());
        contentValues.put("metadata_fingerprint", Long.valueOf(s));
        contentValues.put("metadata", h2);
        try {
            s().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return s;
        } catch (SQLiteException e2) {
            g().f.c("Error storing raw event metadata. appId", ra4.q(yq3.F1()), e2);
            throw e2;
        }
    }

    public final long v(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = s().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j3 = rawQuery.getLong(0);
                rawQuery.close();
                return j3;
            }
            rawQuery.close();
            return j2;
        } catch (SQLiteException e2) {
            g().f.c("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final g64 w(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        gj1.j(str);
        b();
        k();
        String[] strArr = {str};
        g64 g64 = new g64();
        Cursor cursor = null;
        try {
            SQLiteDatabase s = s();
            Cursor query = s.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!query.moveToFirst()) {
                g().i.b("Not updating daily counts, app is not known. appId", ra4.q(str));
                query.close();
                return g64;
            }
            if (query.getLong(0) == j2) {
                g64.b = query.getLong(1);
                g64.f1220a = query.getLong(2);
                g64.c = query.getLong(3);
                g64.d = query.getLong(4);
                g64.e = query.getLong(5);
            }
            if (z) {
                g64.b += j3;
            }
            if (z2) {
                g64.f1220a += j3;
            }
            if (z3) {
                g64.c += j3;
            }
            if (z4) {
                g64.d += j3;
            }
            if (z5) {
                g64.e += j3;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j2));
            contentValues.put("daily_public_events_count", Long.valueOf(g64.f1220a));
            contentValues.put("daily_events_count", Long.valueOf(g64.b));
            contentValues.put("daily_conversions_count", Long.valueOf(g64.c));
            contentValues.put("daily_error_events_count", Long.valueOf(g64.d));
            contentValues.put("daily_realtime_events_count", Long.valueOf(g64.e));
            s.update("apps", contentValues, "app_id=?", strArr);
            query.close();
            return g64;
        } catch (SQLiteException e2) {
            g().f.c("Error updating daily counts. appId", ra4.q(str), e2);
            if (0 != 0) {
                cursor.close();
            }
            return g64;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final g64 x(long j2, String str, boolean z, boolean z2) {
        return w(j2, str, 1, false, false, z, false, z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.m64 y(java.lang.String r26, java.lang.String r27) {
        /*
        // Method dump skipped, instructions count: 331
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h64.y(java.lang.String, java.lang.String):m64");
    }

    public final Object z(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            g().f.a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i2));
            }
            if (type == 3) {
                return cursor.getString(i2);
            }
            if (type != 4) {
                g().f.b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            g().f.a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }
}
