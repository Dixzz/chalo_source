package defpackage;

import android.content.Context;
import java.io.File;

/* renamed from: v16  reason: default package */
/* compiled from: FileStoreImpl */
public class v16 implements u16 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3584a;

    public v16(c06 c06) {
        if (c06.getContext() != null) {
            Context context = c06.getContext();
            this.f3584a = context;
            c06.getPath();
            context.getPackageName();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public File a() {
        File filesDir = this.f3584a.getFilesDir();
        if (filesDir == null || (!filesDir.exists() && !filesDir.mkdirs())) {
            return null;
        }
        return filesDir;
    }
}
