package com.urbanairship.automation.storage;

public abstract class AutomationDatabase extends wl {

    /* renamed from: a  reason: collision with root package name */
    public static final fm f727a = new a(1, 2);
    public static final fm b = new b(2, 3);

    public static class a extends fm {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("ALTER TABLE schedules  ADD COLUMN campaigns TEXT");
        }
    }

    public static class b extends fm {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("ALTER TABLE schedules  ADD COLUMN frequencyConstraintIds TEXT");
        }
    }

    public abstract oo5 a();
}
