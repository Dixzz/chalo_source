package defpackage;

import com.urbanairship.iam.assets.Assets;
import com.urbanairship.json.JsonValue;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: cs5  reason: default package */
/* compiled from: Assets */
public class cs5 implements Runnable {
    public final /* synthetic */ Assets f;

    public cs5(Assets assets) {
        this.f = assets;
    }

    public void run() {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        Assets assets = this.f;
        File file = assets.i;
        JsonValue x = JsonValue.x(assets.j);
        assets.d();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(x.toString().getBytes());
                fileOutputStream.close();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            fileOutputStream = null;
            e = e3;
            try {
                yj5.e(e, "Failed to write metadata.", new Object[0]);
                Assets.a(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                Assets.a(fileOutputStream2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Assets.a(fileOutputStream2);
            throw th;
        }
        Assets.a(fileOutputStream);
    }
}
