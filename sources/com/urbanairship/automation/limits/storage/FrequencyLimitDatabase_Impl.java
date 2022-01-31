package com.urbanairship.automation.limits.storage;

import android.content.Context;
import defpackage.jm;
import defpackage.pm;
import defpackage.wl;
import defpackage.xl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class FrequencyLimitDatabase_Impl extends FrequencyLimitDatabase {

    /* renamed from: a  reason: collision with root package name */
    public volatile lo5 f725a;

    public class a extends xl.a {
        public a(int i) {
            super(i);
        }

        @Override // defpackage.xl.a
        public void createAllTables(om omVar) {
            hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `constraints` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `constraintId` TEXT, `count` INTEGER NOT NULL, `range` INTEGER NOT NULL)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_constraints_constraintId` ON `constraints` (`constraintId`)", "CREATE TABLE IF NOT EXISTS `occurrences` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `parentConstraintId` TEXT, `timeStamp` INTEGER NOT NULL, FOREIGN KEY(`parentConstraintId`) REFERENCES `constraints`(`constraintId`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE INDEX IF NOT EXISTS `index_occurrences_parentConstraintId` ON `occurrences` (`parentConstraintId`)");
            omVar.y("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            omVar.y("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '35dc8997e1e42159a519f7f02410cda8')");
        }

        @Override // defpackage.xl.a
        public void dropAllTables(om omVar) {
            omVar.y("DROP TABLE IF EXISTS `constraints`");
            omVar.y("DROP TABLE IF EXISTS `occurrences`");
            List<wl.b> list = FrequencyLimitDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    FrequencyLimitDatabase_Impl.this.mCallbacks.get(i).onDestructiveMigration(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onCreate(om omVar) {
            List<wl.b> list = FrequencyLimitDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    FrequencyLimitDatabase_Impl.this.mCallbacks.get(i).onCreate(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onOpen(om omVar) {
            FrequencyLimitDatabase_Impl.this.mDatabase = omVar;
            omVar.y("PRAGMA foreign_keys = ON");
            FrequencyLimitDatabase_Impl.this.internalInitInvalidationTracker(omVar);
            List<wl.b> list = FrequencyLimitDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    FrequencyLimitDatabase_Impl.this.mCallbacks.get(i).onOpen(omVar);
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
            HashMap hashMap = new HashMap(4);
            hashMap.put("id", new jm.a("id", "INTEGER", true, 1, null, 1));
            hashMap.put("constraintId", new jm.a("constraintId", "TEXT", false, 0, null, 1));
            hashMap.put("count", new jm.a("count", "INTEGER", true, 0, null, 1));
            HashSet o0 = hj1.o0(hashMap, "range", new jm.a("range", "INTEGER", true, 0, null, 1), 0);
            HashSet hashSet = new HashSet(1);
            hashSet.add(new jm.d("index_constraints_constraintId", true, Arrays.asList("constraintId")));
            jm jmVar = new jm("constraints", hashMap, o0, hashSet);
            jm a2 = jm.a(omVar, "constraints");
            if (!jmVar.equals(a2)) {
                return new xl.b(false, hj1.P("constraints(com.urbanairship.automation.limits.storage.ConstraintEntity).\n Expected:\n", jmVar, "\n Found:\n", a2));
            }
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("id", new jm.a("id", "INTEGER", true, 1, null, 1));
            hashMap2.put("parentConstraintId", new jm.a("parentConstraintId", "TEXT", false, 0, null, 1));
            HashSet o02 = hj1.o0(hashMap2, "timeStamp", new jm.a("timeStamp", "INTEGER", true, 0, null, 1), 1);
            o02.add(new jm.b("constraints", "CASCADE", "NO ACTION", Arrays.asList("parentConstraintId"), Arrays.asList("constraintId")));
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new jm.d("index_occurrences_parentConstraintId", false, Arrays.asList("parentConstraintId")));
            jm jmVar2 = new jm("occurrences", hashMap2, o02, hashSet2);
            jm a3 = jm.a(omVar, "occurrences");
            if (!jmVar2.equals(a3)) {
                return new xl.b(false, hj1.P("occurrences(com.urbanairship.automation.limits.storage.OccurrenceEntity).\n Expected:\n", jmVar2, "\n Found:\n", a3));
            }
            return new xl.b(true, null);
        }
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDatabase
    public lo5 a() {
        lo5 lo5;
        if (this.f725a != null) {
            return this.f725a;
        }
        synchronized (this) {
            if (this.f725a == null) {
                this.f725a = new mo5(this);
            }
            lo5 = this.f725a;
        }
        return lo5;
    }

    @Override // defpackage.wl
    public void clearAllTables() {
        super.assertNotMainThread();
        om l0 = super.getOpenHelper().l0();
        if (1 == 0) {
            try {
                l0.y("PRAGMA foreign_keys = FALSE");
            } catch (Throwable th) {
                super.endTransaction();
                if (1 == 0) {
                    l0.y("PRAGMA foreign_keys = TRUE");
                }
                l0.n0("PRAGMA wal_checkpoint(FULL)").close();
                if (!l0.J0()) {
                    l0.y("VACUUM");
                }
                throw th;
            }
        }
        super.beginTransaction();
        if (1 != 0) {
            l0.y("PRAGMA defer_foreign_keys = TRUE");
        }
        l0.y("DELETE FROM `constraints`");
        l0.y("DELETE FROM `occurrences`");
        super.setTransactionSuccessful();
        super.endTransaction();
        if (1 == 0) {
            l0.y("PRAGMA foreign_keys = TRUE");
        }
        l0.n0("PRAGMA wal_checkpoint(FULL)").close();
        if (!l0.J0()) {
            l0.y("VACUUM");
        }
    }

    @Override // defpackage.wl
    public ul createInvalidationTracker() {
        return new ul(this, new HashMap(0), new HashMap(0), "constraints", "occurrences");
    }

    @Override // defpackage.wl
    public pm createOpenHelper(nl nlVar) {
        xl xlVar = new xl(nlVar, new a(1), "35dc8997e1e42159a519f7f02410cda8", "400933b7a06a2d0cdaabbefb93b3eecc");
        Context context = nlVar.b;
        String str = nlVar.c;
        if (context != null) {
            return nlVar.f2572a.a(new pm.b(context, str, xlVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }
}
