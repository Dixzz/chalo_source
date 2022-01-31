package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: to5  reason: default package */
/* compiled from: LegacyDataManager */
public class to5 extends ky5 {
    public to5(Context context, String str, String str2) {
        super(context, str, str2, 6);
    }

    @Override // defpackage.ky5
    @TargetApi(16)
    public void g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // defpackage.ky5
    public void h(SQLiteDatabase sQLiteDatabase) {
        yj5.a("Creating automation database", new Object[0]);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS action_schedules (s_row_id INTEGER PRIMARY KEY AUTOINCREMENT,s_id TEXT UNIQUE,s_metadata TEXT,s_data TEXT,s_start INTEGER,s_end INTEGER,s_edit_grace_period INTEGER,s_execution_state_change_date INTEGER,s_count INTEGER,s_limit INTEGER,s_priority INTEGER,s_group TEXT,s_execution_state INTEGER,s_pending_execution_date DOUBLE,d_app_state INTEGER,d_region_id TEXT,d_screen TEXT,d_seconds DOUBLE,s_interval INTEGER,s_trigger_context TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS triggers (t_row_id INTEGER PRIMARY KEY AUTOINCREMENT,t_type INTEGER,t_cancellation INTEGER,t_s_id TEXT,t_predicate TEXT,t_progress DOUBLE,t_goal DOUBLE,FOREIGN KEY(t_s_id) REFERENCES action_schedules(s_id) ON DELETE CASCADE);");
        yj5.a("Automation database created", new Object[0]);
    }

    @Override // defpackage.ky5
    public void i(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        yj5.a("Dropping automation database. Downgrading from version %s to %s", Integer.valueOf(i), Integer.valueOf(i2));
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS triggers");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS action_schedules");
        h(sQLiteDatabase);
    }

