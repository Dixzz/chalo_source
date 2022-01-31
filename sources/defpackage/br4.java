package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.File;
import java.util.Objects;

/* renamed from: br4  reason: default package */
public final class br4 extends zq4<nq4> {
    public final String i;
    public final /* synthetic */ cr4 j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public br4(cr4 cr4, ay4<nq4> ay4, String str) {
        super(cr4, new nv4("OnRequestInstallCallback"), ay4);
        this.j = cr4;
        this.i = str;
    }

    @Override // defpackage.vw4, defpackage.zq4
    public final void w1(Bundle bundle) throws RemoteException {
        this.h.f747a.b();
        this.f.b(4, "onRequestInfo", new Object[0]);
        if (bundle.getInt("error.code", -2) != 0) {
            this.g.a(new ev4(bundle.getInt("error.code", -2)));
            return;
        }
        ay4<T> ay4 = this.g;
        cr4 cr4 = this.j;
        String str = this.i;
        int i2 = bundle.getInt("version.code", -1);
        int i3 = bundle.getInt("update.availability");
        int i4 = bundle.getInt("install.status", 0);
        Integer valueOf = bundle.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle.getInt("client.version.staleness"));
        int i5 = bundle.getInt("in.app.update.priority", 0);
        long j2 = bundle.getLong("bytes.downloaded");
        long j3 = bundle.getLong("total.bytes.to.download");
        long j4 = bundle.getLong("additional.size.required");
        er4 er4 = cr4.d;
        Objects.requireNonNull(er4);
        ay4.b((T) new fr4(str, i2, i3, i4, valueOf, i5, j2, j3, j4, er4.a(new File(er4.f1020a.getFilesDir(), "assetpacks")), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"), (PendingIntent) bundle.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent")));
    }
}
