package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import defpackage.lf5;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* renamed from: mf5  reason: default package */
/* compiled from: ResourceRequestHandler */
public class mf5 extends lf5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2370a;

    public mf5(Context context) {
        this.f2370a = context;
    }

    @Override // defpackage.lf5
    public boolean c(jf5 jf5) {
        if (jf5.d != 0) {
            return true;
        }
        return "android.resource".equals(jf5.c.getScheme());
    }

    @Override // defpackage.lf5
    public lf5.a f(jf5 jf5, int i) throws IOException {
        Resources resources;
        Uri uri;
        Uri uri2;
        Context context = this.f2370a;
        StringBuilder sb = rf5.f3076a;
        if (jf5.d != 0 || (uri2 = jf5.c) == null) {
            resources = context.getResources();
        } else {
            String authority = uri2.getAuthority();
            if (authority != null) {
                try {
                    resources = context.getPackageManager().getResourcesForApplication(authority);
                } catch (PackageManager.NameNotFoundException unused) {
                    StringBuilder i0 = hj1.i0("Unable to obtain resources for package: ");
                    i0.append(jf5.c);
                    throw new FileNotFoundException(i0.toString());
                }
            } else {
                StringBuilder i02 = hj1.i0("No package provided: ");
                i02.append(jf5.c);
                throw new FileNotFoundException(i02.toString());
            }
        }
        int i2 = jf5.d;
        boolean z = true;
        if (i2 == 0 && (uri = jf5.c) != null) {
            String authority2 = uri.getAuthority();
            if (authority2 != null) {
                List<String> pathSegments = jf5.c.getPathSegments();
                if (pathSegments == null || pathSegments.isEmpty()) {
                    StringBuilder i03 = hj1.i0("No path segments: ");
                    i03.append(jf5.c);
                    throw new FileNotFoundException(i03.toString());
                } else if (pathSegments.size() == 1) {
                    try {
                        i2 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused2) {
                        StringBuilder i04 = hj1.i0("Last path segment is not a resource ID: ");
                        i04.append(jf5.c);
                        throw new FileNotFoundException(i04.toString());
                    }
                } else if (pathSegments.size() == 2) {
                    i2 = resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
                } else {
                    StringBuilder i05 = hj1.i0("More than two path segments: ");
                    i05.append(jf5.c);
                    throw new FileNotFoundException(i05.toString());
                }
            } else {
                StringBuilder i06 = hj1.i0("No package provided: ");
                i06.append(jf5.c);
                throw new FileNotFoundException(i06.toString());
            }
        }
        BitmapFactory.Options d = lf5.d(jf5);
        if (d == null || !d.inJustDecodeBounds) {
            z = false;
        }
        if (z) {
            BitmapFactory.decodeResource(resources, i2, d);
            lf5.b(jf5.f, jf5.g, d, jf5);
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i2, d);
        Picasso.d dVar = Picasso.d.DISK;
        Objects.requireNonNull(decodeResource, "bitmap == null");
        return new lf5.a(decodeResource, null, dVar, 0);
    }
}
