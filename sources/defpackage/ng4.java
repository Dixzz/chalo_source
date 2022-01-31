package defpackage;

import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import server.zophop.Constants;

/* renamed from: ng4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class ng4 implements ab4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2552a;
    public final /* synthetic */ lg4 b;

    public ng4(lg4 lg4, String str) {
        this.b = lg4;
        this.f2552a = str;
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.ab4
    public final void a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        lg4 lg4 = this.b;
        lg4.U();
        lg4.P();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                lg4.r = false;
                lg4.x();
                throw th2;
            }
        }
        List<Long> list = lg4.v;
        lg4.v = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                ib4 ib4 = lg4.j.n().e;
                Objects.requireNonNull((db2) lg4.j.n);
                ib4.b(System.currentTimeMillis());
                lg4.j.n().f.b(0);
                lg4.w();
                lg4.j.g().n.c("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                lg4.K().a0();
                try {
                    for (Long l : list) {
                        try {
                            h64 K = lg4.K();
                            long longValue = l.longValue();
                            K.b();
                            K.k();
                            try {
                                if (K.s().delete(Constants.QUEUE, "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                K.g().f.b("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            List<Long> list2 = lg4.w;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    lg4.K().q();
                    lg4.K().d0();
                    lg4.w = null;
                    if (!lg4.J().t() || !lg4.v()) {
                        lg4.x = -1;
                        lg4.w();
                    } else {
                        lg4.Q();
                    }
                    lg4.m = 0;
                } catch (Throwable th3) {
                    lg4.K().d0();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                lg4.j.g().f.b("Database error while trying to delete uploaded bundles", e3);
                Objects.requireNonNull((db2) lg4.j.n);
                lg4.m = SystemClock.elapsedRealtime();
                lg4.j.g().n.b("Disable upload, time", Long.valueOf(lg4.m));
            }
        } else {
            lg4.j.g().n.c("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            ib4 ib42 = lg4.j.n().f;
            Objects.requireNonNull((db2) lg4.j.n);
            ib42.b(System.currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                ib4 ib43 = lg4.j.n().g;
                Objects.requireNonNull((db2) lg4.j.n);
                ib43.b(System.currentTimeMillis());
            }
            lg4.K().I(list);
            lg4.w();
        }
        lg4.r = false;
        lg4.x();
    }
}
