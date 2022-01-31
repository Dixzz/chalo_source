package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import com.urbanairship.iam.assets.Assets;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: as5  reason: default package */
/* compiled from: AssetCache */
public class as5 {

    /* renamed from: a  reason: collision with root package name */
    public final File f327a;
    public final StorageManager b;
    public final Map<String, Assets> c = new HashMap();

    public as5(Context context) {
        StorageManager storageManager;
        this.f327a = new File(context.getCacheDir(), "com.urbanairship.iam.assets");
        try {
            storageManager = (StorageManager) context.getSystemService("storage");
        } catch (Exception unused) {
            storageManager = null;
        }
        this.b = storageManager;
    }

    public Assets a(String str) {
        Assets assets;
        synchronized (this.c) {
            assets = this.c.get(str);
            if (assets == null) {
                assets = Assets.c(b(str));
                this.c.put(str, assets);
            }
        }
        return assets;
    }

    public final File b(String str) {
        if (!this.f327a.exists() && !this.f327a.mkdirs()) {
            yj5.c("Failed to create asset storage directory.", new Object[0]);
        }
        File file = new File(this.f327a, str);
        if (!file.exists() && !file.mkdirs()) {
            yj5.c("Failed to create assets directory.", new Object[0]);
        }
        if (this.b != null && Build.VERSION.SDK_INT >= 26 && file.exists()) {
            try {
                this.b.setCacheBehaviorGroup(file, true);
            } catch (IOException e) {
                yj5.e(e, "Failed to set cache behavior on directory: %s", file.getAbsoluteFile());
            }
        }
        return file;
    }

    public void c(String str, boolean z) {
        synchronized (this.c) {
            if (z) {
                hd3.D0(b(str));
            }
            this.c.remove(str);
        }
    }
}
