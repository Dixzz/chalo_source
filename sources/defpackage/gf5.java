package defpackage;

import android.content.Context;
import android.os.StatFs;
import defpackage.hi6;
import defpackage.ih6;
import java.io.File;

/* renamed from: gf5  reason: default package */
/* compiled from: OkHttp3Downloader */
public final class gf5 implements ue5 {

    /* renamed from: a  reason: collision with root package name */
    public final ih6.a f1254a;

    public gf5(Context context) {
        long j;
        StringBuilder sb = rf5.f3076a;
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        long max = Math.max(Math.min(j, 52428800L), 5242880L);
        hi6.a aVar = new hi6.a();
        aVar.k = new gh6(file, max);
        this.f1254a = new hi6(aVar);
    }
}
