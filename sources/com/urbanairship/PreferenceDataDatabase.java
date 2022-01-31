package com.urbanairship;

public abstract class PreferenceDataDatabase extends wl {

    /* renamed from: a  reason: collision with root package name */
    public static final fm f714a = new a(1, 2);

    public static class a extends fm {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            hj1.B0(omVar, "CREATE TABLE preferences_new (_id TEXT PRIMARY KEY NOT NULL, value TEXT);", "INSERT INTO preferences_new (_id, value) SELECT _id, value FROM preferences", "DROP TABLE preferences", "ALTER TABLE preferences_new RENAME TO preferences");
        }
    }

    public abstract fk5 a();
}
