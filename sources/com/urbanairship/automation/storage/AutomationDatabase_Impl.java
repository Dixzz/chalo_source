package com.urbanairship.automation.storage;

import android.content.Context;
import defpackage.jm;
import defpackage.pm;
import defpackage.wl;
import defpackage.xl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class AutomationDatabase_Impl extends AutomationDatabase {
    public static final /* synthetic */ int d = 0;
    public volatile oo5 c;

    public class a extends xl.a {
        public a(int i) {
            super(i);
        }

        @Override // defpackage.xl.a
        public void createAllTables(om omVar) {
            hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `schedules` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `scheduleId` TEXT, `group` TEXT, `metadata` TEXT, `limit` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `scheduleStart` INTEGER NOT NULL, `scheduleEnd` INTEGER NOT NULL, `editGracePeriod` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `scheduleType` TEXT, `data` TEXT, `count` INTEGER NOT NULL, `executionState` INTEGER NOT NULL, `executionStateChangeDate` INTEGER NOT NULL, `triggerContext` TEXT, `appState` INTEGER NOT NULL, `screens` TEXT, `seconds` INTEGER NOT NULL, `regionId` TEXT, `audience` TEXT, `campaigns` TEXT, `frequencyConstraintIds` TEXT)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_schedules_scheduleId` ON `schedules` (`scheduleId`)", "CREATE TABLE IF NOT EXISTS `triggers` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `triggerType` INTEGER NOT NULL, `goal` REAL NOT NULL, `jsonPredicate` TEXT, `isCancellation` INTEGER NOT NULL, `progress` REAL NOT NULL, `parentScheduleId` TEXT, FOREIGN KEY(`parentScheduleId`) REFERENCES `schedules`(`scheduleId`) ON UPDATE NO ACTION ON DELETE CASCADE )", "CREATE INDEX IF NOT EXISTS `index_triggers_parentScheduleId` ON `triggers` (`parentScheduleId`)");
            omVar.y("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            omVar.y("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0c2558a4836b8db4f3c96547d9dab3a1')");
        }

        @Override // defpackage.xl.a
        public void dropAllTables(om omVar) {
            omVar.y("DROP TABLE IF EXISTS `schedules`");
            omVar.y("DROP TABLE IF EXISTS `triggers`");
            AutomationDatabase_Impl automationDatabase_Impl = AutomationDatabase_Impl.this;
            int i = AutomationDatabase_Impl.d;
            List<wl.b> list = automationDatabase_Impl.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AutomationDatabase_Impl.this.mCallbacks.get(i2).onDestructiveMigration(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onCreate(om omVar) {
            AutomationDatabase_Impl automationDatabase_Impl = AutomationDatabase_Impl.this;
            int i = AutomationDatabase_Impl.d;
            List<wl.b> list = automationDatabase_Impl.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AutomationDatabase_Impl.this.mCallbacks.get(i2).onCreate(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onOpen(om omVar) {
            AutomationDatabase_Impl automationDatabase_Impl = AutomationDatabase_Impl.this;
            int i = AutomationDatabase_Impl.d;
            automationDatabase_Impl.mDatabase = omVar;
            omVar.y("PRAGMA foreign_keys = ON");
            AutomationDatabase_Impl.this.internalInitInvalidationTracker(omVar);
            List<wl.b> list = AutomationDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AutomationDatabase_Impl.this.mCallbacks.get(i2).onOpen(omVar);
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
            HashMap hashMap = new HashMap(23);
            hashMap.put("id", new jm.a("id", "INTEGER", true, 1, null, 1));
            hashMap.put("scheduleId", new jm.a("scheduleId", "TEXT", false, 0, null, 1));
            hashMap.put("group", new jm.a("group", "TEXT", false, 0, null, 1));
            hashMap.put("metadata", new jm.a("metadata", "TEXT", false, 0, null, 1));
            hashMap.put("limit", new jm.a("limit", "INTEGER", true, 0, null, 1));
            hashMap.put("priority", new jm.a("priority", "INTEGER", true, 0, null, 1));
            hashMap.put("scheduleStart", new jm.a("scheduleStart", "INTEGER", true, 0, null, 1));
            hashMap.put("scheduleEnd", new jm.a("scheduleEnd", "INTEGER", true, 0, null, 1));
            hashMap.put("editGracePeriod", new jm.a("editGracePeriod", "INTEGER", true, 0, null, 1));
            hashMap.put("interval", new jm.a("interval", "INTEGER", true, 0, null, 1));
            hashMap.put("scheduleType", new jm.a("scheduleType", "TEXT", false, 0, null, 1));
            hashMap.put("data", new jm.a("data", "TEXT", false, 0, null, 1));
            hashMap.put("count", new jm.a("count", "INTEGER", true, 0, null, 1));
            hashMap.put("executionState", new jm.a("executionState", "INTEGER", true, 0, null, 1));
            hashMap.put("executionStateChangeDate", new jm.a("executionStateChangeDate", "INTEGER", true, 0, null, 1));
            hashMap.put("triggerContext", new jm.a("triggerContext", "TEXT", false, 0, null, 1));
            hashMap.put("appState", new jm.a("appState", "INTEGER", true, 0, null, 1));
            hashMap.put("screens", new jm.a("screens", "TEXT", false, 0, null, 1));
            hashMap.put("seconds", new jm.a("seconds", "INTEGER", true, 0, null, 1));
            hashMap.put("regionId", new jm.a("regionId", "TEXT", false, 0, null, 1));
            hashMap.put("audience", new jm.a("audience", "TEXT", false, 0, null, 1));
            hashMap.put("campaigns", new jm.a("campaigns", "TEXT", false, 0, null, 1));
            HashSet o0 = hj1.o0(hashMap, "frequencyConstraintIds", new jm.a("frequencyConstraintIds", "TEXT", false, 0, null, 1), 0);
            HashSet hashSet = new HashSet(1);
            hashSet.add(new jm.d("index_schedules_scheduleId", true, Arrays.asList("scheduleId")));
            jm jmVar = new jm("schedules", hashMap, o0, hashSet);
            jm a2 = jm.a(omVar, "schedules");
            if (!jmVar.equals(a2)) {
                return new xl.b(false, hj1.P("schedules(com.urbanairship.automation.storage.ScheduleEntity).\n Expected:\n", jmVar, "\n Found:\n", a2));
            }
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("id", new jm.a("id", "INTEGER", true, 1, null, 1));
            hashMap2.put("triggerType", new jm.a("triggerType", "INTEGER", true, 0, null, 1));
            hashMap2.put("goal", new jm.a("goal", "REAL", true, 0, null, 1));
            hashMap2.put("jsonPredicate", new jm.a("jsonPredicate", "TEXT", false, 0, null, 1));
            hashMap2.put("isCancellation", new jm.a("isCancellation", "INTEGER", true, 0, null, 1));
            hashMap2.put("progress", new jm.a("progress", "REAL", true, 0, null, 1));
            HashSet o02 = hj1.o0(hashMap2, "parentScheduleId", new jm.a("parentScheduleId", "TEXT", false, 0, null, 1), 1);
            o02.add(new jm.b("schedules", "CASCADE", "NO ACTION", Arrays.asList("parentScheduleId"), Arrays.asList("scheduleId")));
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new jm.d("index_triggers_parentScheduleId", false, Arrays.asList("parentScheduleId")));
            jm jmVar2 = new jm("triggers", hashMap2, o02, hashSet2);
            jm a3 = jm.a(omVar, "triggers");
            if (!jmVar2.equals(a3)) {
                return new xl.b(false, hj1.P("triggers(com.urbanairship.automation.storage.TriggerEntity).\n Expected:\n", jmVar2, "\n Found:\n", a3));
            }
            return new xl.b(true, null);
        }
    }

    @Override // com.urbanairship.automation.storage.AutomationDatabase
    public oo5 a() {
        oo5 oo5;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new qo5(this);
            }
            oo5 = this.c;
        }
        return oo5;
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
        l0.y("DELETE FROM `schedules`");
        l0.y("DELETE FROM `triggers`");
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
        return new ul(this, new HashMap(0), new HashMap(0), "schedules", "triggers");
    }

    @Override // defpackage.wl
    public pm createOpenHelper(nl nlVar) {
        xl xlVar = new xl(nlVar, new a(3), "0c2558a4836b8db4f3c96547d9dab3a1", "60a1d877c3060bbf5fd306d671d9f213");
        Context context = nlVar.b;
        String str = nlVar.c;
        if (context != null) {
            return nlVar.f2572a.a(new pm.b(context, str, xlVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }
}
