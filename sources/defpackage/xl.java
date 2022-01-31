package defpackage;

import android.database.Cursor;
import defpackage.pm;

/* renamed from: xl  reason: default package */
/* compiled from: RoomOpenHelper */
public class xl extends pm.a {
    public nl b;
    public final a c;
    public final String d;
    public final String e;

    /* renamed from: xl$a */
    /* compiled from: RoomOpenHelper */
    public static abstract class a {
        public final int version;

        public a(int i) {
            this.version = i;
        }

        public abstract void createAllTables(om omVar);

        public abstract void dropAllTables(om omVar);

        public abstract void onCreate(om omVar);

        public abstract void onOpen(om omVar);

        public abstract void onPostMigrate(om omVar);

        public abstract void onPreMigrate(om omVar);

        public abstract b onValidateSchema(om omVar);

        @Deprecated
        public void validateMigration(om omVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* renamed from: xl$b */
    /* compiled from: RoomOpenHelper */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f3939a;
        public final String b;

        public b(boolean z, String str) {
            this.f3939a = z;
            this.b = str;
        }
    }

    public xl(nl nlVar, a aVar, String str, String str2) {
        super(aVar.version);
        this.b = nlVar;
        this.c = aVar;
        this.d = str;
        this.e = str2;
    }

    @Override // defpackage.pm.a
    public void b(om omVar) {
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.pm.a
    public void c(om omVar) {
        Cursor D0 = ((tm) omVar).D0(new nm("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"));
        try {
            boolean z = false;
            if (D0.moveToFirst() && D0.getInt(0) == 0) {
                z = true;
            }
            D0.close();
            this.c.createAllTables(omVar);
            if (!z) {
                b onValidateSchema = this.c.onValidateSchema(omVar);
                if (!onValidateSchema.f3939a) {
                    StringBuilder i0 = hj1.i0("Pre-packaged database has an invalid schema: ");
                    i0.append(onValidateSchema.b);
                    throw new IllegalStateException(i0.toString());
                }
            }
            g(omVar);
            this.c.onCreate(omVar);
        } catch (Throwable th) {
            D0.close();
            throw th;
        }
    }

    @Override // defpackage.pm.a
    public void d(om omVar, int i, int i2) {
        f(omVar, i, i2);
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.pm.a
    public void e(om omVar) {
        Cursor D0 = ((tm) omVar).D0(new nm("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"));
        try {
            boolean z = D0.moveToFirst() && D0.getInt(0) != 0;
            D0.close();
            if (z) {
                Cursor D02 = ((tm) omVar).D0(new nm("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                try {
                    String string = D02.moveToFirst() ? D02.getString(0) : null;
                    D02.close();
                    if (!this.d.equals(string) && !this.e.equals(string)) {
                        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                    }
                } catch (Throwable th) {
                    D02.close();
                    throw th;
                }
            } else {
                b onValidateSchema = this.c.onValidateSchema(omVar);
                if (onValidateSchema.f3939a) {
                    this.c.onPostMigrate(omVar);
                    g(omVar);
                } else {
                    StringBuilder i0 = hj1.i0("Pre-packaged database has an invalid schema: ");
                    i0.append(onValidateSchema.b);
                    throw new IllegalStateException(i0.toString());
                }
            }
            this.c.onOpen(omVar);
            this.b = null;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // defpackage.pm.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(defpackage.om r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xl.f(om, int, int):void");
    }

    public final void g(om omVar) {
        omVar.y("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        String str = this.d;
        omVar.y("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')");
    }
}
