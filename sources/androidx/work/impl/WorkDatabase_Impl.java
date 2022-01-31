package androidx.work.impl;

import android.content.Context;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.razorpay.AnalyticsConstants;
import defpackage.jm;
import defpackage.pm;
import defpackage.wl;
import defpackage.xl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class WorkDatabase_Impl extends WorkDatabase {
    public static final /* synthetic */ int j = 0;
    public volatile ss c;
    public volatile ds d;
    public volatile vs e;
    public volatile js f;
    public volatile ms g;
    public volatile ps h;
    public volatile gs i;

    public class a extends xl.a {
        public a(int i) {
            super(i);
        }

        @Override // defpackage.xl.a
        public void createAllTables(om omVar) {
            hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )", "CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)", "CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)", "CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            hj1.B0(omVar, "CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)", "CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)", "CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )", "CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )", "CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)", "CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            omVar.y("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            omVar.y("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            omVar.y("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cf029002fffdcadf079e8d0a1c9a70ac')");
        }

        @Override // defpackage.xl.a
        public void dropAllTables(om omVar) {
            hj1.B0(omVar, "DROP TABLE IF EXISTS `Dependency`", "DROP TABLE IF EXISTS `WorkSpec`", "DROP TABLE IF EXISTS `WorkTag`", "DROP TABLE IF EXISTS `SystemIdInfo`");
            omVar.y("DROP TABLE IF EXISTS `WorkName`");
            omVar.y("DROP TABLE IF EXISTS `WorkProgress`");
            omVar.y("DROP TABLE IF EXISTS `Preference`");
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            int i = WorkDatabase_Impl.j;
            List<wl.b> list = workDatabase_Impl.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    WorkDatabase_Impl.this.mCallbacks.get(i2).onDestructiveMigration(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onCreate(om omVar) {
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            int i = WorkDatabase_Impl.j;
            List<wl.b> list = workDatabase_Impl.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    WorkDatabase_Impl.this.mCallbacks.get(i2).onCreate(omVar);
                }
            }
        }

        @Override // defpackage.xl.a
        public void onOpen(om omVar) {
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            int i = WorkDatabase_Impl.j;
            workDatabase_Impl.mDatabase = omVar;
            omVar.y("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.internalInitInvalidationTracker(omVar);
            List<wl.b> list = WorkDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    WorkDatabase_Impl.this.mCallbacks.get(i2).onOpen(omVar);
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
            hashMap.put("work_spec_id", new jm.a("work_spec_id", "TEXT", true, 1, null, 1));
            HashSet o0 = hj1.o0(hashMap, "prerequisite_id", new jm.a("prerequisite_id", "TEXT", true, 2, null, 1), 2);
            o0.add(new jm.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            o0.add(new jm.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new jm.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet.add(new jm.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            jm jmVar = new jm("Dependency", hashMap, o0, hashSet);
            jm a2 = jm.a(omVar, "Dependency");
            if (!jmVar.equals(a2)) {
                return new xl.b(false, hj1.P("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n", jmVar, "\n Found:\n", a2));
            }
            HashMap hashMap2 = new HashMap(24);
            hashMap2.put("id", new jm.a("id", "TEXT", true, 1, null, 1));
            hashMap2.put(RemoteConfigConstants.ResponseFieldKey.STATE, new jm.a(RemoteConfigConstants.ResponseFieldKey.STATE, "INTEGER", true, 0, null, 1));
            hashMap2.put("worker_class_name", new jm.a("worker_class_name", "TEXT", true, 0, null, 1));
            hashMap2.put("input_merger_class_name", new jm.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            hashMap2.put("input", new jm.a("input", "BLOB", true, 0, null, 1));
            hashMap2.put("output", new jm.a("output", "BLOB", true, 0, null, 1));
            hashMap2.put("initial_delay", new jm.a("initial_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("interval_duration", new jm.a("interval_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("flex_duration", new jm.a("flex_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_attempt_count", new jm.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_policy", new jm.a("backoff_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_delay_duration", new jm.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("period_start_time", new jm.a("period_start_time", "INTEGER", true, 0, null, 1));
            hashMap2.put("minimum_retention_duration", new jm.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("schedule_requested_at", new jm.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_in_foreground", new jm.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            hashMap2.put("required_network_type", new jm.a("required_network_type", "INTEGER", false, 0, null, 1));
            hashMap2.put("requires_charging", new jm.a("requires_charging", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_device_idle", new jm.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_battery_not_low", new jm.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_storage_not_low", new jm.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_content_update_delay", new jm.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_max_content_delay", new jm.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            HashSet o02 = hj1.o0(hashMap2, "content_uri_triggers", new jm.a("content_uri_triggers", "BLOB", false, 0, null, 1), 0);
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new jm.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet2.add(new jm.d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            jm jmVar2 = new jm("WorkSpec", hashMap2, o02, hashSet2);
            jm a3 = jm.a(omVar, "WorkSpec");
            if (!jmVar2.equals(a3)) {
                return new xl.b(false, hj1.P("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n", jmVar2, "\n Found:\n", a3));
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new jm.a("tag", "TEXT", true, 1, null, 1));
            HashSet o03 = hj1.o0(hashMap3, "work_spec_id", new jm.a("work_spec_id", "TEXT", true, 2, null, 1), 1);
            o03.add(new jm.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet3 = new HashSet(1);
            hashSet3.add(new jm.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            jm jmVar3 = new jm("WorkTag", hashMap3, o03, hashSet3);
            jm a4 = jm.a(omVar, "WorkTag");
            if (!jmVar3.equals(a4)) {
                return new xl.b(false, hj1.P("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n", jmVar3, "\n Found:\n", a4));
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new jm.a("work_spec_id", "TEXT", true, 1, null, 1));
            HashSet o04 = hj1.o0(hashMap4, "system_id", new jm.a("system_id", "INTEGER", true, 0, null, 1), 1);
            o04.add(new jm.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            jm jmVar4 = new jm("SystemIdInfo", hashMap4, o04, new HashSet(0));
            jm a5 = jm.a(omVar, "SystemIdInfo");
            if (!jmVar4.equals(a5)) {
                return new xl.b(false, hj1.P("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n", jmVar4, "\n Found:\n", a5));
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new jm.a("name", "TEXT", true, 1, null, 1));
            HashSet o05 = hj1.o0(hashMap5, "work_spec_id", new jm.a("work_spec_id", "TEXT", true, 2, null, 1), 1);
            o05.add(new jm.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new jm.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            jm jmVar5 = new jm("WorkName", hashMap5, o05, hashSet4);
            jm a6 = jm.a(omVar, "WorkName");
            if (!jmVar5.equals(a6)) {
                return new xl.b(false, hj1.P("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n", jmVar5, "\n Found:\n", a6));
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new jm.a("work_spec_id", "TEXT", true, 1, null, 1));
            HashSet o06 = hj1.o0(hashMap6, "progress", new jm.a("progress", "BLOB", true, 0, null, 1), 1);
            o06.add(new jm.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            jm jmVar6 = new jm("WorkProgress", hashMap6, o06, new HashSet(0));
            jm a7 = jm.a(omVar, "WorkProgress");
            if (!jmVar6.equals(a7)) {
                return new xl.b(false, hj1.P("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n", jmVar6, "\n Found:\n", a7));
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put(AnalyticsConstants.KEY, new jm.a(AnalyticsConstants.KEY, "TEXT", true, 1, null, 1));
            jm jmVar7 = new jm("Preference", hashMap7, hj1.o0(hashMap7, "long_value", new jm.a("long_value", "INTEGER", false, 0, null, 1), 0), new HashSet(0));
            jm a8 = jm.a(omVar, "Preference");
            if (!jmVar7.equals(a8)) {
                return new xl.b(false, hj1.P("Preference(androidx.work.impl.model.Preference).\n Expected:\n", jmVar7, "\n Found:\n", a8));
            }
            return new xl.b(true, null);
        }
    }

    @Override // androidx.work.impl.WorkDatabase
    public ds a() {
        ds dsVar;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new es(this);
            }
            dsVar = this.d;
        }
        return dsVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public gs b() {
        gs gsVar;
        if (this.i != null) {
            return this.i;
        }
        synchronized (this) {
            if (this.i == null) {
                this.i = new hs(this);
            }
            gsVar = this.i;
        }
        return gsVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public js c() {
        js jsVar;
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = new ks(this);
            }
            jsVar = this.f;
        }
        return jsVar;
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
        l0.y("DELETE FROM `Dependency`");
        l0.y("DELETE FROM `WorkSpec`");
        l0.y("DELETE FROM `WorkTag`");
        l0.y("DELETE FROM `SystemIdInfo`");
        l0.y("DELETE FROM `WorkName`");
        l0.y("DELETE FROM `WorkProgress`");
        l0.y("DELETE FROM `Preference`");
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
        return new ul(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // defpackage.wl
    public pm createOpenHelper(nl nlVar) {
        xl xlVar = new xl(nlVar, new a(11), "cf029002fffdcadf079e8d0a1c9a70ac", "8aff2efc47fafe870c738f727dfcfc6e");
        Context context = nlVar.b;
        String str = nlVar.c;
        if (context != null) {
            return nlVar.f2572a.a(new pm.b(context, str, xlVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // androidx.work.impl.WorkDatabase
    public ms d() {
        ms msVar;
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = new ns(this);
            }
            msVar = this.g;
        }
        return msVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public ps e() {
        ps psVar;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new qs(this);
            }
            psVar = this.h;
        }
        return psVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public ss f() {
        ss ssVar;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new ts(this);
            }
            ssVar = this.c;
        }
        return ssVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public vs g() {
        vs vsVar;
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = new ws(this);
            }
            vsVar = this.e;
        }
        return vsVar;
    }
}
