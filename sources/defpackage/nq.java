package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: nq  reason: default package */
/* compiled from: WorkDatabaseMigrations */
public class nq {

    /* renamed from: a  reason: collision with root package name */
    public static fm f2592a = new a(1, 2);
    public static fm b = new b(3, 4);
    public static fm c = new c(4, 5);
    public static fm d = new d(6, 7);
    public static fm e = new e(7, 8);
    public static fm f = new f(8, 9);

    /* renamed from: nq$a */
    /* compiled from: WorkDatabaseMigrations */
    public class a extends fm {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )", "INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo", "DROP TABLE IF EXISTS alarmInfo", "INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    /* renamed from: nq$b */
    /* compiled from: WorkDatabaseMigrations */
    public class b extends fm {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                omVar.y("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    /* renamed from: nq$c */
    /* compiled from: WorkDatabaseMigrations */
    public class c extends fm {
        public c(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            omVar.y("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    /* renamed from: nq$d */
    /* compiled from: WorkDatabaseMigrations */
    public class d extends fm {
        public d(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    /* renamed from: nq$e */
    /* compiled from: WorkDatabaseMigrations */
    public class e extends fm {
        public e(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    /* renamed from: nq$f */
    /* compiled from: WorkDatabaseMigrations */
    public class f extends fm {
        public f(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* renamed from: nq$g */
    /* compiled from: WorkDatabaseMigrations */
    public static class g extends fm {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2593a;

        public g(Context context, int i, int i2) {
            super(i, i2);
            this.f2593a = context;
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            if (this.endVersion >= 10) {
                omVar.e0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f2593a.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    /* renamed from: nq$h */
    /* compiled from: WorkDatabaseMigrations */
    public static class h extends fm {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2594a;

        public h(Context context) {
            super(9, 10);
            this.f2594a = context;
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            SharedPreferences sharedPreferences = this.f2594a.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j = 0;
                long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j = 1;
                }
                omVar.beginTransaction();
                try {
                    omVar.e0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                    omVar.e0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                    sharedPreferences.edit().clear().apply();
                    omVar.setTransactionSuccessful();
                } finally {
                    omVar.endTransaction();
                }
            }
            SharedPreferences sharedPreferences2 = this.f2594a.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int i = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int i2 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                omVar.beginTransaction();
                try {
                    omVar.e0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                    omVar.e0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                    sharedPreferences2.edit().clear().apply();
                    omVar.setTransactionSuccessful();
                } finally {
                    omVar.endTransaction();
                }
            }
        }
    }
}
