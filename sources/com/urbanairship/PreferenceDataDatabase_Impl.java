package com.urbanairship;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.jm;
import defpackage.pm;
import defpackage.wl;
import defpackage.xl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class PreferenceDataDatabase_Impl extends PreferenceDataDatabase {
    public static final /* synthetic */ int c = 0;
    public volatile fk5 b;

    public class a extends xl.a {
        public a(int i) {
            super(i);
        }

        @Override // defpackage.xl.a
        public void createAllTables(om omVar) {
            omVar.y("CREATE TABLE IF NOT EXISTS `preferences` (`_id` TEXT NOT NULL, `value` TEXT, PRIMARY KEY(`_id`))");
            omVar.y("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            omVar.y("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1146f4c5ff2c986072906aee3af2535f')");
        }

        @Override // defpackage.xl.a
        public void dropAllTables(om omVar) {
            omVar.y("DROP TABLE IF EXISTS `preferences`");
            PreferenceDataDatabase_Impl preferenceDataDatabase_Impl = PreferenceDataDatabase_Impl.this;
            int i = PreferenceDataDatabase_Impl.c;
            List<wl.b> list = preferenceDataDatabase_Impl.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PreferenceDataDatabase_Impl.this.mCallbacks.get(i2).onDestructiveMigration(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onCreate(om omVar) {
            PreferenceDataDatabase_Impl preferenceDataDatabase_Impl = PreferenceDataDatabase_Impl.this;
            int i = PreferenceDataDatabase_Impl.c;
            List<wl.b> list = preferenceDataDatabase_Impl.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PreferenceDataDatabase_Impl.this.mCallbacks.get(i2).onCreate(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onOpen(om omVar) {
            PreferenceDataDatabase_Impl preferenceDataDatabase_Impl = PreferenceDataDatabase_Impl.this;
            int i = PreferenceDataDatabase_Impl.c;
            preferenceDataDatabase_Impl.mDatabase = omVar;
            PreferenceDataDatabase_Impl.this.internalInitInvalidationTracker(omVar);
            List<wl.b> list = PreferenceDataDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PreferenceDataDatabase_Impl.this.mCallbacks.get(i2).onOpen(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onPostMigrate(om omVar) {
        }

        @Override // defpackage.xl.a
        public void onPreMigrate(om omVar) {
            hm.a(omVar);
        }

        @Override // defpackage.xl.a
        public xl.b onValidateSchema(om omVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("_id", new jm.a("_id", "TEXT", true, 1, null, 1));
            jm jmVar = new jm(AnalyticsConstants.PREFERENCES, hashMap, hj1.o0(hashMap, FirebaseAnalytics.Param.VALUE, new jm.a(FirebaseAnalytics.Param.VALUE, "TEXT", false, 0, null, 1), 0), new HashSet(0));
            jm a2 = jm.a(omVar, AnalyticsConstants.PREFERENCES);
            if (!jmVar.equals(a2)) {
                return new xl.b(false, hj1.P("preferences(com.urbanairship.PreferenceData).\n Expected:\n", jmVar, "\n Found:\n", a2));
            }
            return new xl.b(true, null);
        }
    }

    @Override // com.urbanairship.PreferenceDataDatabase
    public fk5 a() {
        fk5 fk5;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new gk5(this);
            }
            fk5 = this.b;
        }
        return fk5;
    }

    @Override // defpackage.wl
    public void clearAllTables() {
        super.assertNotMainThread();
        om l0 = super.getOpenHelper().l0();
        try {
            super.beginTransaction();
            l0.y("DELETE FROM `preferences`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            l0.n0("PRAGMA wal_checkpoint(FULL)").close();
            if (!l0.J0()) {
                l0.y("VACUUM");
            }
        }
    }

    @Override // defpackage.wl
    public ul createInvalidationTracker() {
        return new ul(this, new HashMap(0), new HashMap(0), AnalyticsConstants.PREFERENCES);
    }

    @Override // defpackage.wl
    public pm createOpenHelper(nl nlVar) {
        xl xlVar = new xl(nlVar, new a(2), "1146f4c5ff2c986072906aee3af2535f", "4bfc112e4986489ec8dd7db647ee82f8");
        Context context = nlVar.b;
        String str = nlVar.c;
        if (context != null) {
            return nlVar.f2572a.a(new pm.b(context, str, xlVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }
}