    @Override // defpackage.ky5
    public void j(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        if (i == 1) {
            sQLiteDatabase.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase.execSQL("ALTER TABLE action_schedules RENAME TO " + "temp_schedule_entry_table" + ";");
            sQLiteDatabase.execSQL("ALTER TABLE triggers RENAME TO " + "temp_triggers_entry_table" + ";");
            StringBuilder sb = new StringBuilder();
            str4 = "ALTER TABLE triggers RENAME TO ";
            hj1.V0(sb, "CREATE TABLE action_schedules (s_row_id INTEGER PRIMARY KEY AUTOINCREMENT,s_id TEXT UNIQUE,", "s_actions", " TEXT,", "s_start");
            hj1.V0(sb, " INTEGER,", "s_end", " INTEGER,", "s_count");
            hj1.V0(sb, " INTEGER,", "s_limit", " INTEGER,", "s_group");
            str3 = "s_group";
            str6 = "s_limit";
            hj1.V0(sb, " TEXT,", "s_is_pending_execution", " INTEGER,", "s_pending_execution_date");
            str5 = "s_pending_execution_date";
            str2 = "s_is_pending_execution";
            str8 = "s_count";
            str9 = "d_app_state";
            hj1.V0(sb, " DOUBLE,", str9, " INTEGER,", "d_region_id");
            hj1.V0(sb, " TEXT,", "d_screen", " TEXT,", "d_seconds");
            sb.append(" DOUBLE);");
            sQLiteDatabase.execSQL(sb.toString());
            sQLiteDatabase.execSQL("CREATE TABLE triggers(t_row_id INTEGER PRIMARY KEY AUTOINCREMENT,t_type INTEGER,t_cancellation INTEGER,t_s_id TEXT,t_predicate TEXT,t_progress DOUBLE,t_goal DOUBLE,FOREIGN KEY(t_s_id) REFERENCES action_schedules(s_id) ON DELETE CASCADE);");
            sQLiteDatabase.execSQL("INSERT INTO action_schedules(s_row_id, s_id, s_actions, s_start, s_end, s_count, s_limit, s_priority, s_group, s_is_pending_execution, s_pending_execution_date, d_app_state, d_region_id, d_screen, d_seconds) SELECT _id, s_id, s_actions, s_start, s_end, s_count, s_limit, s_group, 0, 0.0, 1, NULL, NULL, 0 FROM temp_schedule_entry_table;");
            StringBuilder sb2 = new StringBuilder();
            str7 = "d_region_id";
            str10 = ", ";
            hj1.V0(sb2, "INSERT INTO triggers(t_row_id, t_type, t_cancellation, t_s_id, t_predicate, t_progress, t_goal) SELECT ", "_id", str10, "t_type");
            str11 = ", 0, ";
            hj1.V0(sb2, str11, "t_s_id", str10, "t_predicate");
            hj1.V0(sb2, str10, "t_progress", str10, "t_goal");
            str13 = " FROM ";
            sb2.append(str13);
            sb2.append("temp_triggers_entry_table");
            sb2.append(";");
            sQLiteDatabase.execSQL(sb2.toString());
            str14 = "DROP TABLE temp_schedule_entry_table;";
            sQLiteDatabase.execSQL(str14);
            str12 = "DROP TABLE temp_triggers_entry_table;";
            sQLiteDatabase.execSQL(str12);
            sQLiteDatabase.execSQL("COMMIT;");
        } else if (i == 2) {
            str12 = "DROP TABLE temp_triggers_entry_table;";
            str4 = "ALTER TABLE triggers RENAME TO ";
            str3 = "s_group";
            str14 = "DROP TABLE temp_schedule_entry_table;";
            str13 = " FROM ";
            str11 = ", 0, ";
            str2 = "s_is_pending_execution";
            str5 = "s_pending_execution_date";
            str6 = "s_limit";
            str10 = ", ";
            str8 = "s_count";
            str9 = "d_app_state";
            str7 = "d_region_id";
        } else if (i == 3) {
            str = "BEGIN TRANSACTION;";
            sQLiteDatabase.execSQL(str);
            sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_execution_state_change_date INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_edit_grace_period INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_interval INTEGER;");
            sQLiteDatabase.execSQL("COMMIT;");
            sQLiteDatabase.execSQL(str);
            sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_metadata TEXT;");
            sQLiteDatabase.execSQL("COMMIT;");
        } else if (i == 4) {
            str = "BEGIN TRANSACTION;";
            sQLiteDatabase.execSQL(str);
            sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_metadata TEXT;");
            sQLiteDatabase.execSQL("COMMIT;");
        } else if (i != 5) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS action_schedules");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS triggers");
            h(sQLiteDatabase);
            return;
        } else {
            sQLiteDatabase.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_trigger_context TEXT;");
            sQLiteDatabase.execSQL("COMMIT;");
            return;
        }
        sQLiteDatabase.execSQL("BEGIN TRANSACTION;");
        sQLiteDatabase.execSQL("ALTER TABLE action_schedules RENAME TO " + "temp_schedule_entry_table" + ";");
        sQLiteDatabase.execSQL(str4 + "temp_triggers_entry_table" + ";");
        sQLiteDatabase.execSQL("CREATE TABLE action_schedules (s_row_id INTEGER PRIMARY KEY AUTOINCREMENT,s_id TEXT UNIQUE,s_data TEXT,s_start INTEGER,s_end INTEGER,s_count INTEGER,s_limit INTEGER,s_priority INTEGER,s_group TEXT,s_execution_state INTEGER,s_pending_execution_date DOUBLE,d_app_state INTEGER,d_region_id TEXT,d_screen TEXT,d_seconds DOUBLE);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS triggers (t_row_id INTEGER PRIMARY KEY AUTOINCREMENT,t_type INTEGER,t_cancellation INTEGER,t_s_id TEXT,t_predicate TEXT,t_progress DOUBLE,t_goal DOUBLE,FOREIGN KEY(t_s_id) REFERENCES action_schedules(s_id) ON DELETE CASCADE);");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("INSERT INTO action_schedules(s_row_id, s_id, s_data, s_start, s_end, s_count, s_limit, s_priority, s_group, s_execution_state, s_pending_execution_date, d_app_state, d_region_id, d_screen, d_seconds) SELECT s_row_id, s_id, ");
        sb3.append("s_actions");
        hj1.V0(sb3, str10, "s_start", str10, "s_end");
        hj1.V0(sb3, str10, str8, str10, str6);
        hj1.V0(sb3, str11, str3, str10, str2);
        hj1.V0(sb3, str10, str5, str10, str9);
        hj1.V0(sb3, str10, str7, str10, "d_screen");
        hj1.V0(sb3, str10, "d_seconds", str13, "temp_schedule_entry_table");
        sb3.append(";");
        sQLiteDatabase.execSQL(sb3.toString());
        sQLiteDatabase.execSQL("INSERT INTO triggers(t_row_id, t_type, t_cancellation, t_s_id, t_predicate, t_progress, t_goal) SELECT t_row_id, t_type, t_cancellation, t_s_id, t_predicate, t_progress, t_goal FROM " + "temp_triggers_entry_table" + ";");
        sQLiteDatabase.execSQL(str14);
        sQLiteDatabase.execSQL(str12);
        sQLiteDatabase.execSQL("COMMIT;");
        str = "BEGIN TRANSACTION;";
        sQLiteDatabase.execSQL(str);
        sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_execution_state_change_date INTEGER;");
        sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_edit_grace_period INTEGER;");
        sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_interval INTEGER;");
        sQLiteDatabase.execSQL("COMMIT;");
        sQLiteDatabase.execSQL(str);
        sQLiteDatabase.execSQL("ALTER TABLE action_schedules ADD COLUMN s_metadata TEXT;");
        sQLiteDatabase.execSQL("COMMIT;");
    }

    public void m() {
        try {
            SQLiteDatabase f = f();
            f.execSQL("DROP TABLE IF EXISTS triggers");
            f.execSQL("DROP TABLE IF EXISTS action_schedules");
            f.close();
        } catch (Exception e) {
            yj5.e(e, "Failed to delete schedules.", new Object[0]);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x001f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor n() {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = "SELECT * FROM action_schedules a LEFT OUTER JOIN triggers b ON a.s_id=b.t_s_id"
            android.database.sqlite.SQLiteDatabase r3 = r8.e()     // Catch:{ SQLException -> 0x0020 }
            if (r3 != 0) goto L_0x000b
            goto L_0x001f
        L_0x000b:
            r4 = 0
        L_0x000c:
            r5 = 3
            if (r4 >= r5) goto L_0x001f
            android.database.Cursor r1 = r3.rawQuery(r2, r1)     // Catch:{ SQLException -> 0x0014 }
            goto L_0x001f
        L_0x0014:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r0]
            java.lang.String r7 = "Query failed"
            defpackage.yj5.e(r5, r7, r6)
            int r4 = r4 + 1
            goto L_0x000c
        L_0x001f:
            return r1
        L_0x0020:
            r2 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = "LegacyAutomationDataManager - Unable to get schedules."
            defpackage.yj5.e(r2, r3, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.to5.n():android.database.Cursor");
    }
}
