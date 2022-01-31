package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import defpackage.lf5;
import java.io.IOException;

/* renamed from: me5  reason: default package */
/* compiled from: AssetRequestHandler */
public class me5 extends lf5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2364a;
    public final Object b = new Object();
    public AssetManager c;

    public me5(Context context) {
        this.f2364a = context;
    }

    @Override // defpackage.lf5
    public boolean c(jf5 jf5) {
        Uri uri = jf5.c;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    @Override // defpackage.lf5
    public lf5.a f(jf5 jf5, int i) throws IOException {
        if (this.c == null) {
            synchronized (this.b) {
                if (this.c == null) {
                    this.c = this.f2364a.getAssets();
                }
            }
        }
        return new lf5.a(ec6.y(this.c.open(jf5.c.toString().substring(22))), Picasso.d.DISK);
    }
}
